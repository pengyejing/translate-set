package com.lsj.trans;

import com.lsj.http.HttpParams;
import com.lsj.http.HttpPostParams;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class YoudaoDispatch extends Dispatch {
	static{
		YoudaoDispatch dispatch = new YoudaoDispatch();
		classMap.put("youdao", dispatch);
		classMap.put("Youdao", dispatch);
	}
	
	private YoudaoDispatch(){
		langMap.put(LANG.EN, "EN");
		langMap.put(LANG.ZH, "ZH_CN");
	}
	
	@Override
	public String Trans(LANG from, LANG targ, String query) throws Exception{
		HttpParams params = new HttpPostParams()
				.put("type", langMap.get(from)+"2"+langMap.get(targ))
				.put("i", query)
				.put("doctype", "json")
				.put("xmlVersion", "1.8")
				.put("keyfrom", "fanyi.web")
				.put("ue", "UTF-8")
				.put("action", "FY_BY_CLICKBUTTON")
				.put("typoResult", "true");
		
		return ParseString(params.Send("http://fanyi.youdao.com/translate?smartresult=dict&smartresult=rule&smartresult=ugc&sessionFrom=https://www.baidu.com/link"));
	}
	
	private String ParseString(String jsonString){
		StringBuilder result = new StringBuilder();
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		JSONArray segments = jsonObject.getJSONArray("translateResult");
		
		for(int i=0; i<segments.size(); i++){
			result.append(i==0 ? "" : "\r\n");
			JSONArray parts = jsonObject.getJSONArray("translateResult").getJSONArray(i);
			for(int j=0; j<parts.size(); j++){
				result.append(parts.getJSONObject(j).getString("tgt"));
			}
		}
		
		return new String(result);
	}
}

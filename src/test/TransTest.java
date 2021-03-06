package test;

import org.junit.Before;
import org.junit.Test;

import com.lsj.trans.Dispatch;
import com.lsj.trans.LANG;

public class TransTest {

	@Before
	public void setUp() throws Exception {
		Class.forName("com.lsj.trans.BaiduDispatch");
		Class.forName("com.lsj.trans.GoogleDispatch");
		Class.forName("com.lsj.trans.JinshanDispatch");
		Class.forName("com.lsj.trans.YoudaoDispatch");
		Class.forName("com.lsj.trans.TencentDispatch");
	}

	@Test
	public void test() throws Exception {
		String origin = "Xamarin.Forms has several layouts and features for organizing content on screen.\n Each layout control is described below, as well as details on how to handle screen orientation changes:";
		System.out.println("金山 : " + Dispatch.Instance("jinshan").Trans(LANG.EN, LANG.ZH, origin));
		System.out.println("有道 : " + Dispatch.Instance("youdao").Trans(LANG.EN, LANG.ZH, origin));
		System.out.println("百度 : " + Dispatch.Instance("baidu").Trans(LANG.EN, LANG.ZH, origin));
		System.out.println("谷歌 : " + Dispatch.Instance("google").Trans(LANG.EN, LANG.ZH, origin));
		System.out.println("腾讯 : " + Dispatch.Instance("tencent").Trans(LANG.EN, LANG.ZH, origin));
		System.out.println("\n");
		
	
		origin = "这个巡展，大家想去的先注册，临近当地巡展时候，会有注册确认邮件发给大家，届时可以看到详细的活动地址。\n等你工作了你就知道你当时的观念是多么的幼稚";
		System.out.println("金山 : " + Dispatch.Instance("jinshan").Trans(LANG.ZH, LANG.EN, origin));
		System.out.println("有道 : " + Dispatch.Instance("youdao").Trans(LANG.ZH, LANG.EN, origin));
		System.out.println("百度 : " + Dispatch.Instance("baidu").Trans(LANG.ZH, LANG.EN, origin));
		System.out.println("谷歌 : " + Dispatch.Instance("google").Trans(LANG.ZH, LANG.EN, origin));
		System.out.println("腾讯 : " + Dispatch.Instance("tencent").Trans(LANG.ZH, LANG.EN, origin));
	}

}

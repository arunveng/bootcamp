package Bootcamp.PageObjectModel.Testcases;

import org.testng.annotations.Test;

import Bootcamp.PageObjectModel.Pages.EntryPage;
import Bootcamp.PageObjectModel.baseClass.Base_class;

public class TC_1_EntryPageCheck extends Base_class{
	@Test(invocationCount=1,threadPoolSize=1)
	public void testHomePage() throws InterruptedException {
		new EntryPage().click_icon_waffle().clickViewAll();
	}

}

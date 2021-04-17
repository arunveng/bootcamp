package Bootcamp.PageObjectModel.Testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Bootcamp.PageObjectModel.Pages.EntryPage;
import Bootcamp.PageObjectModel.baseClass.Base_class;

public class TC_004_salesAccountEntry extends Base_class{
@BeforeClass
 public void getfile() {
			file = "Data";
}
@Test(dataProvider = "inputdata",threadPoolSize=3,invocationCount=1)
public void salesEntryFromExcel(String name) throws InterruptedException {

	new EntryPage().
	click_icon_waffle().
	clickViewAll().
	clickSales().
	clickAccount().
	enterAndGetnamefromNewAccount(name);
	
	
}}

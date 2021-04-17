package Bootcamp.PageObjectModel.Testcases;

import org.testng.annotations.Test;

import Bootcamp.PageObjectModel.Pages.EntryPage;
import Bootcamp.PageObjectModel.baseClass.Base_class;

public class TC_002_LegalEntityClick extends Base_class{
 @Test
 public void legalEntityEnter() throws InterruptedException {
	 new EntryPage().
	 click_icon_waffle().
	 clickViewAll().clickLegalEntity();	 
 }
}

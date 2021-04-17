package Bootcamp.PageObjectModel.Testcases;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.testng.annotations.Test;
import Bootcamp.PageObjectModel.Pages.EntryPage;
import Bootcamp.PageObjectModel.Pages.LegalEntitySortPage;
import Bootcamp.PageObjectModel.baseClass.Base_class;

public class TC_003_LegalEntitySortCheck extends Base_class {
	@Test
	public void legalList() throws InterruptedException, ParseException{
		
		List<Date> list = new EntryPage().
		 click_icon_waffle().
		 clickViewAll().
		 clickLegalEntity().
		 clickOnLastModDate().
		 getList();
		 
		
		new LegalEntitySortPage().
		verifySortedList(list);
	}

}

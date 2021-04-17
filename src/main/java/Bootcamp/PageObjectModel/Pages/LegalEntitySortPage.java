package Bootcamp.PageObjectModel.Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Bootcamp.PageObjectModel.baseClass.Base_class;

public class LegalEntitySortPage extends Base_class {
	/*public LegalEntityPage(RemoteWebDriver driver,JavascriptExecutor js) {
		this.driver=driver;
		this.js=js;
	}*/

	public LegalEntitySortPage clickOnLastModDate() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(getDriver(),50);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Last Modified Date']")));
		Actions act = new Actions(getDriver());
		Action dblclick = act.doubleClick(element).build();
		dblclick.perform();
		return this;
	}

	public List<Date> getList() throws ParseException, InterruptedException {
		Thread.sleep(8000);
		String text = getDriver().findElementByXPath("//div[@aria-live='polite']/span[@class='countSortedByFilteredBy']")
				.getText().replaceAll("\\D", "");
		int tablecount = Integer.parseInt(text);
		System.out.println(tablecount);
		Thread.sleep(4000);
		List<Date> initlist = new ArrayList<Date>();
		SimpleDateFormat dateformater = new SimpleDateFormat("MM/dd/yyyy, hh:mm a");
		for (int i = 1; i <= tablecount; i++) {
			String dateAsText = getDriver().findElementByXPath("(//table/tbody/tr/td[3])[" + i + "]").getText();
			// System.out.println(dateAsText);
			Date convToDate = dateformater.parse(dateAsText);
			initlist.add(convToDate);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].scrollIntoView();",driver.findElementByXPath("(//table/tbody/tr/td[3])["+(i+1)+"]"));
			js.executeScript("arguments[0].scrollIntoView();", getDriver().findElementByXPath(
					"//table[contains(@class,'slds-table forceRecordLayout')]//td/following::span[contains(@class,'uiOutputDateTime')]["
							+ i + "]"));
		}
		System.out.println("====================================================================================================================");
		System.out.println("------------------------------------------Initial list is-----------------------------------------------------------");
		System.out.println(initlist);
		Collections.sort(initlist);
		System.out.println("====================================================================================================================");
		System.out.println("--------------------------------------------After sorted the list is------------------------------------------------");
		System.out.println(initlist);
		return initlist;
	}

	public LegalEntitySortPage verifySortedList(List<Date> list) throws InterruptedException, ParseException {
		String text = getDriver().findElementByXPath("//div[@aria-live='polite']/span[@class='countSortedByFilteredBy']")
				.getText().replaceAll("\\D", "");
		int tablecount = Integer.parseInt(text);
		System.out.println(tablecount);
		WebElement element = getDriver().findElementByXPath("//span[@title='Last Modified Date']");
		Actions act = new Actions(getDriver());
		Action dblclick = act.doubleClick(element).build();

		dblclick.perform();
		Thread.sleep(3000);
		SimpleDateFormat dateformater = new SimpleDateFormat("MM/dd/yyyy, hh:mm a");
		List<Date> sortedlist = new ArrayList<Date>();
		for (int i = 1; i <= tablecount; i++) {
			String dateAsText = getDriver().findElementByXPath("//table/tbody/tr[" + i + "]/td[3]").getText();
			Date convToDate = dateformater.parse(dateAsText);
			sortedlist.add(convToDate);
			Thread.sleep(8000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", getDriver().findElementByXPath(
					"//table[contains(@class,'slds-table forceRecordLayout')]//td/following::span[contains(@class,'uiOutputDateTime')]["
							+ i + "]"));
		}
		System.out.println("Verified list is" + sortedlist);

		if (list.equals(sortedlist)) {
			System.out.println("Legal Entities displayed in ascending order by Last Modified Date");

		} else {
			System.out.println("Sorry!!Legal Entities are not displayed in ascending order by Last Modified Date");
		}

		return this;

	}
}

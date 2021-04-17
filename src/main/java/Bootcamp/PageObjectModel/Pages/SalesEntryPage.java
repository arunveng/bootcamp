package Bootcamp.PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Bootcamp.PageObjectModel.baseClass.Base_class;

public class SalesEntryPage extends Base_class{
	
	public SalesEntryPage clickAccount() throws InterruptedException {
		Thread.sleep(9000);
		/*WebDriverWait wait=new WebDriverWait(getDriver(),90);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Accounts']")));
		*/
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement path2 = getDriver().findElementByXPath("//a[@title='Accounts']");
		js.executeScript("arguments[0].click();", path2);
		//element.click();
		return this;
}
	
	public SalesEntryPage enterAndGetnamefromNewAccount(String name) throws InterruptedException {
		Thread.sleep(9000);
		getDriver().findElementByXPath("//div[text()='New']").click();
		Thread.sleep(5000);
		getDriver().findElementByXPath("//input[@name='Name']").sendKeys(name);
		Thread.sleep(3000);
		WebElement in = getDriver().findElementByXPath("//input[@name='Name']");
		String input = in.getAttribute("value");
		System.out.println(input);
		Thread.sleep(3000);
		WebElement combo = getDriver().findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[5]");
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].scrollIntoView();", combo);
		getDriver().findElementByXPath("(//input[@class=\"slds-input slds-combobox__input\"])[5]").click();
		Thread.sleep(3000);
		getDriver().findElementByXPath("//lightning-base-combobox-item[@data-value='Public']").click();
		Thread.sleep(3000);
		getDriver().findElementByXPath("//button[@name='SaveEdi"
				+ "t']").click();
		Thread.sleep(3000);
		String text = getDriver().findElementByXPath("//span[@data-aura-class='forceActionsText']").getText();
		Thread.sleep(1000);
		System.out.println(text);
		return this;
		}}
	
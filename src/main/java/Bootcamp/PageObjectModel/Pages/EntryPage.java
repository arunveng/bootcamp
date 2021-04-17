package Bootcamp.PageObjectModel.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Bootcamp.PageObjectModel.baseClass.Base_class;

public class EntryPage extends Base_class{
/*
	public Homepage(RemoteWebDriver driver,JavascriptExecutor js) {
		this.driver=driver;
		this.js=js;
	}
*/
	public EntryPage click_icon_waffle() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(getDriver(),50);
		/*WebElement s = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
		jsexecutor.executeScript("arguments[0].click();",s);*/
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-icon-waffle']/parent::div")));
		element.click();
		return this;
		//return new Homepage();
		}
	
	public AppLauncher clickViewAll() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(getDriver(),50);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='slds-button']")));
		element.click();
		return new AppLauncher();
		 
		}
	
	
	
	
	
}

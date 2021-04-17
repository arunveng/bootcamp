package Bootcamp.testng;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Newtest1 extends Base_class {
	@Test(groups="smoke")
	public void Accounts() throws InterruptedException 
	{
    Thread.sleep(9000);
	driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	Thread.sleep(5000);
	driver.findElementByXPath("//button[@class='slds-button']").click();
	Thread.sleep(1000);
	WebElement path = driver.findElementByXPath("//p[text()='Sales']");
	JavascriptExecutor exe= (JavascriptExecutor) driver;
	exe.executeScript("arguments[0].click()", path);
	Thread.sleep(3000);
	
}
}
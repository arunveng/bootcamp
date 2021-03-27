package Bootcamp.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Newtest1 extends Base_class {
	@Test(priority=3)
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
	WebElement path2 = driver.findElementByXPath("//a[@title='Accounts']");
	JavascriptExecutor exe2= (JavascriptExecutor) driver;
	exe2.executeScript("arguments[0].click()", path2);
	
}
}
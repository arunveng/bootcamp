package Bootcamp.testng;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class SAL_08 extends Base_class {
	@Test(groups="functional")//(dependsOnMethods="Bootcamp.testng.Testngtest.main")
public void basic() throws InterruptedException 
{
		
	Thread.sleep(9000);
    driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	Thread.sleep(8000);
	driver.findElementByXPath("//button[@class='slds-button']").click();
	Thread.sleep(1000);
	WebElement path = driver.findElementByXPath("//p[text()='Sales']");
	JavascriptExecutor exe= (JavascriptExecutor) driver;
	exe.executeScript("arguments[0].click()", path);
	Thread.sleep(3000);
	
	}
	
}


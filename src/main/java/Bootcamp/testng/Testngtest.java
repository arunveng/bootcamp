package Bootcamp.testng;

import org.testng.annotations.Test;
import java.text.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Testngtest extends Base_class {
	@Test(priority=1)
	public void main() throws InterruptedException, ParseException {
		Thread.sleep(9000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		WebElement s = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
		executor.executeScript("arguments[0].click();",s);
		Thread.sleep(5000);

		driver.findElementByXPath("//button[@class='slds-button']").click();
		Thread.sleep(5000);

		WebElement scroll = driver.findElementByXPath("//p[text()='Legal Entities']");
		executor.executeScript("arguments[0].scrollIntoView();", scroll);
		Thread.sleep(1000);

		driver.findElementByXPath("//p[text()='Legal Entities']").click();
		Thread.sleep(3000);

		WebElement element = driver.findElementByXPath("//span[@title='Last Modified Date']");
		Actions act = new Actions(driver);
		Action dblclick = act.doubleClick(element).build();
		dblclick.perform();

	}
}

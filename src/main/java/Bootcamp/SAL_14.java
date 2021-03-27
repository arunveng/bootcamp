package Bootcamp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

@Test
public class SAL_14 extends Base_class {
	public void main() throws InterruptedException {

		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[@class='slds-button']").click();
		Thread.sleep(1000);
		WebElement scroll = driver.findElementByXPath("//p[text()='Legal Entities']");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", scroll);

		Thread.sleep(1000);
		driver.findElementByXPath("//p[text()='Legal Entities']").click();
		Thread.sleep(3000);

		WebElement search = driver.findElementByXPath("//input[@name='LegalEntity-search-input']");
		JavascriptExecutor execut = (JavascriptExecutor) driver;
		execut.executeScript("arguments[0].click();", search);

		search.sendKeys("Salesforce Automation by Arun Vengat");
		driver.findElementByXPath("//input[@name='LegalEntity-search-input']").sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		driver.findElementByXPath("//table//*[@data-key='down']/parent::lightning-primitive-icon").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@title='Edit']/parent::a").click();
		Thread.sleep(1000);
		driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys("Testleaf");
		Thread.sleep(1000);
		driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Salesforce");
		driver.findElementByXPath("//a[@class='select']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//a[@title='Active']").click();

		driver.findElementByXPath("(//span[text()='Save'])[2]").click();

		Thread.sleep(1000);
		driver.findElementByXPath("//table//a[@title='Salesforce Automation by Arun Vengat']").click();
		Thread.sleep(1000);
		WebElement textt = driver.findElementByXPath("//span[text()='Active']/parent::span");
		Thread.sleep(1000);
		String texttoverify = textt.getText();
		System.out.println(texttoverify);

		Thread.sleep(1000);
		if (texttoverify.equalsIgnoreCase("Active")) {
			System.out.println("Status is Active");
		}

		else {
			System.out.println("Status is not active");
		}
		driver.close();
	}

}

package Bootcamp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class SAL_13 extends Base_class {
	public void main() throws InterruptedException {

		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[@class='slds-button']").click();
		Thread.sleep(1000);
		WebElement scroll = driver.findElementByXPath("//p[text()='Legal Entities']");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", scroll);

		Thread.sleep(1000);
		driver.findElementByXPath("//p[text()='Legal Entities']").click();
		Thread.sleep(6000);
		WebElement legnrdrp = driver
				.findElementByXPath("//*[@data-key='close']/ancestor::button/preceding-sibling::a/span");
		JavascriptExecutor exe3 = (JavascriptExecutor) driver;
		exe3.executeScript("arguments[0].click()", legnrdrp);
		Thread.sleep(1000);
		driver.findElementByXPath("((//*[@data-key='chevrondown'])[14])/parent::lightning-primitive-icon").click();
		Thread.sleep(3000);
		WebElement click = driver.findElementByXPath("//span[text()='New Legal Entity']");
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", click);
		WebElement input = driver.findElementByXPath("(//input[@class=' input'])[1]");
		input.sendKeys("Salesforce Automation by Arun Vengat");
		String inputname = input.getText();

		driver.findElementByXPath("(//span[text()='Save'])[2]").click();
		WebElement text = driver.findElementByXPath("(//input[@type='text'])[3]");
		// WebElement text =
		// driver.findElementByXPath("//span[contains(@class,'toastMessage')]");
		String text2 = text.getText();
		System.out.println(text2);

		if (text2.contentEquals(inputname)) {
			System.out.println("correct");

		} else {
			System.out.println("Incorrect");
		}
		driver.close();
	}
}

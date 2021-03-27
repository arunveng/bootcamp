package Bootcamp;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class SAL_08 {
public static void main(String[] args) throws InterruptedException 
{
	//System.setProperty("wedriver.chrome.driver", "./driver/chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--disable-notifications");
	ChromeDriver driver=new ChromeDriver(opt);
	driver.get("https://login.salesforce.com");
	driver.manage().window().maximize();
	driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
	driver.findElementById("password").sendKeys("Bootcamp$123");
	driver.findElementById("Login").click();
    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
   
    
	driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
	driver.findElementByXPath("//button[@class='slds-button']").click();
	Thread.sleep(1000);
	WebElement path = driver.findElementByXPath("//p[text()='Sales']");
	JavascriptExecutor exe= (JavascriptExecutor) driver;
	exe.executeScript("arguments[0].click()", path);
	Thread.sleep(3000);
	WebElement path2 = driver.findElementByXPath("//a[@title='Accounts']");
	JavascriptExecutor exe2= (JavascriptExecutor) driver;
	exe2.executeScript("arguments[0].click()", path2);
	
	Thread.sleep(1000);
	driver.findElementByXPath("//div[text()='New']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//input[@name='Name']").sendKeys("Arun");
	Thread.sleep(3000);
	WebElement in=driver.findElementByXPath("//input[@name='Name']");
    String input = in.getAttribute("value");
	
	System.out.println(input);
	WebElement combo = driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[5]");
	JavascriptExecutor exec= (JavascriptExecutor) driver;
	exec.executeScript("arguments[0].scrollIntoView()", combo);
	
	/*WebElement element = driver.findElementByXPath("(//input[@class='slds-input slds-combobox__input'])[5]");
	
	Actions act=new Actions(driver);
	act.moveToElement(element).click();	*/
	driver.findElementByXPath("(//input[@class=\"slds-input slds-combobox__input\"])[5]").click();
	driver.findElementByXPath("//lightning-base-combobox-item[@data-value='Public']").click();
	driver.findElementByXPath("//button[@name='SaveEdit']").click();
	String text = driver.findElementByXPath("//span[@data-aura-class='forceActionsText']").getText();
	Thread.sleep(1000);
	System.out.println(text);
	if(text.contains(input)) {
		System.out.println("Text is same");
	}
	else {
		System.out.println("Text is not same");
		}
	driver.close();
	
	}
	
}


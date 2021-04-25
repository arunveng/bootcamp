package com.qa.stepdef.assessment;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Bootcamp.PageObjectModel.baseClass.Base_class;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Assessment_stepdef extends Base_class{
	


@Given("Click on AppLauncher button and click view all")
public void click_on_app_launcher_button_and_click_view_all() throws InterruptedException {
	
	Thread.sleep(4000); 
	JavascriptExecutor js = (JavascriptExecutor)driver;	
	WebElement s = driver.findElementByXPath("//div[@class='slds-icon-waffle']");
	js.executeScript("arguments[0].click();",s);
	Thread.sleep(5000);
	getDriver().findElementByXPath("//button[@class='slds-button']").click();
	
}

@Then ("Click Service Console from App Launcher")
public void click_serviceconsole() throws InterruptedException {
	getDriver().findElementByXPath("//p[text()='Service Console']").click();
	Thread.sleep(8000);
}

@Then ("Select Files from the DropDown")
public void selectFilesFromDropdown() throws InterruptedException {
	getDriver().findElementByXPath("//button[@aria-label='Show Navigation Menu']").click();
	Thread.sleep(8000);
	getDriver().findElementByXPath("//span[text()='Files']/ancestor::a[@class='menuItem']").click();
	Thread.sleep(5000);
}
@Then("Click on the latest modified item link")
public void click_on_the_latest_modified_item_link() throws InterruptedException {
	getDriver().findElementByXPath("//table//span[@title='Last Modified Date']").click();
	//getDriver().findElementByXPath("//table//span[@title='Last Modified Date']").click();
	Thread.sleep(8000);
	//List<WebElement> list = new ArrayList<WebElement>();
	List<WebElement> list = getDriver().findElementsByXPath("//table/tbody/tr/td[4]");
	WebElement webElement = list.get(0);
	webElement.click();
   // getDriver().findElementByXPath("//table//a[@title='Show 7 more actions']/ancestor::td").click();
    Thread.sleep(3000);
}

@Then ("Click on Public link")
public void clickOnPublicLink() throws InterruptedException {
	
	Thread.sleep(3000);
	getDriver().findElementByXPath("//a[@title='Public Link']").click();
}

@Then ("Verify the new link text field is disabled to create public link")
public void verifyLinktextfieldDisabled() throws InterruptedException {
	Thread.sleep(3000);
	WebElement linkdisabled = getDriver().findElementByXPath("//input[@name='publicLinkURL']");
	String text = linkdisabled.getText();
	System.out.println(text);
	if(text!="No public link created") {
		System.out.println("Link is disabled");
		
	}else if(text=="No public link created") {
		System.out.println("Link is enabled");
	}
	Thread.sleep(3000);
	//getDriver().findElementByXPath("//button[@title='Close this window']").click();
	getDriver().findElementByXPath("//button[@title='Create Link']").click();
	Thread.sleep(3000);
	getDriver().findElementByXPath("//span[text()='Create']").click();
	Thread.sleep(3000);
	getDriver().findElementByXPath("//button[@title='Copy Link']").click();
	Thread.sleep(3000);
	getDriver().findElementByXPath("//button[@title='Close this window']").click();
}

@Then("Download the file into a specified folder inside the project")

public void downloadFiletoSpecificFolder() throws InterruptedException, AWTException {
	Thread.sleep(7000);
 
    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_N);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_N);


    Set<String> windowHandles = getDriver().getWindowHandles();
    List<String> window=new ArrayList<String>(windowHandles);
    String myNewWin = window.get(1);
    getDriver().switchTo().window(myNewWin);
    

    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
	Thread.sleep(7000);
	 
	/*List<WebElement> list = getDriver().findElementsByXPath("//table/tbody/tr/td[4]");
	WebElement webElement = list.get(0);
	webElement.click();
	getDriver().findElementByXPath("//a[@title='Download']").click();*/
}

		







}
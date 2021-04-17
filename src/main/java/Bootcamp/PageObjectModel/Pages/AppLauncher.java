package Bootcamp.PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Bootcamp.PageObjectModel.baseClass.Base_class;


public class AppLauncher extends Base_class{
	
	public SalesEntryPage clickSales() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(getDriver(),50);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']")));
		element.click();
		//WebElement path = getDriver().findElementByXPath("//p[text()='Sales']");
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click()", path);
		return new SalesEntryPage();
	}
	
	public LegalEntitySortPage clickLegalEntity() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		WebDriverWait wait=new WebDriverWait(getDriver(),50);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Legal Entities']")));
		//WebElement scroll = getDriver().findElementByXPath("//p[text()='Legal Entities']");
		js.executeScript("arguments[0].scrollIntoView();",element);
		element.click();
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver()).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(30))
				.ignoring(StaleElementReferenceException.class);*/
		//wait.until(ExpectedConditions.stalenessOf(lglclk));
		return new LegalEntitySortPage();
          
		}
}

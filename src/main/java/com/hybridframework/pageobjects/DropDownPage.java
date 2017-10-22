package com.hybridframework.pageobjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybridframework.testbase.BrowserFactory;
import com.hybridframework.testbase.Enums.DropDown;


public class DropDownPage extends BrowserFactory {

   private final WebDriver driver = super.driver;
   
   @FindBy(how=How.LINK_TEXT,using="Input Forms") public WebElement inputForm; 
   @FindBy(how=How.CSS,using="a[href*='basic-select-dropdown-demo.html']") private WebElement dropdownForm;
   @FindBys(@FindBy(how=How.CSS,using="input[type='radio']")) private List<WebElement> radioButtons;
   @FindBy(how=How.ID,using="select-demo") private WebElement dpnDay;
   @FindBy(how=How.ID,using="multi-select") private WebElement dpnCountry;
   @FindBys(@FindBy(how=How.CSS,using="input[name='gender']")) private List<WebElement> rdngender;
   @FindBys(@FindBy(how=How.CSS,using="input[name='ageGroup']")) private List<WebElement> rdnageGroup;
   @FindBy(how=How.ID,using="buttoncheck") public WebElement getMessageButton; 
   @FindBy(how=How.CSS,using="p[class='selected-value']") private WebElement displayMessage1;
   
   public void gotToDropDownPage() {
		super.executeJavaScript("window.scrollTo(0,0)", driver);
		inputForm.click();
	    dropdownForm.click();
	    WebDriverWait wait = new WebDriverWait(driver,60);
	    wait.until(ExpectedConditions.visibilityOf(dpnDay));
	}
   
   public void selectCountry(String day) {
	 super.executeJavaScript("window.scrollTo(0,100)", driver);
	 super.selectFromDropDown(dpnDay, day,  DropDown.VALUE);
	  System.out.println(displayMessage1.getText());
   }
   
  public void multiSelect() {
	  super.executeJavaScript("window.scrollTo(0,300)", driver);
	  Actions action = new Actions (driver);
	  action.moveToElement(dpnCountry).clickAndHold().sendKeys(Keys.SHIFT.ARROW_DOWN).build().perform();
     
  }
   
   
}

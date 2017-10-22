package com.hybridframework.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybridframework.testbase.BrowserFactory;



public class RadioButtonPage extends BrowserFactory {

   private final WebDriver driver = super.driver;
   
   @FindBy(how=How.LINK_TEXT,using="Input Forms") public WebElement inputForm; 
   @FindBy(how=How.CSS,using="a[href*='basic-radiobutton-demo.html']") private WebElement radioButton;
   @FindBys(@FindBy(how=How.CSS,using="input[type='radio']")) private List<WebElement> radioButtons;
   @FindBy(how=How.CSS,using="button[onclick='getValues();']") private WebElement btnGetValues;
   @FindBys(@FindBy(how=How.CSS,using="input[name='gender']")) private List<WebElement> rdngender;
   @FindBys(@FindBy(how=How.CSS,using="input[name='ageGroup']")) private List<WebElement> rdnageGroup;
   @FindBy(how=How.ID,using="buttoncheck") public WebElement getMessageButton; 
   @FindBy(how=How.CSS,using="p[class='radiobutton']") private WebElement displayMessage1;
   @FindBy(how=How.CSS,using="p[class='groupradiobutton']") private WebElement displayMessage2;
   
   
   
   public void gotToRadioButtonPage() {
		super.executeJavaScript("window.scrollTo(0,0)", driver);
		inputForm.click();
	    radioButton.click();
	    WebDriverWait wait = new WebDriverWait(driver,60);
	    wait.until(ExpectedConditions.visibilityOf(getMessageButton));
	}
   
   public void getListOfRadioButtonsPresent() {
	   
	   List<String> radios = new ArrayList<>();
	   
	   for (WebElement radio : radioButtons) {
		   radios.add(radio.getAttribute("value"));
	   }
	   radios.forEach(e ->System.out.println(e));
   }
   
   public String toggleGender(String toMatch) {
	   super.executeJavaScript("window.scrollBy(0,100)", driver);
 	   super.selectFromRadioButton(radioButtons, toMatch);
 	   getMessageButton.click();
 	   String text = displayMessage1.getText();
 	   System.out.println(text);
 	  super.executeJavaScript("window.scrollTo(0,0)", driver);
 	   return  text;
   }
   
   public String[] toggleMultipleRadioButtons(String param1 , String param2) {
	   
	   super.executeJavaScript("window.scrollTo(0,250)", driver);
	   super.selectFromRadioButton(rdngender, param1);
	   super.selectFromRadioButton(rdnageGroup, param2);
	   
	   btnGetValues.click();
	   String text = displayMessage2.getText();
	   String[] texts = text.split("<br>");
	   for (String content : texts) {
		   System.out.println(content);
	   }
	   super.executeJavaScript("window.scrollTo(0,0)", driver);
	   return texts;
   }
}

package com.hybridframework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybridframework.testbase.BrowserFactory;



public class CheckBoxPage extends BrowserFactory {

   private final WebDriver driver = super.driver;
   
   @FindBy(how=How.CSS,using="input[id='user-message']") private WebElement inputBox;
   @FindBy(how=How.CSS,using="a[href='./basic-checkbox-demo.html']") private WebElement checkBoxDemo;
   @FindBy(how=How.LINK_TEXT,using="Input Forms") public WebElement inputForm; 
   @FindBy(how=How.ID,using="isAgeSelected") private WebElement simpleCheckBox;
   @FindBy(how=How.ID,using="txtAge") private WebElement message;
   @FindBy(how=How.CSS,using="input[type='button']") private WebElement buttonCheckBox;
   @FindBys(@FindBy(how=How.CLASS_NAME,using="cb1-element")) private List<WebElement> checkBoxGroup;
   
	
	public void gotToCheckBoxPage() {
		super.executeJavaScript("window.scrollTo(0,0)", driver);
		inputForm.click();
	    checkBoxDemo.click();
	    WebDriverWait wait = new WebDriverWait(driver,60);
	    wait.until(ExpectedConditions.visibilityOf(simpleCheckBox));
	}
	
	public void scrollToMultipleCheckBoxForm() {
		boolean flag = true ;
		int i = 1; // number of retries
		while (flag && i <=5) {
			super.executeJavaScript("window.scrollBy(0,50)", driver);
			try {
				flag = buttonCheckBox.isDisplayed();
			} catch (Exception e) {
				flag = false;
			}
			i++ ;
		}
	}
	
	public void toggleCheckBox () {
	    super.toggleCheckBox(simpleCheckBox);
	}
	public String getTitleDisplayed () {
		 return message.getText();
	}
	
	public String getButtonText() {
		return buttonCheckBox.getAttribute("value");
	}
	
	public  void clickButton() {
		buttonCheckBox.click();
	}
	
	public boolean isAllCheckBoxOptionsSelected () {
		for (WebElement ele :  checkBoxGroup) {
		  if (ele.isSelected()) {
				continue;
			} else {
				return false;
		    }
		}
		return true;
	}

}

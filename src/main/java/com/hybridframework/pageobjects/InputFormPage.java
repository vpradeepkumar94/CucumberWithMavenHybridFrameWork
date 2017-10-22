package com.hybridframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybridframework.testbase.BrowserFactory;


public class InputFormPage extends BrowserFactory {

	 private final WebDriver driver = super.driver;
	
	@FindBy(how=How.ID ,using ="q")  private WebElement txtSearchBox;
	@FindBy(how=How.CSS,using="css") private WebElement sample;
	@FindBy(how=How.CSS,using="input[id='user-message']") private WebElement inputBox;
	@FindBy(how=How.CSS,using="button[onclick*='showInput()']") private WebElement showMessage; 
	@FindBy(how=How.CSS,using="span[id='display']") private WebElement messageDisplayed;
	@FindBy(how=How.CSS,using="input[id='sum1']") private WebElement sum1;
	@FindBy(how=How.CSS,using="input[id='sum2']") private WebElement sum2;
	@FindBy(how=How.CSS,using="button[onclick='return total()']") private WebElement getTotal;
	@FindBy(how=How.CSS,using="span[id='displayvalue']") private WebElement displayvalue;
	
	@FindBy(how=How.CSS,using="a[href='./basic-first-form-demo.html']") private WebElement simpleFormDemo;
	@FindBy(how=How.CSS,using="a[href='./basic-radiobutton-demo.html']") private WebElement radioButtons;
	@FindBy(how=How.CSS,using="a[href='./basic-select-dropdown-demo.html']") private WebElement dropdowns;
	@FindBy(how=How.CSS,using="a[href='./input-form-demo.html']") private WebElement inputFormDemo;
	@FindBy(how=How.CSS,using="a[href='./ajax-form-submit-demo.html']") private WebElement ajaxSubmitForm;
	@FindBy(how=How.CSS,using="a[href='./jquery-dropdown-search-demo.html']") private WebElement jQueryDropDownSelector;
	@FindBy(how=How.CSS,using="a[href='./basic-checkbox-demo.html']") private WebElement checkBoxDemo;

	final public  void launchURL(String URL) {
		driver.get(URL);
 	}
 
	final public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void enterText(String text) {
		inputBox.sendKeys(text);
		showMessage.click();
	}
	
    public String getTextEntered() {
		return messageDisplayed.getText();
	}
	
    public int  findTheSumeOfTwoNumbers (int a , int b) {
    	
     	String num1 = Integer.toString(a);
    	String num2 = Integer.toString(b);
        	
    	sum1.clear();
    	sum1.sendKeys(num1);
    	sum2.clear();
    	sum2.sendKeys(num2);
    	getTotal.click();
    	String  sum = displayvalue.getText();
    	int total;
    	
    	try {
    		total = Integer.parseInt(sum);
    	} catch (NumberFormatException e) {
    		total = 0;
    	}
    	return total;
    	
    }
    
    public void waitForInputFormPageToBeLoaded() {
    	WebDriverWait wait = new WebDriverWait(driver,60);
    	wait.until(ExpectedConditions.visibilityOf(inputBox));
    }
    
    
}

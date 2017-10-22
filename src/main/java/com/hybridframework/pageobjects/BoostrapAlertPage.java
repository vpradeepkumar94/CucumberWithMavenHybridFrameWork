package com.hybridframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hybridframework.testbase.BrowserFactory;


public class BoostrapAlertPage extends BrowserFactory {

   private final WebDriver driver = BrowserFactory.driver;
   

   @FindBy(how=How.PARTIAL_LINK_TEXT,using="Alerts & Modals") public WebElement alerts;
   @FindBy(how=How.CSS,using="a[href*='bootstrap-alert-messages-demo.html']") private WebElement alertsAndModals;
   @FindBy(how=How.TAG_NAME,using="h2") private WebElement header;
   @FindBy(how=How.ID,using="autoclosable-btn-success") private WebElement autoClosableAlert;
   @FindBy(how=How.ID,using="normal-btn-success") private WebElement normalAlertSuccess;
   @FindBy(how=How.ID,using="autoclosable-btn-warning") private WebElement autoCloselWarningBtn;
   @FindBy(how=How.ID,using="normal-btn-warning") private WebElement normalWarningBtn;
   @FindBy(how=How.ID,using="autoclosable-btn-danger") private WebElement autoCloseDangerBtn;
   @FindBy(how=How.ID,using="normal-btn-danger") private WebElement normalDangerBtn;
   @FindBy(how=How.ID,using="autoclosable-btn-info") private WebElement autoCloseInfoBtn;
   @FindBy(how=How.ID,using="normal-btn-info") private WebElement normalInfoBtn;
	
   
   public void gotoAlertsAndModalsPage() {
	   super.executeJavaScript("window.scrollTo(0,100)", driver);
	   alerts.click();
	   alertsAndModals.click();
	   WebDriverWait wait = new WebDriverWait(driver,60);
	   wait.until(ExpectedConditions.visibilityOf(header));
   }
   
   public void clickAutoClosableAlert() {
	   autoClosableAlert.click();
	   try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
   }
   
   
   
}

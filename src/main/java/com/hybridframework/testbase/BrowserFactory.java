package com.hybridframework.testbase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.hybridframework.miscellaneous.Utils;
import com.hybridframework.testbase.Interfaces.BrowserConsumables;

  public  class BrowserFactory extends Base implements BrowserConsumables  {

	 protected  static  WebDriver driver;
	
	 private final Logger Log = Utils.getLogger(BrowserFactory.class);
	 
 	 private static final  Map<String,WebDriver> browsers = new HashMap<String,WebDriver>();

	@Override
	 public  void initBrowser(String browserName) {
		
		browserName = browserName.toLowerCase(); 
		System.out.println("came inside BF");
		switch(browserName) {
		
		case "firefox":
			            try { System.out.println("ff");
			            	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/src/main/resources/Drivers/geckodriverv16.1_32.exe");
						      driver = new FirefoxDriver();
						      browsers.put(browserName, driver);
			            } catch (Exception e) {
			            	  System.out.println("Unable to initialise browser,Please see log report for more detailed information");
			            	  Log.error("Error occured while creating browser Instance " + e);
			            }
			 		    break;
		
		case "internetexplorer":
						 try {
			            	  System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "/src/main/resources/Drivers/geckodriverv16.1_32.exe");
						      driver = new InternetExplorerDriver();
						      browsers.put(browserName, driver);
			            } catch (Exception e) {
			            	  System.out.println("Unable to initialise browser,Please see log report for more detailed information");
			            	  Log.error("Error occured while creating browser Instance" + e);
			            }
						break;
		default: 
	     				 try { System.out.println("ch");
		 	            	  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver2.30.exe");
						      driver = new ChromeDriver();
						      driver.manage().window().maximize();
						      browsers.put(browserName, driver);
			            } catch (Exception e) {
			            	  System.out.println("Unable to initialise browser,Please see log report for more detailed information");
			            	  Log.error("Error occured while creating browser Instance " + e);
			            }
 		                break;
		}
		
	}

	@Override
	 public  void closeAllBrowsers() {
		System.out.println(browsers.size());
		Iterator<Entry<String, WebDriver>> itr = browsers.entrySet().iterator();
		while(itr.hasNext())
		{
		   Entry<String, WebDriver> entry = itr.next();
		   System.out.println(entry.getValue().toString());
		   WebDriver browser = entry.getValue();
		   browser.close();
		   browser.quit();
		   System.out.println("Key : "+entry.getKey()+" Removed.");
		      itr.remove();  // Call Iterator's remove method.
		}
//		for( Map.Entry<String, WebDriver> driver :browsers.entrySet()) {
//			
//			try {
//				System.out.println(browsers.get(driver.getKey()));
//			      browsers.get(driver.getKey()).close();
//			      System.out.println("before quit & after close");
//			      browsers.get(driver.getKey()).quit();
//			      System.out.println("after quit");
//			} catch (Exception e) {
//				 System.out.println("unable to terminate the browser Instance "+ driver.getKey() + 
//						 " Please see log report "	+ "for more details ");
//				 Log.error("Error occured while closing instance of browser "+ e);
//			} finally {
//				if(browsers != null) {
//				    browsers.clear();
//				}
//			}
		}
	

	@Override
	 public WebDriver getDriver(String browserName) throws Exception  {
		 
		 if(driver == null) {
			throw new Exception("Browser is not initialized,Please initialise browser by calling init browser");
		 }
		return browsers.get(browserName.toLowerCase());
	 }
	
	 public static WebDriver getDefaultDriver()   {
		 
		 if(driver == null) {
			try {
				throw new Exception("Browser is not initialized,Please initialise browser by calling init browser");
			} catch (Exception e) {
				e.printStackTrace();
			}
		 }
		 if(driver == null) System.out.println("driver is null in BF page");
			else System.out.println("driver is not null in Bf page");
			if(driver instanceof  ChromeDriver)
				System.out.println("chrome driver instance in BF page");
			if(driver instanceof  FirefoxDriver)
				System.out.println("firefox driver instance in BF page");
		return driver;
	 }

	@Override
	 public void captureScreenShot(String fileName,WebDriver driver) {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destFile = new File(System.getProperty("user.dir") + "/src/main/resources/ScreenShots/" + (Utils.getDate() + fileName+".png"));
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
			   System.out.println(e);
			}
		}
		
	}
	


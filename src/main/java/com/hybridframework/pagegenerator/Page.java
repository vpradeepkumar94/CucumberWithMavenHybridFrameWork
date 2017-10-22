package com.hybridframework.pagegenerator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hybridframework.pageobjects.*;
import com.hybridframework.testbase.BrowserFactory;

public class Page extends BrowserFactory {

	private static WebDriver driver = BrowserFactory.driver;

	/**
	 * Specify all the Page Objects Classes here
	 */
	public static HomePage homePage;
	public static InputFormPage inputFormPage;
	public static CheckBoxPage checkBoxPage;
	public static RadioButtonPage radioButtonPage;
	public static DropDownPage dropDownPage;
	public static BoostrapAlertPage bootsrapAlertPage;

	/**
	 * Get the instances for Page object class here
	 */
	static {
		homePage = getPageInstance(HomePage.class);
		inputFormPage = getPageInstance(InputFormPage.class);
		checkBoxPage = getPageInstance(CheckBoxPage.class);
		radioButtonPage = getPageInstance(RadioButtonPage.class);
		dropDownPage = getPageInstance(DropDownPage.class);
		bootsrapAlertPage = getPageInstance(BoostrapAlertPage.class);
	}

	/**
	 * Returns the Page Object instance After initializing the Web Elements
	 * 
	 * @param clazz
	 *            Page Object Class
	 * @return Instance of Page Object class with Drivers initialized
	 */
	private static <T> T getPageInstance(Class<T> clazz) {
		T instance = PageFactory.initElements(driver, clazz);
		return instance;
	}

}

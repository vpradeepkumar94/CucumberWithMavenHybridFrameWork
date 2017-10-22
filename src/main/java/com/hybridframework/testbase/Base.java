package com.hybridframework.testbase;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hybridframework.testbase.Enums.DropDown;
import com.hybridframework.testbase.Interfaces.CommonConsumable;

public class Base implements CommonConsumable {
	
	@Override
	public void selectFromRadioButton(List<WebElement> elements, String toSelect) {
		for (WebElement radio : elements) {
			 String value =  radio.getAttribute("value");
		     if( value.equalsIgnoreCase(toSelect)) {
		    	 radio.click();
		     }
	 	   }
	}

	@Override
	public void selectFromDropDown(WebElement elem, String toSelect,
			DropDown drp) {
		Select select = new Select(elem);
		switch (drp) {
			case BY_INDEX:
			 	select.selectByIndex(Integer.parseInt((toSelect)));
				break;
			case VALUE:
				select.selectByValue(toSelect);
				break;
			case VISBILE_TEXT:
				select.selectByVisibleText(toSelect);
				break;
			default:
				select.selectByIndex(0);
				break;
		}		
	}

	@Override
	public void selectCheckBox(List<WebElement> elements, String... toSelect) {
	  // code to toggle checkbox
	}
	protected void toggleCheckBox(WebElement ele) {
		
		 if (ele.isSelected()) {
			 System.out.println("Element is already Selected");
		 } else {
			 ele.click();
		 }
		}
		
		public void executeJavaScript(String script , WebDriver driver) {
			JavascriptExecutor js  =  (JavascriptExecutor ) driver;
			js.executeScript(script);
		}
}


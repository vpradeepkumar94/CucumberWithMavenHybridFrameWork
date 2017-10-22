package com.hybridframework.testbase.Interfaces;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.hybridframework.testbase.Enums.DropDown;

public interface CommonConsumable {

	 void selectFromRadioButton(List<WebElement> elements, String toSelect);

	 void selectFromDropDown(WebElement elem, String toSelect, DropDown drp);

	void selectCheckBox(List<WebElement> elements, String... toSelect);
}
 
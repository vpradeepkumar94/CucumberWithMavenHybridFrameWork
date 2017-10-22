package com.hybridframework.pojos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.apache.log4j.Logger;

import com.hybridframework.miscellaneous.Utils;
import com.hybridframework.testbase.BrowserFactory;
import com.poiji.internal.Poiji;
import com.poiji.internal.annotation.ExcelCell;

public class Person {

	 @ExcelCell(0)
	private String TestCaseID;
	 @ExcelCell(1)
	private String FirstName;
	 @ExcelCell(2)
	private String LastName;
	 @ExcelCell(3)
	private int age;
	 @ExcelCell(4)
	private String gender;
	 @ExcelCell(5)
	private String mobileNumber;
	 @ExcelCell(6)
	private String DOB;
	 @ExcelCell(7)
	private boolean HasVoterId;
	 @ExcelCell(8)
	private String Hobby;
	 @ExcelCell(9)
	private String Country;
	
	@Override
	public String toString() {
		return "Person [TestCaseID=" + TestCaseID + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", age=" + age + ", gender="
				+ gender + ", mobileNumber=" + mobileNumber + ", DOB=" + DOB
				+ ", HasVoterId=" + HasVoterId + ", Hobby=" + Hobby
				+ ", Country=" + Country + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	/**
	 * Example to demonstrate the usage of Pojo data
	 */
//	public static void main(String[] args) {
//		List<Person> persons = null;
//		try {
//			persons = Poiji.fromExcel(new File(System.getProperty("user.dir") +"/src/main/resources/DataSource/SampleTestData.xlsx"), Person.class);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		System.out.println(persons.size());
//		Person  personData = persons.get(0);
//		System.out.println(personData);
//		System.out.println(personData.FirstName);
//  	    Logger Log = Utils.getLogger(Person.class);
//		Log.info("done");
//	}
	
}

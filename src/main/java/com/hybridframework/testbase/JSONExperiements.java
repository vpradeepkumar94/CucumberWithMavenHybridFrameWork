package com.testjsons.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;

import com.datas.InCorrectRootNameException;
import com.datas.IncorrectPOJOClassException;
import com.datas.IncorrectPojoInstanceException;
import com.datas.KeyNotPresentException;
import com.datas.MisMatchInFileNameException;
import com.enums.FileNames;
import com.enums.Pojos;
import com.enums.RootNames;
import com.jsonsreadwriter.java.JSONReadWrite;
import com.pojos.Students;
import com.pojos.Users;

public class JSONExperiements {

	static Users user ;
	static Students students;

	public static void main(String[] args) {

	 String keyToRead = "Student1";
	 String keyToWrite  = "Student6"; //= "User3";
     readFromJsonExample(RootNames.USERS, FileNames.Users, keyToRead,Pojos.Users);
	 writeToJsonExample(RootNames.USERS, FileNames.Users,keyToWrite, Pojos.Users);
	 getAllDataExample(RootNames.USERS, FileNames.Users,Pojos.Users);
	}
	
	private static void getAllDataExample(RootNames rootName,FileNames fileName,Pojos clazz) {
		
		try {
			 LinkedHashMap<String, ?> map = JSONReadWrite.getAllDataFromJSonFile(rootName, fileName,clazz);
			 System.out.println(map);
		} catch (FileNotFoundException | KeyNotPresentException | InCorrectRootNameException | ClassNotFoundException | IncorrectPOJOClassException | MisMatchInFileNameException e) {
			e.printStackTrace();
		} 
	}
	
	private static void writeToJsonExample(RootNames rootName, FileNames fileName,String key,Pojos type) {
		 Students students = new Students();
			students.setAge(22);
			students.setName("Menaca");
			students.setSubjects(Arrays.asList("Subs5","Sub5.1"));
			
		 Users user = new Users();
			user.setGender(false);
			user.setName("ManiMarai");
		
		try {
				JSONReadWrite.toJSonFile(rootName, fileName, type, key, user);
				System.out.println("Contents written successfully");
		} catch(ClassNotFoundException | ClassCastException | IOException | InCorrectRootNameException | IncorrectPOJOClassException | IncorrectPojoInstanceException | MisMatchInFileNameException e) {
				e.printStackTrace();
		}
	}
	
	private static void readFromJsonExample(RootNames rootName, FileNames fileName,String keyToRead,Pojos type) {
		try {
			students = JSONReadWrite.fromJSonFile(rootName, fileName, keyToRead, type);
			System.out.println("Student details are ............");
			System.out.println(students);
		} catch (FileNotFoundException | KeyNotPresentException | ClassNotFoundException | InCorrectRootNameException | MisMatchInFileNameException | IncorrectPOJOClassException e) {
			System.out.println(e);
		} 
	}


	
}

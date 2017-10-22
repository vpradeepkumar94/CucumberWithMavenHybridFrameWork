package com.hybridframework.miscellaneous;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Utils {

	/**
	 * Creates New log file with Time Stamp for every run
	 */
	static {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String formattedDate = sdf.format(new Date());
		System.setProperty("date.time", formattedDate);
	}

	/**
	 * 
	 * @param Clazz
	 *            Name of the class
	 * @return Instance of log4j used for logging the data
	 */
	public static final <T> Logger getLogger(Class<T> Clazz) {
		return Logger.getLogger(Clazz);
	}

	/**
	 * Returns the current date
	 * 
	 * @return current date in dd/mm/yyy format
	 */
	public static String getDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(new Date());
		return formattedDate;
	}

}

package com.jsonsreadwriter.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.datas.InCorrectRootNameException;
import com.datas.IncorrectPOJOClassException;
import com.datas.IncorrectPojoInstanceException;
import com.datas.KeyNotPresentException;
import com.datas.MisMatchInFileNameException;
import com.enums.FileNames;
import com.enums.Pojos;
import com.enums.RootNames;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class JSONReadWrite {

	private static Gson gson;
	final private static String filePath = System.getProperty("user.dir") +"/src/DataSource/";
	final private static String fileExtension = ".json";

	private static Gson getGsonInstance() {
		return (gson == null) ? new GsonBuilder().setPrettyPrinting().create()	: gson;
	}
	
	private static boolean isRootNodeAndPojoSame (RootNames rootName,Pojos className) {
		return  rootName.getThePageInstanceType().toLowerCase().equalsIgnoreCase(className.toString());
	}
	
	private static boolean isFileNameAndPojoSame(FileNames fileName, Pojos className) {
		return fileName.toString().toLowerCase().equalsIgnoreCase(className.toString());
	}
	
	@SuppressWarnings("unchecked")
	private static <T> Class<T> getClass(Pojos className) throws ClassNotFoundException {
		return  (Class<T>) Class.forName("com.pojos." +className);
	}
	
	private static <T> LinkedHashMap<String, T> readFromJSonFileAsMap(	RootNames rootName, FileNames fileName,
			Class<T> clazz)	throws FileNotFoundException, InCorrectRootNameException {

		gson = getGsonInstance(); // get GSON Instance
		String rootNode = rootName.toString();
		String qualifiedFileName = filePath + fileName.toString() + fileExtension;
		LinkedHashMap<String, T> localMap = new LinkedHashMap<String, T>();
		JsonElement root = null;
		JsonObject object = null;
		File file = new File(qualifiedFileName);

		if (file.exists()) {
			try {
				root = new JsonParser().parse(new FileReader(qualifiedFileName));
			} catch (JsonIOException | JsonSyntaxException	| FileNotFoundException e) {
				System.out.println(e);
				return localMap;
			}
			if (root != null) {
				try {
					object = root.getAsJsonObject().get(rootNode).getAsJsonObject();

					for (Entry<String, JsonElement> entry : object.entrySet()) {
						String localKey = entry.getKey();
						T localValue = (T) gson.fromJson(entry.getValue(), clazz);
						localMap.put(localKey, localValue);
					}
					return localMap;
				} catch (NullPointerException e) {
					throw new InCorrectRootNameException("Root Name mismatch,Please check the rootname for the file "+ fileName);
				}
			} else {
				return localMap;
			}
		}
		return localMap;
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromJSonFile(RootNames rootName, FileNames fileName,	String key, Pojos className) throws FileNotFoundException,
			KeyNotPresentException, InCorrectRootNameException, ClassNotFoundException, MisMatchInFileNameException, IncorrectPOJOClassException {
		
		boolean isRootNodeAndPojoSame = isRootNodeAndPojoSame(rootName, className);
		boolean isFileNameMatchesWithPojo = isFileNameAndPojoSame(fileName, className);
		LinkedHashMap<String, ?> localMap = null;
	
		if(isRootNodeAndPojoSame) {
			if(isFileNameMatchesWithPojo) {
				localMap = readFromJSonFileAsMap(rootName,fileName, getClass(className));
				if (localMap.size() == 0) {
					throw new FileNotFoundException("File is not found.Please check the file Name");
				} else {
					if (localMap.containsKey(key)) {
						return (T) localMap.get(key);
					} else {
						throw new KeyNotPresentException("Key not found");
					}
				}
		    } else {
		    	throw new MisMatchInFileNameException("Specified file name doesnt matches with Pojo class,Please check the file name and Pojo type");
			}
	   } else {
			 throw  new IncorrectPOJOClassException("Pojo class and Root Node mistmatches.Please check the class name and root Node");
	  }
  }

	public static <T> void toJSonFile(RootNames rootName, FileNames fileName,Pojos className, String key, T localData) throws IOException,
						InCorrectRootNameException, ClassNotFoundException, IncorrectPOJOClassException ,ClassCastException, 
						IncorrectPojoInstanceException, MisMatchInFileNameException {

		String rootNode = rootName.toString();
		String qualifiedFileName = filePath + fileName.toString() + fileExtension;
		Class<T> clas = getClass(className);
		
		boolean isRootNodeAndPojoSame = isRootNodeAndPojoSame(rootName, className);
		boolean isFileNameMatchesWithPojo = isFileNameAndPojoSame(fileName, className);
		
		if(isRootNodeAndPojoSame) {
			if(isFileNameMatchesWithPojo) {
				if(clas.isInstance(localData))  {
					Map<String, T> localMap = (Map<String, T>) readFromJSonFileAsMap(rootName,fileName,clas );
					localMap.put(key, localData);
					LinkedHashMap<String, Map<String, T>> mainMaps = new LinkedHashMap<String, Map<String, T>>();
					mainMaps.put(rootNode.toUpperCase(), localMap);
					try (FileWriter fw = new FileWriter(qualifiedFileName)) {
						gson.toJson(mainMaps, fw);
						System.out.println("successfully written contents");
					}
				} else {
					throw new IncorrectPojoInstanceException("Incorrect Pojo Class or type of data specified,Please check the Pojo Class Name and object type");
				}
			} else {
		    	throw new MisMatchInFileNameException("Specified file name doesnt matches with Pojo class,Please check the file name and Pojo type");
			}
	   } else {
		 throw  new IncorrectPOJOClassException("Pojo class and Root Node mistmatches.Please check the class name and root Node");
	  }
}

	public static  LinkedHashMap<String, ?> getAllDataFromJSonFile(RootNames rootName, FileNames fileName, Pojos className) throws
	               FileNotFoundException, KeyNotPresentException,InCorrectRootNameException, ClassNotFoundException, 
	               IncorrectPOJOClassException, MisMatchInFileNameException {
		
		boolean isRootNodeAndPojoSame = isRootNodeAndPojoSame(rootName, className);
		boolean isFileNameMatchesWithPojo = isFileNameAndPojoSame(fileName, className);
	
		LinkedHashMap<String, ?> localMap = null;
		
		if(isRootNodeAndPojoSame) {
			if(isFileNameMatchesWithPojo) {
				localMap = readFromJSonFileAsMap(rootName,fileName, getClass(className));
				if (localMap.size() == 0) {
					throw new FileNotFoundException("File is not found.Please check the file Name");
				} else {
					return localMap;
				}
		    } else {
		    	throw new MisMatchInFileNameException("Specified file name doesnt matches with Pojo class,Please check the file name and Pojo type");
			}
		} else {
			 throw  new IncorrectPOJOClassException("Pojo class and Root Node mistmatches.Please check the class name and root Node");
		}
	}

}

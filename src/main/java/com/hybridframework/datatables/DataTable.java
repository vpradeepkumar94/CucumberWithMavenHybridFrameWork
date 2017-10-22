package com.hybridframework.datatables;

import org.apache.poi.ss.usermodel.Row;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataTable {

	public static Object getCellType(Cell cell) {
		// Returns the cell Type present in the excel file
		switch(cell.getCellTypeEnum()) {
		  case BOOLEAN:  return cell.getBooleanCellValue();
		  case NUMERIC:  return cell.getNumericCellValue();
		  case STRING:   return cell.getStringCellValue();
		  default:		  return null; 
		}
   } 

	public static String  getData(String filePath ,String sheetName, String keyName, String Column) throws IOException {
	
		String value = "";
		String AbsolutePath = System.getProperty("user.dir","/src/main/resources/DataSource/") + filePath; 
		try (FileInputStream  fis = new  FileInputStream(new File(AbsolutePath));
			 XSSFWorkbook workbook = new XSSFWorkbook(fis);) {
			
			// specify the sheet from which the data has to be loaded
			Sheet currentSheet = workbook.getSheet(sheetName);
			
			// use iterator to fetch all the rows present in the sheet
			Iterator<Row> rows = currentSheet.iterator();
		
			// while if there is another row exists
			while(rows.hasNext()) {
				// instantiate an object of the POJO Class
				Row currentRow = rows.next();
				// split the rows into different cells using iterator
				Iterator<Cell> cells = currentRow.cellIterator();
				String key = "";
				// get the row number of the current row
				int rowNumber =currentRow.getRowNum();	
				// while if cell exists in the current row 
				while( cells.hasNext()) {
	  			  // get the current cell
				   Cell currentCell = cells.next();
				   // get the column index
				   int columnIndex = currentCell.getColumnIndex();
					// skip the first row,as the first row is of type Header	
					if(rowNumber >0) {
						// Cell 0 will always acts as 'Key' as it is being Unique
						if(currentCell.getColumnIndex() == 0)
					  	   key = currentCell.getStringCellValue();
							if(key.equalsIgnoreCase(keyName)) {
								String name = currentCell.getSheet().getRow(0).getCell(columnIndex)
							    .getRichStringCellValue().toString();
								if(name.equalsIgnoreCase(Column)) {
									value = currentCell.getSheet().getRow(rowNumber).getCell(columnIndex)
								    .getRichStringCellValue().toString();
								}
							} 
					    } 
					} 
				} 
		 } catch( Exception e) {
			System.out.println(e.getMessage());
		 }
		return  value;
	
	}
	
	public static void  putData(String filePath ,String sheetName, String keyName, String Column,Object Value) {
		// code to update the excel sheet
	}
	
}
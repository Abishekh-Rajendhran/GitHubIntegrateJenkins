package com.flipkart.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\FTL_SHEET_DELIVERY.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("FREIGHT-OTHER");
		
		int noOfRows = sheet.getLastRowNum();
		
	    int noOfCells = sheet.getRow(0).getLastCellNum();
	    
//	    System.out.println(noOfRows);
//	    System.out.println(noOfCells);
	    
	    for (int rows = 0; rows <=noOfRows; rows++) {
	    	XSSFRow row = sheet.getRow(rows);
			for (int cell = 0; cell < noOfCells; cell++) {
				 if (row.getCell(cell) != null) {
	                    String cellValue = row.getCell(cell).toString();
	                    System.out.print(cellValue + " ");
	                } else {
	                    System.out.print("null");
	                    
			}
				 
			
		}
			System.out.println();
	    }
	    workbook.close();
	    file.close();
		
	}

}

package com.flipkart.pageobjects;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcelFile {
	
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("DataInsertion");
		
		XSSFRow row1 = sheet.createRow(0);
		   row1.createCell(0).setCellValue("Java");
		   row1.createCell(1).setCellValue("selenium");
		   row1.createCell(2).setCellValue("TestNg");
		   row1.createCell(3).setCellValue("Apache POI");
		   row1.createCell(4).setCellValue("Page Object Model");
		  
		XSSFRow row2 = sheet.createRow(1);
		   row2.createCell(0).setCellValue("Python");
		   row2.createCell(1).setCellValue("Selenium");
		   row2.createCell(2).setCellValue("Pytest");
		   row2.createCell(3).setCellValue("Python");
		   row2.createCell(4).setCellValue("Page Object model");
		   
		   
	    FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myFile.xlsx");
	    
	    workbook.write(file);
	    workbook.close();
	    file.close();
		   
	}

}

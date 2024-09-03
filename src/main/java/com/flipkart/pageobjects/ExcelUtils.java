package com.flipkart.pageobjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	    public static FileInputStream ifile;
	    public static FileOutputStream ofile;
	    public static XSSFWorkbook workbook;
	    public static XSSFSheet sheet;
	    public static XSSFRow row;
	    public static XSSFCell cell;
		
		public static int getRowCount(String fileName, String sheetName) throws IOException {
			
			ifile = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(ifile);
			sheet = workbook.getSheet(sheetName);
			int noOfRows = sheet.getLastRowNum();
			
			workbook.close();
			ifile.close();
			return noOfRows;
		}
		
		public static int getCellCount(String fileName, String sheetName, int rowNumber) throws IOException {
			
			ifile = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(ifile);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			int noOfCells = row.getLastCellNum();
			
			workbook.close();
			ifile.close();
			return noOfCells;
			
		}
		
		public static String getCellValue(String fileName, String sheetName, int rowNumber, int cellNumber) throws IOException {
			
			ifile = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(ifile);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			cell = row.getCell(cellNumber);
			String cellValue;
						
			 switch (cell.getCellType()) {
	            case STRING:
	                cellValue = cell.getStringCellValue();
	                break;
	            case NUMERIC:
	                cellValue = String.valueOf((int) cell.getNumericCellValue());
	                break;
	            default:
	                cellValue = "";
	        }

			
			workbook.close();
			ifile.close();
			return cellValue;
			
		}
		
		public static void setCellValue(String fileName, String sheetName, int rowNumber, int cellNumber, String CellValue) throws IOException {
			
			ifile = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(ifile);
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNumber);
			cell = row.createCell(cellNumber);
			cell.setCellValue(CellValue);
			ofile = new FileOutputStream(fileName);
			workbook.write(ofile);
			
			workbook.close();
			ifile.close();	
			ofile.close();
		}
		
		
		
	

}

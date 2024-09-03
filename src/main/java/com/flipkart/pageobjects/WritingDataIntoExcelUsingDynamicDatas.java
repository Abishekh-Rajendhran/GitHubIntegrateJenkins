package com.flipkart.pageobjects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcelUsingDynamicDatas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Dynamic-Data");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the no of rows ");
	    int noOfRows = scanner.nextInt();
	    System.out.print("Enter the no of columns ");
	    int noofCells = scanner.nextInt();
	    
	   
	    for (int rows = 0; rows <noOfRows; rows++) {
	    	XSSFRow row = sheet.createRow(rows);
			for (int cells = 0; cells < noofCells; cells++) {
				XSSFCell cell = row.createCell(cells);
				cell.setCellValue(scanner.next());
			}
		}
	    
	    FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\dynamicDataFile.xlsx");
	    
	    workbook.write(file);
	    
	    System.out.println("File successfully created!");
	    
	    workbook.close();
        scanner.close();
	    file.close();
	}

}

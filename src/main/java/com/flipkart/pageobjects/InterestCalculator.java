package com.flipkart.pageobjects;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class InterestCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		String filePath = System.getProperty("user.dir")+"\\testdata\\dataFile.xlsx";

		int noOfRows = ExcelUtils.getRowCount(filePath, "Sheet1");

		for (int rows = 1; rows <=noOfRows ; rows++) {
			String principal = ExcelUtils.getCellValue(filePath, "Sheet1", rows, 0);
			String interest = ExcelUtils.getCellValue(filePath, "Sheet1", rows, 1);
			String period = ExcelUtils.getCellValue(filePath, "Sheet1", rows, 2);
			String time = ExcelUtils.getCellValue(filePath, "Sheet1", rows, 3);
			String frequency = ExcelUtils.getCellValue(filePath, "Sheet1", rows, 4);
			String expected = ExcelUtils.getCellValue(filePath, "Sheet1", rows, 5);

			driver.findElement(By.id("principal")).sendKeys(String.valueOf(Integer.parseInt(principal)));
			driver.findElement(By.id("interest")).sendKeys(interest);
			driver.findElement(By.id("tenure")).sendKeys(period);

			Select selectPeriod = new Select(driver.findElement(By.id("tenurePeriod")));
			selectPeriod.selectByVisibleText(time);

			Select selectFrequency = new Select(driver.findElement(By.id("frequency")));
			selectFrequency.selectByVisibleText(frequency);

			Actions actions = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			actions.moveToElement(element).click().perform();

			Thread.sleep(3000);
			String actual = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();

			if (Double.parseDouble(expected)==Double.parseDouble(actual)) {
				System.out.println("Test Passed!");
				ExcelUtils.setCellValue(filePath, "Sheet1", rows, 7, "Pass");
			}

			else {
				System.out.println("Test Failed!");
				ExcelUtils.setCellValue(filePath, "Sheet1", rows, 7, "Fail");
			}

			
			Actions actions1 = new Actions(driver);
			WebElement element1 = driver.findElement(By.xpath("//div[@class='cal_div']//a[2]"));
			actions1.moveToElement(element1).click().perform();


		}
		driver.close();
	}

}

package Moolya;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SecondSmallestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
		WebDriver driver = new ChromeDriver();
		
		driver.get("URL");
		
		WebElement sourceElement = driver.findElement(By.className("something"));
		
		WebElement targetElement = driver.findElement(By.className("something"));
		
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		
	}

}

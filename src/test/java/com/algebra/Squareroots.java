package com.algebra;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Squareroots {
@Test
public void checkSquareroot() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\algebra\\algebraInputs.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String alocator =p.getProperty("algebra_locator");
		String sqrtlocator=p.getProperty("sqrt_locator");
		String tblocator=p.getProperty("textbox_locator");
		String num =p.getProperty("sqrt");
		String slocator=p.getProperty("submit_locator");
		String sqrtresult=p.getProperty("sqrtresult_locator");
		
		
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement algebra = driver.findElement(By.linkText(alocator));
		algebra.click();
		
		WebElement sqrt = driver.findElement(By.linkText(sqrtlocator));
		sqrt.click();
		
		WebElement enternum = driver.findElement(By.cssSelector(tblocator));
		enternum.sendKeys(num);
		
		WebElement submit = driver.findElement(By.cssSelector(slocator));
		submit.click();
		Thread.sleep(3000);
		driver.close();
		
	   driver.switchTo().frame(1);
	    
	    WebElement result= driver.findElement(By.xpath(sqrtresult));
	    int actual_result =Integer.parseInt(result.getText());
	    int expected_result=(int) Math.sqrt(25);
	    System.out.println("Actual Result "+actual_result);
	    System.out.println("Expected Result "+expected_result);
	    Assert.assertEquals(expected_result, actual_result);
	    
	    
		Thread.sleep(3000);
		driver.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}
}

package com.plotsandgeometry;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AreaofCircle {
@Test
public void circleArea() {
	try {
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\plotsandgeometry\\PlotsandGeometryInputs.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String pglocator=p.getProperty("pg_locator");
		String clocator=p.getProperty("circle_locator");
		String tb2locator=p.getProperty("textbox2_locator");	
		String entervalue=p.getProperty("radius");
		String select2locator=p.getProperty("s2_locator");
		String dicirclelocator=p.getProperty("dicircle_locator");
		String circleresult=p.getProperty("circleresult_locator");
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement pndg = driver.findElement(By.linkText(pglocator));
		pndg.click();
		WebElement circle = driver.findElement(By.cssSelector(clocator));
		circle.click();
		
		
		WebElement enterside = driver.findElement(By.cssSelector(tb2locator));
		enterside.sendKeys(entervalue);
		
		WebElement select = driver.findElement(By.name(select2locator));
		Select area=new Select(select);
		area.selectByIndex(3);
		
		WebElement submit = driver.findElement(By.cssSelector(dicirclelocator));
		submit.click();
		
		 driver.switchTo().frame(1);
		    
		    WebElement result= driver.findElement(By.xpath(circleresult));
		    int actual_result=Integer.parseInt(result.getText());
		    double expected_result= 3.14159*4*4;
		    System.out.println("Actual Result "+actual_result);
		    System.out.println("Expected Result "+expected_result);
		    Assert.assertEquals(expected_result, actual_result);
		    
		    driver.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
}
}

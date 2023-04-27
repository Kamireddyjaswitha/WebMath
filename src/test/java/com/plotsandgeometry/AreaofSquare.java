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

public class AreaofSquare {
@Test
public void squareArea() {
	
		try {
			FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\plotsandgeometry\\PlotsandGeometryInputs.properties");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String pglocator=p.getProperty("pg_locator");
			String slocator=p.getProperty("square_locator");
			String tblocator=p.getProperty("textbox_locator");	
			String entervalue=p.getProperty("side");
			String selectlocator=p.getProperty("s_locator");
			String disquarelocator=p.getProperty("disquare_locator");
			String squareresult=p.getProperty("squareresult_locator");
			
			
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			WebElement pndg = driver.findElement(By.linkText(pglocator));
			pndg.click();
			WebElement square = driver.findElement(By.linkText(slocator));
			square.click();
			
			
			WebElement enterside = driver.findElement(By.cssSelector(tblocator));
			enterside.sendKeys(entervalue);
			
			WebElement select = driver.findElement(By.name(selectlocator));
			Select area=new Select(select);
			area.selectByIndex(3);
			
			WebElement submit = driver.findElement(By.cssSelector(disquarelocator));
			submit.click();
			
			 driver.switchTo().frame(1);
			    
			    WebElement result= driver.findElement(By.xpath(squareresult));
			    String actual_result =result.getText();
			    int er= 4*4;
			    String expected_result="The area enclosed by the square is "+er+".";
			    System.out.println("Actual Result "+actual_result);
			    System.out.println("Expected Result "+expected_result);
			    Assert.assertEquals(expected_result, actual_result);
			    
			    driver.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
}
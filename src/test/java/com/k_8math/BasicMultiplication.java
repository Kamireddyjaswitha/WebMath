package com.k_8math;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class BasicMultiplication {
@Test
public void Multiply() {
	try {

		FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\k_8math\\k_8mathinputs.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String k8mlocator=p.getProperty("k_8math_locator");
		String bmlocator=p.getProperty("basicmultiply_locator");
		String tb1locator=p.getProperty("textbox1_locator");
		String tb2locator=p.getProperty("textbox2_locator");
		String mtlocator=p.getProperty("multiplythem_locator");
		String enter1=p.getProperty("textbox1");
		String enter2=p.getProperty("textbox2");
		String mulresult=p.getProperty("mulresult_locator");

		

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement k_8math = driver.findElement(By.linkText(k8mlocator));
		k_8math.click();
		
	    WebElement multiply = driver.findElement(By.linkText(bmlocator));
	    multiply.click();
	    

	    WebElement textbox1 = driver.findElement(By.name(tb1locator));
	    textbox1.sendKeys(enter1);;
	    WebElement textbox2 = driver.findElement(By.name(tb2locator));
	    textbox2.sendKeys(enter2);
	    WebElement submit = driver.findElement(By.cssSelector(mtlocator));
	    submit.click();
	    
	    
	    driver.switchTo().frame(1);
	    
	    WebElement result= driver.findElement(By.xpath(mulresult));
	    int actual_result =Integer.parseInt(result.getText());
	    int expected_result=4*4;
	    System.out.println("Actual Result "+actual_result);
	    System.out.println("Expected Result "+expected_result);
	    Assert.assertEquals(expected_result, actual_result);
	    
	    
	    
		Thread.sleep(3000);
		
		driver.close();
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

}


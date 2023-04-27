package com.generalmath;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AboutWebMath {
	@Test
	public void AboutWebmath() {
		  
	    
		   try { 
			   
					FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\generalmath\\generalmath.properties");
					Properties p = new Properties();
					p.load(fis);
					String url = p.getProperty("url");
					String gmlocator = p.getProperty("generalmath_locator");
					String awlocator = p.getProperty("aboutwebmath_locator");



					ChromeDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					driver.get(url);
					WebElement generalmath = driver.findElement(By.linkText(gmlocator));
					generalmath.click();
					WebElement aboutwebmath = driver.findElement(By.linkText(awlocator));
			        aboutwebmath.click();
			        Thread.sleep(3000);
			        driver.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	        

	}

}

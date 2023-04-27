package com.mathforeveryone;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Helptypinginyourmathproblems {
@Test
public void HelpinTypingProblem() {
	try{
		FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\mathforeveryone\\mathforeveryoneinpute.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String mlocator = p.getProperty("mfe_locator");
		String hlocator = p.getProperty("help_locator");

		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement mathforeveryone = driver.findElement(By.linkText(mlocator));
		mathforeveryone.click();
		WebElement help = driver.findElement(By.linkText(hlocator));
        help.click();
		Thread.sleep(3000);
		driver.quit();
	}catch(Exception e) {
		System.out.println(e.getMessage());
		
		}
	
		

}
}

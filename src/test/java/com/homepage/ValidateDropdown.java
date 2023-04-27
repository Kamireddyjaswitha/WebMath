package com.homepage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ValidateDropdown {
	@Test
public void TopicItemSelect() {
		try{
			FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\homepage\\HomeInput.properties");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String tslocator = p.getProperty("dropown_locator");
			
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(url);
			WebElement topicselect = driver.findElement(By.id(tslocator));
			Select topicitemselect= new Select(topicselect);
			topicitemselect.selectByIndex(3);
			Thread.sleep(3000);
			driver.quit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
			}
		
			
}
}

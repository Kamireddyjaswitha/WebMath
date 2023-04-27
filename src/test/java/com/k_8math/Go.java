package com.k_8math;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Go {
@Test
public void goFuncionality() {
	try {

		FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\k_8math\\k_8mathinputs.properties");
		Properties p = new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		String k8mlocator=p.getProperty("k_8math_locator");
		String golocator=p.getProperty("go_locator");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		WebElement k_8math = driver.findElement(By.linkText(k8mlocator));
		k_8math.click();
		
	    WebElement go = driver.findElement(By.xpath(golocator));
	    go.click();
		Thread.sleep(3000);
		driver.close();
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
}
}

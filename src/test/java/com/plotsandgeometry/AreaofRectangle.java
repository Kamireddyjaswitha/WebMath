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

public class AreaofRectangle {
	@Test
	public void rectangleArea() {
		
			try {
				FileInputStream fis = new FileInputStream("D:\\latest selenium\\WebMathProject-2\\src\\test\\java\\com\\plotsandgeometry\\PlotsandGeometryInputs.properties");
				Properties p = new Properties();
				p.load(fis);
				String url = p.getProperty("url");
				String pglocator=p.getProperty("pg_locator");
				String rlocator=p.getProperty("rec_locator");
				String tb3locator=p.getProperty("textbox3_locator");
				String tb4locator=p.getProperty("textbox4_locator");
				String width=p.getProperty("width_v");
				String height=p.getProperty("height_v");
				String selectlocator=p.getProperty("s_locator");
				String directanglelocator=p.getProperty("directangle_locator");
				String recresult=p.getProperty("recresult_locator");
				
				
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(url);
				WebElement pndg = driver.findElement(By.linkText(pglocator));
				pndg.click();
				WebElement rectangle = driver.findElement(By.linkText(rlocator));
				rectangle.click();
				
				
				WebElement enterwidth = driver.findElement(By.name(tb3locator));
				enterwidth.sendKeys(width);
				WebElement enterheight = driver.findElement(By.name(tb4locator));
				enterheight.sendKeys(height);
				
				WebElement select = driver.findElement(By.name(selectlocator));
				Select area=new Select(select);
				area.selectByIndex(2);
				
				WebElement submit = driver.findElement(By.cssSelector(directanglelocator));
				submit.click();
				
				 driver.switchTo().frame(1);
				    
				    WebElement result= driver.findElement(By.xpath(recresult));
				    String actual_result =result.getText();
				    int er= 4*4;
				    String expected_result="The area enclosed by this rectangle is "+er+".";
				    System.out.println("Actual Result "+actual_result);
				    System.out.println("Expected Result "+expected_result);
				    Assert.assertEquals(expected_result, actual_result);
				    
				    driver.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}

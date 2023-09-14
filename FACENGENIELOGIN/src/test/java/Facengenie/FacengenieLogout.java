package Facengenie;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class FacengenieLogout {
	

	
  
 
  
//To logout in Facengenies
  @Test
  public void Logout() throws InterruptedException {
	 
	  WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  driver.get("https://facegenie-ams-school.web.app/");
			  driver.findElement(By.id("email")).sendKeys("testbams@gmail.com");
			  driver.findElement(By.id("password")).sendKeys("facegenie");
			  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/div[1]/form[2]/button")).click();
			  WebDriverWait wait = new WebDriverWait(driver, 20);
			  //logout functionality
			
			  try {
				     driver.findElement(By.xpath("//span[normalize-space()='Log Out']")).click();
				     driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();

				    
				  } catch (Exception e) {
				     JavascriptExecutor executor = (JavascriptExecutor) driver;
				     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[normalize-space()='Log Out']")));
				  
				     executor.executeScript("arguments[0].click();", driver.findElement(By.xpath
				    		 ("//button[normalize-space()='Ok']")));

				  }
			
			 
					WebElement element =
					 wait.until( ExpectedConditions.elementToBeClickable(By.
					 xpath("//div[@class='MuiAlert-message css-1xsto0d']")));
					 
					 String errorMessage = element.getText(); 
					 System.out.print(errorMessage);
					 
					 Assert.assertEquals(errorMessage, "logged out succesfully");
					 
					 driver.quit();
	  
  }
 

 
  }


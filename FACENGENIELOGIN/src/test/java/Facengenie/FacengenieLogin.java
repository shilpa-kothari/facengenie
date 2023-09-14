package Facengenie;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class FacengenieLogin {
 WebDriver driver;
@Test(dataProvider = "credential")
public void VerifyLoginCredentials(String sceneario,String emailAddress,String Password) throws InterruptedException {
  WebDriverManager.chromedriver().setup();
 driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("https://facegenie-ams-school.web.app/");
  driver.findElement(By.id("email")).sendKeys(emailAddress);
  driver.findElement(By.id("password")).sendKeys(Password);
  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/div[1]/form[2]/button")).click();
  WebDriverWait wait = new WebDriverWait(driver, 15);
if(sceneario.equals("bothcorrect"))
{
  WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='testbams@gmail.com']")));
String abc = element.getText();
 System.out.print(abc);
  Assert.assertEquals(abc, "testbams@gmail.com");
  
 
}
else if(sceneario.equals("bothwrong"))
{
  try
  {
	  
  
  WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']")));
  String errorMessage = element.getText();
  System.out.print(errorMessage);
	        Assert.assertEquals(errorMessage, "User not found");
  }
  catch(Exception e)
  {
	  System.out.print(e);
  }
}

else if(sceneario.equals("correctemailaddress"))
{
  try
  {
	  
  
  WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']")));
  String errorMessage = element.getText();
  System.out.print(errorMessage);

	        Assert.assertEquals(errorMessage, "Password wrong");
  }
  catch(Exception e)
  {
	  System.out.print(e);
  }
}

else if(sceneario.equals("correctpassword"))
{
  try
  {
	  
  
  WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='MuiAlert-message css-1xsto0d']")));
  String errorMessage = element.getText();
  System.out.print(errorMessage);

	        Assert.assertEquals(errorMessage, "User not found");
  }
  catch(Exception e)
  {
	  System.out.print(e);
  }
}




driver.quit();
}




@DataProvider(name="credential")
public Object[][] getData() {
return new Object[][] {
  new Object[] {"bothcorrect" , "testbams@gmail.com","facegenie" },
  new Object[] {"bothwrong" , "bams@gmail.com","genie" },
  new Object[] {"correctemailaddress" , "testbams@gmail.com","genie" },
  new Object[] {"correctpassword" , "bams@gmail.com","facegenie" },
 
};
}
}

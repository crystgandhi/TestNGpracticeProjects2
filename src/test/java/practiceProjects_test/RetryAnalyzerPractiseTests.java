package practiceProjects_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractiseTests {
	
	WebDriver driver;
	@Test
	public void TC_001_validCredentials() {
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr503728");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("vugymYh");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String heading=driver.findElement(By.cssSelector("h2.barone")).getText();
		Assert.assertEquals(heading, "Guru99 Bank");
		driver.close();
	}
	
	@Test(retryAnalyzer=practiceProjects_Analyzer.RetryAnalyzerExample.class)
	public void TC_002_inValidCredntials() {
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mngr503729");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("vugymYh");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String heading=driver.findElement(By.cssSelector("h2.barone")).getText();
		Assert.assertEquals(heading, "Guru99 Bank");
		driver.close();
	}
	
	

}

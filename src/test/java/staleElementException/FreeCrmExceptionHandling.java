package staleElementException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FreeCrmExceptionHandling {
	WebDriver driver;

	@Test
	public void freecrmStaleElement() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.freecrm.com/index.html");
		driver.findElement(By.xpath("//span[@class='icon icon-xs mdi-chart-bar']")).click();
		WebElement uname = driver.findElement(By.xpath("//*[@name='email']"));
		uname.sendKeys("admin");
		WebElement pword = driver.findElement(By.xpath("//*[@name='password']"));
		pword.sendKeys("admin123");
		driver.navigate().refresh();

		try {
			uname.sendKeys("admin");
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath("//*[@name='email']")).sendKeys("admin");
		}
		
		try {
			pword.sendKeys("admin123");
		} catch (StaleElementReferenceException e) {
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		}

	}
}

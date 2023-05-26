package staleElementException;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaleElementException {
	WebDriver driver;

	@Test
	public void staleElementException() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.pavantestingtools.com/");
		WebElement link = driver.findElement(By.linkText("Online Training"));
		link.click();
		driver.navigate().back();
		Thread.sleep(3000);

		try {
			link.click();
		} catch (StaleElementReferenceException e) {
			link = driver.findElement(By.linkText("Online Training"));
			link.click();
		}
       driver.close();
	}

}

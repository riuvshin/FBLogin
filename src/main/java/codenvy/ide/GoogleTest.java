package codenvy.ide;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {

	@Test
	public void startWebDriver() {

		WebDriver driver = new FirefoxDriver();

		driver.navigate().to("http://www.easyhits4u.com/");
		String currentWin = driver.getWindowHandle();
		Assert.assertTrue("Title check",
				driver.getPageSource().contains("promotes"));

		driver.findElement(By.xpath("//a[contains(., 'Sign Up')]")).click();

		driver.findElement(By.cssSelector(".but-log-face")).click();

		for (String handle : driver.getWindowHandles()) {
			if (currentWin.equals(handle)) {

			} else {
				driver.switchTo().window(handle);
				break;
			}
		}

		new WebDriverWait(driver, 15).until(ExpectedConditions
				.visibilityOfElementLocated(By.name("email")));

		driver.findElement(By.name("email")).sendKeys("fbtestanna1@gmail.com");

		driver.findElement(By.name("pass")).sendKeys("anechka1984");
		driver.findElement(By.name("login")).click();

		// authorize EasyHits4U app

		String currentWin1 = driver.getWindowHandle();
		driver.findElement(By.name("__CONFIRM__")).click();

		for (String handle : driver.getWindowHandles()) {
			if (currentWin1.equals(handle)) {

			} else {
				driver.switchTo().window(handle);
				break;
			}
		}

		// switch back to easyhits4u.com windows

		driver.switchTo().window(currentWin);
		new WebDriverWait(driver, 15)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//a[@href='http://www.easyhits4u.com/account']")));
		driver.findElement(
				By.xpath("//a[@href='http://www.easyhits4u.com/account']"))
				.click();

		// add a site /

		new WebDriverWait(driver, 15).until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("/html/body/div[5]/div[2]/ul/li[1]/a")));
		driver.findElement(By.xpath("/html/body/div[5]/div[2]/ul/li[1]/a"))
				.click();

		driver.findElement(By.name("url")).sendKeys("http://pravda.com.ua");
		driver.findElement(By.name("title")).sendKeys("Pravda");

		driver.findElement(By.xpath("//*[@id='add_form']/div[3]/input"))
				.click();

		driver.switchTo().frame(
				driver.findElement(By.xpath("/html/frameset/frame[1]")));
		new WebDriverWait(driver, 25).until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//*[@id='countDown']/input")));
		driver.findElement(By.xpath("//*[@id='countDown']/input")).click();

		driver.switchTo().defaultContent();

		// check site stats and close chart

		new WebDriverWait(driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//table[@id='my_sites']//a[text()='Pravda']/../..//div[@title='Statistics']")));

		driver.findElement(
				By.xpath("//table[@id='my_sites']//a[text()='Pravda']/../..//div[@title='Statistics']"))
				.click();

		new WebDriverWait(driver, 5).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("chartdivthree")));

		driver.findElement(By.xpath("//span[text()='close']")).click();

		// edit site

		new WebDriverWait(driver, 2)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//table[@id='my_sites']//a[text()='Pravda']/../..//div[@title='Edit']")));

		driver.findElement(
				By.xpath("//table[@id='my_sites']//a[text()='Pravda']/../..//div[@title='Edit']"))
				.click();

		new WebDriverWait(driver, 5).until(ExpectedConditions
				.visibilityOfElementLocated(By.id("edit_form")));
		
		
		driver.findElement(By.xpath("//*[@id='edit_form']/table/tbody/tr[2]/td[2]/input")).clear();
		driver.findElement(By.xpath("//*[@id='edit_form']/table/tbody/tr[2]/td[2]/input")).sendKeys("data1");
		

		driver.findElement(By.xpath("//*[@id='edit_form']/table/tbody/tr[9]/td[2]/input")).click();
		
		
		
		new WebDriverWait(driver, 5)
		.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("//table[@id='my_sites']//a[text()='data1']/../..//div[@title='Edit']")));
		


		// add a text add

		new WebDriverWait(driver, 5).until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath("//*[@id='my_text_ads_block']/a")));
		driver.findElement(By.xpath("//*[@id='my_text_ads_block']/a")).click();

		driver.switchTo()
				.frame(driver.findElement(By
						.xpath("//*[@id='textad_submit']/tbody/tr[1]/td/div/div[2]/div[4]/iframe")));
		driver.findElement(By.xpath("/html/body")).sendKeys(
				"This is my first ad");

		driver.switchTo().defaultContent();

		driver.switchTo()
				.frame(driver.findElement(By
						.xpath("//*[@id='textad_submit']/tbody/tr[2]/td[2]/iframe")));
		driver.findElement(By.xpath("html/body")).sendKeys(
				"Hello, this is a hover text");
		driver.switchTo().defaultContent();

		driver.findElement(By.name("url")).sendKeys("www.pravda.com.ua");
		driver.findElement(By.xpath("//*[@id='submit_button']")).click();

		driver.switchTo().defaultContent();

		// check ads stats and close

		new WebDriverWait(driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//*[@id='my_sites']/tbody/tr[2]/td[3]/div/div[1]")));

		driver.findElement(
				By.xpath("//*[@id='my_sites']/tbody/tr[2]/td[3]/div/div[1]"))
				.click();

		new WebDriverWait(driver, 5)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//span[text()='close']")));

		driver.findElement(By.xpath("//span[text()='close']")).click();

		driver.close();
	}
}
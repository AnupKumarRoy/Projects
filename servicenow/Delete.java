package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://dev114505.service-now.com");
	driver.switchTo().frame(0);
	driver.findElement(By.id("user_name")).sendKeys("admin");
	driver.findElement(By.id("user_password")).sendKeys("Anup@1004");
	driver.findElement(By.id("sysverb_login")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(2000);
	WebElement findElement = driver.findElement(By.id("filter"));
	Thread.sleep(2000);
	findElement.sendKeys("incident");
	Thread.sleep(2000);
	findElement.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
	driver.switchTo().defaultContent();//INC0008111
	driver.switchTo().frame("gsft_main");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'Press')]/following::input[1]")).sendKeys("INC0008111",Keys.ENTER);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("ok_button")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'Press')]/following::input[1]")).sendKeys("INC0008111",Keys.ENTER);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("gsft_main");
	String text = driver.findElement(By.xpath("//td[contains(text(),'No')]")).getText();
	System.out.println(text);
	driver.switchTo().defaultContent();
	driver.close();
		
}
}


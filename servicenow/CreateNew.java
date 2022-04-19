package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNew {

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
		driver.switchTo().frame("gsft_main");
		WebElement findElement2 = driver.findElement(By.xpath("(//a[contains(text(),'INC')])[1]"));
		String text = findElement2.getText();
		System.out.println(text);
		boolean displayed = findElement2.isDisplayed();
		System.out.println(displayed);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement findElement3 = driver.findElement(By.xpath("//span[contains(text(),'Press')]/following-sibling::input"));
		findElement3.sendKeys(text,Keys.ENTER);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		String text2 = driver.findElement(By.xpath("//td[@class='vt']/a")).getText();
		System.out.println(text2);
		driver.switchTo().defaultContent();
		if (text2.equals(text)) {
			System.out.println("Test Case Pass");
		}else {
			System.out.println("Test Case Fail");
		}
		
	}
}

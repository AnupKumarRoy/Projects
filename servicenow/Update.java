package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Update {

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
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//a[contains(text(),'INC')])[1]")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement findElement2 = driver.findElement(By.id("incident.urgency"));
		Select select = new Select(findElement2);
		select.selectByValue("1");
		WebElement findElement3 = driver.findElement(By.name("incident.state"));
		Select select1 = new Select(findElement3);
		select1.selectByValue("2");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//a[contains(text(),'INC')])[1]")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		Boolean urgency = driver.findElement(By.xpath("(//option[@value='1'])[1]")).isSelected();
		System.out.println(urgency);
		Boolean state = driver.findElement(By.xpath("(//option[@value='2'])[2]")).isSelected();
		System.out.println(state);
		driver.switchTo().defaultContent();
	}

}


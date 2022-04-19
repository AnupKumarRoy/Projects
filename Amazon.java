package week3day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='a-price-symbol']/following::span)[1]"));
		String text = findElement.getText();
		System.out.println("Prize of the first product is ₹"+text);
		Thread.sleep(5000);
		WebElement findElement1 = driver.findElement(By.xpath("(//a/span[@class='a-size-base s-underline-text'])[1]"));
		String text2 = findElement1.getText();
		System.out.println("Number of customer are "+text2);
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='a-icon-alt']/..)[1]"));
		actions.doubleClick(findElement2).perform();
		WebElement findElement3 = driver.findElement(By.xpath("(//span/a[@class='a-link-normal'])[1]"));
		String text3 = findElement3.getText();
		System.out.println("Percentage of ratings for the 5 star "+text3);
		String attribute = driver.findElement(By.xpath("(//a[@target='_blank']//img)[1]")).getAttribute("src");
		System.out.println(attribute);
		Thread.sleep(2000);
		File src5 = driver.getScreenshotAs(OutputType.FILE);
		File des5= new File("./screenshot./amazon.png");
		FileUtils.copyFile(src5, des5);
		driver.findElement(By.xpath("(//h2//span)[1]")).click();
		//String parent = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> arrayList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(arrayList.get(1));
		driver.findElement(By.id("add-to-cart-button")).click();
		WebElement findElement4 = driver.findElement(By.id("attach-accessory-cart-subtotal"));
		String text4 = findElement4.getText();
		System.out.println(text4);
	
	}

}

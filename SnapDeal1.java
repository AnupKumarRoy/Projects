package week3day5;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		WebElement men = driver.findElement(By.xpath("//span[@class='catText']"));
		actions.moveToElement(men).perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		Thread.sleep(2000);
		WebElement findElement7 = driver.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following::div[1]"));
		String text4 = findElement7.getText();
		System.out.println("No. Of Shoes is "+text4);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sorting-sec animBounce']")).click();
		driver.findElement(By.xpath("(//ul/li[@data-index='1'])[2]")).click();
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Sort by:']/following::div[1]"));
		boolean displayed = findElement.isDisplayed();
		System.out.println(displayed);
		WebElement findElement2 = driver.findElement(By.name("fromVal"));
		findElement2.clear();
		findElement2.sendKeys("900");
		WebElement findElement3 = driver.findElement(By.name("toVal"));
		findElement3.clear();
		findElement3.sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-input']/following::div[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']//span")).click();
		Thread.sleep(2000);
		
		WebElement findElement4 = driver.findElement(By.xpath("//div[@class='filters']/div[1]/a"));
		boolean displayed2 = findElement4.isDisplayed();
		System.out.println(displayed2);
		WebElement findElement5 = driver.findElement(By.xpath("//div[@class='filters']/div[2]/a"));
		boolean displayed3 = findElement5.isDisplayed();
		System.out.println(displayed3);
		
		Thread.sleep(2000);
		Actions actions2 = new Actions(driver);
		WebElement findElement6 = driver.findElement(By.xpath("(//picture/img)[1]"));
		actions2.moveToElement(findElement6).perform();
		driver.findElement(By.xpath("(//div[@class='clearfix row-disc']/div)[1]")).click();
		Thread.sleep(2000);
		WebElement findElement8 = driver.findElement(By.xpath("//div/span[@class='payBlkBig']"));
		
		String text2 = findElement8.getText();
		WebElement findElement9 = driver.findElement(By.xpath("//div/span[@class='percent-desc ']"));
		String text3 = findElement9.getText();
		System.out.println(text2+";"+text3);
		Thread.sleep(2000);
		File src5 = driver.getScreenshotAs(OutputType.FILE);
		File des5= new File("./screenshot./snapdeal.png");
		FileUtils.copyFile(src5, des5);
		driver.close();
		driver.quit();

	}

}

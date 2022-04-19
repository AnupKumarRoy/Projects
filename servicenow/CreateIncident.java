package servicenow;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident {

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
		driver.findElement(By.xpath("//a[text()='INC0008111']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		String parent = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> arrayList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(arrayList.get(1));
		driver.findElement(By.xpath("//span[contains(text(),'Press')]/following::input[1]")).sendKeys("Software",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		driver.switchTo().window(parent);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.assigned_to")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> arrayList1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(arrayList1.get(1));
		driver.findElement(By.xpath("//a[text()='Beth Anglin']")).click();
		driver.switchTo().window(parent);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		WebElement findElement2 = driver.findElement(By.id("activity-stream-textarea"));
		findElement2.click();
		findElement2.sendKeys("WORK NOTE");
		driver.findElement(By.xpath("(//button[text()='Update'])[1]")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		String assigment="Software";		
		String assigedTo="Beth Anglin";
		String text = driver.findElement(By.linkText("Software")).getText();
		String text1 = driver.findElement(By.linkText("Beth Anglin")).getText();
		if (assigment.equals(text)) {
			System.out.println("Assignmet Group is Software");
			
		}else {
			System.out.println("Assignmet Group is not Software");
		}
		if (assigedTo.equals(text1)) {
			System.out.println("Assiged To is Beth Anglin");
			
		}else {
			System.out.println("Assigned To is not Beth Anglin");
		}
		
		driver.switchTo().defaultContent();
		driver.close();
			
	}

}


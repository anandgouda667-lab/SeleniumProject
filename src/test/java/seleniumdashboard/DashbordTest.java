package seleniumdashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DashbordTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// implicit wait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// explicit wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// OrangeHRM Dashbord

		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))
				
		);
		name.sendKeys("Admin");
		

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))
				
		);

		password.sendKeys("admin123");

		// click on login button
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
		System.out.println("login attempted");
		
		// dashbord visible the text
		
		WebElement dashbord = driver.findElement(By.xpath("//span[text()='Dashboard']"));
		String text = dashbord.getText();
         System.out.println(text);
         
         driver.quit();
	}

}

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class locaters {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("Shashi@123456");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();// Thread.sleep(5);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.reset-pwd-btn")));
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Shashidhar");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Shashidhar.y@craftsilicon.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9738082343");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();// Thread.sleep(500);
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Shashidhar");
		driver.findElement(By.cssSelector(" input[type*='pass']")).sendKeys("rahulshettyacademy");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("chkboxOne")));
		driver.findElement(By.id("chkboxOne")).click();// Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("chkboxTwo")));
		driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText());
		driver.findElement(By.xpath("//button[contains(@class,'logout-btn')]")).click();
		System.out.println(driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/h1")).getText());

		WebElement someElement = driver.findElement(By.xpath("//*[@id=\"container\"]/div[3]/div/div[2]/h1"));
		if (someElement.isDisplayed()){
		System.out.println("loggedout");
		}else {
			System.out.println(" not loggedout");
		}
		driver.close();
		driver.quit();
	}	

}

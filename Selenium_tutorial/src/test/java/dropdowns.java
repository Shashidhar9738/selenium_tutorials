import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdowns {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(3);

		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.id("divpaxinfo")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		int i = 1;
		while (i < 4) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;

		}
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='BLR']")));
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value='BLR']")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='MAA']")));
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		System.out.println(driver.findElement(By.xpath("//a[@value='MAA']")).getText());
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_view_date1")));
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		if (wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_view_date1"))) != null) {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[5]/a")));
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[5]/a")).click();
			// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date1")).getText());
		} else {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[1]/td[6]/a")));
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[1]/td[6]/a")).click();
			// System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date1")).getText());
		}
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class=ui-menu-item] a"));
		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				
			}
		}
		
		
		
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.close();
		//driver.quit();
	}

}

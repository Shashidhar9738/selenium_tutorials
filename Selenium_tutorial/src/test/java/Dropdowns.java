import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdowns {

    public static void main(String[] args) throws InterruptedException {
        // Initialize WebDriver
    
    	
        WebDriver driver = new EdgeDriver();
        
        // Set up WebDriverWait with 10 seconds timeout
        @SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Maximize browser window
        driver.manage().window().maximize();
        
        // Navigate to the website
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // Select from static dropdown (Currency dropdown)
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        
        // Select by index and print selected option
        dropdown.selectByIndex(3);
        System.out.println("Selected Currency: " + dropdown.getFirstSelectedOption().getText());
        
        // Select by visible text and print selected option
        dropdown.selectByVisibleText("AED");
        System.out.println("Selected Currency: " + dropdown.getFirstSelectedOption().getText());
        
        // Click on passengers dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        
        // Wait until adult increment button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefIncAdt")));
        
        // Print initial number of passengers
        System.out.println("Initial Passengers: " + driver.findElement(By.id("divpaxinfo")).getText());
        
        // Increment number of adults to 4
        int i = 1;
        while (i < 4) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        
        // Print final number of passengers
        System.out.println("Updated Passengers: " + driver.findElement(By.id("divpaxinfo")).getText());
        
        // Select origin and destination from dynamic dropdowns
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        
        // Select BLR (Bangalore) as the origin
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='BLR']")));
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        System.out.println("Selected Origin: " + driver.findElement(By.xpath("//a[@value='BLR']")).getText());
        
        // Select MAA (Chennai) as the destination
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='MAA']")));
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        System.out.println("Selected Destination: " + driver.findElement(By.xpath("//a[@value='MAA']")).getText());
        
        // Click on the date picker and select a date
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        
        // Selecting date based on availability
        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[5]/a")));
        dateElement.click();
        
        // Autosuggest for country selection
        driver.findElement(By.id("autosuggest")).sendKeys("IND");
        
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break; // Break once India is selected
            }
        }
        
        // Select Senior Citizen Discount checkbox
        WebElement seniorCitizenCheckbox = driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']"));
        if (!seniorCitizenCheckbox.isSelected()) {
            seniorCitizenCheckbox.click();
        }
        
        // Verify if Senior Citizen Discount is selected
        System.out.println("Senior Citizen Discount selected: " + seniorCitizenCheckbox.isSelected());
        
        // Close the browser
        driver.close();
    }
}

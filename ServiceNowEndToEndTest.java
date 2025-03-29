package EndtoEnd;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ServiceNowEndToEndTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit Wait
        driver.get("https://www.servicenow.com");
        System.out.println("Website opened: " + driver.getTitle());
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String expectedTitle = "ServiceNow – Put AI to Work"; // Update if title changes
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
        System.out.println("Verified the title successfully: " + actualTitle);
    }

    @Test(priority = 2)
    public void getStarted() {
        // Navigate to form
       driver.findElement(By.partialLinkText("Get Started")).click();

        // Fill in form details
        driver.findElement(By.id("field8")).sendKeys("goswamik1221@gmail.com");
        driver.findElement(By.id("field6")).sendKeys("Kanav");
        driver.findElement(By.id("field7")).sendKeys("Goswami");
        driver.findElement(By.id("field9")).sendKeys("Masai");
        driver.findElement(By.id("field13")).sendKeys("9682513658");

        WebElement jobLevel = driver.findElement(By.id("field10")); // Ensure correct ID
        jobLevel.sendKeys("Developer/Engineer");

        WebElement department = driver.findElement(By.id("field11")); // Update ID for department
        department.sendKeys("IT");

    }

    @Test(priority = 3)
    public void dropdown() {
        WebElement Products = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Products")));
        Products.click();
        driver.findElement(By.xpath("//span[text()='Platform']")).click(); 
    }
    
    @Test
    public void login() {
    	driver.findElement(By.xpath("//i[@slot=\"fa-icon-user-circle\"]")).click();
    	driver.findElement(By.partialLinkText("Create an account")).click();
    	driver.findElement(By.id("email")).sendKeys("goswamik1221@gmail.com");
    	driver.findElement(By.id("text")).sendKeys("Kanav");
    	 	
    	  	
    }

    @AfterClass
    public void quit() {
      //  driver.quit();
        System.out.println("Browser closed.");
    }
}

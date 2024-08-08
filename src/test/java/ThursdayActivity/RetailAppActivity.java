package ThursdayActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RetailAppActivity {
    public static void main(String[] args) {

                WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://retail.tekschool-students.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#signinLink")))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")))
                .sendKeys("ziamustafa2000@hotmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='password']")))
                .sendKeys("786@Allah");

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".login__submit")))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("accountLink")))
                .click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameInput")))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameInput")))
                .sendKeys("Mustafa");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='phoneNumber']")))
                .clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='phoneNumber']")))
                .sendKeys("442-202-9999");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#personalUpdateBtn")))
                .click();
        //

        WebElement updateElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("74nd8xi")));
        System.out.println(updateElement.getText());

    }
}

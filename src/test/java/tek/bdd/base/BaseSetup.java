package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseSetup {

    //Encapsulating driver instance
    private static WebDriver driver;
    public void setupBrowser( ){
        /*
        Web Driver instance
        Navigation to Retail
        maximize
        and implicitly wait
         */
        driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void quitBrowser(){

        if (driver !=null){
            driver.quit();
        }

    }

    public WebDriver getDriver(){
        return driver;
    }
}

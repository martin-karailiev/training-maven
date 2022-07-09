package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.Cookie;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    public void setUp () {
        System.setProperty("webdriver.chrome.driver","C:\\Temp\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        ChromeOptions options = new ChromeOptions();
       options.addArguments("--headless");
        options.addArguments("--window-size=1920x1080");

    }

    @Test
public void testLoginPage () {
    driver.get("http://training.skillo-bg.com/users/login");

    WebElement userName = driver.findElement(By.cssSelector("#defaultLoginFormUsername"));
    WebElement passWord = driver.findElement(By.cssSelector("#defaultLoginFormPassword"));
    WebElement signIn = driver.findElement(By.cssSelector("#sign-in-button"));

    userName.sendKeys("odin");
    passWord.sendKeys("test1234");
    signIn.click();

    By logOut = By.cssSelector(".fas.fa-sign-out-alt.fa-lg");
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(logOut)));

    softAssert.assertTrue(driver.findElement(logOut).isDisplayed());

    }

    @Test(dependsOnMethods = "testLoginPage")
    public void testProfile (){

        driver.get("http://training.skillo-bg.com/users/login");

        WebElement userName = driver.findElement(By.cssSelector("#defaultLoginFormUsername"));
        WebElement passWord = driver.findElement(By.cssSelector("#defaultLoginFormPassword"));
        WebElement signIn = driver.findElement(By.cssSelector("#sign-in-button"));

        userName.sendKeys("odin");
        passWord.sendKeys("test1234");
        signIn.click();

        WebElement profile = driver.findElement(By.cssSelector("#nav-link-profile"));
        profile.click();

        By editProfile = By.cssSelector(".fas.fa-user-edit.ng-star-inserted");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(editProfile)));

        Assert.assertTrue(driver.findElement(editProfile).isDisplayed());

    }

    @AfterTest
    public void closeDown () {
        driver.quit();
    }
}

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InternetTest {
    WebDriver driver;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rb26512\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
    }

    @After
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void logIntoAccount2(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
    }
    @Test
    public void canNotLoginUsingWrongName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.open().login("tom", "Super!");
        Assert.assertTrue(loginPage.isAt());
    }

    @Test
    public void canChangeDropDownOption() {
        DropDownPage dropDownPage = new DropDownPage(driver);
        dropDownPage.open();
        Assert.assertEquals(dropDownPage.getSelectedOption(), "Please select an option");
        dropDownPage.selectOption(1);
        Assert.assertEquals(dropDownPage.getSelectedOption(),"Option 1");
        dropDownPage.selectOption(2);
        Assert.assertEquals(dropDownPage.getSelectedOption(),"Option 2");

    }

    @Test
    public void canTestFormAutentication() {
        driver.findElement(By.linkText("Form Authentication")).click();
        WebElement inputLogin = driver.findElement(By.id("username"));
        inputLogin.sendKeys("tomsmith");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("SuperSecretPassword!");
        WebElement button = driver.findElement(By.className("radius"));
        button.click();
        // Assert.assertTrue(driver.getPageSource().contains("Welcome to the Secure Area. When you are done click logout below."));
        //WebElement buttonSecondary = driver.findElement(By.className("button secondary radius"));

    }

    @Test
    public void canShowHoverHint(){
        driver.findElement(By.linkText("Hovers")).click();
        List <WebElement>avatars = driver.findElements(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(avatars.get(0)).build().perform();
        Assert.assertTrue(avatars.get(0).findElement(By.className("figcaption")).isDisplayed());
        actions.moveToElement(avatars.get(1)).build().perform();
        Assert.assertTrue(avatars.get(1).findElement(By.className("figcaption")).isDisplayed());
        actions.moveToElement(avatars.get(2)).build().perform();
        Assert.assertTrue(avatars.get(2).findElement(By.className("figcaption")).isDisplayed());
        //for (int i= 0 ; i< avatars.size(); i++){
        //actions.moveToElement(avatars.get(i)).build().perform();
        //Assert.assertTrue(avatars.get(i).findElement(By.className("figcaption")).isDisplayed());
    }
    @Test
    public void canWait(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();
        WebElement helloWord = driver.findElement(By.id("finish"));
        Assert.assertTrue(helloWord.isDisplayed());
    }
    @Test
    public void canWait2(){
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement helloWorld = driver.findElement(By.id("finish"));
        Assert.assertFalse(helloWorld.isDisplayed());
        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assert.assertTrue(helloWorld.isDisplayed());
    }
    @Test
    public void canOpenLoginPage(){
        LoginPage loginPage = new LoginPage(driver);
        SecureAreaPage secureAreaPage = loginPage.open().login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(secureAreaPage.isAt());

    }

}


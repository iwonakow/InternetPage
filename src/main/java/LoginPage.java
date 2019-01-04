import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private String title = "The Internet";
    private String url = "http://the-internet.herokuapp.com/login";
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public LoginPage open(){
        driver.get(url);
        return this;
    }
    public boolean isAt(){
        return driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title);
    }
    public SecureAreaPage login(String login, String password){
        WebElement loginField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        WebElement buttonLogin = driver.findElement(By.className("radius"));
        buttonLogin.click();
        return new SecureAreaPage(driver);
    }
}
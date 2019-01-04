import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private String title = "The Internet";
    private String url = "http://the-internet.herokuapp.com/secure";
    private WebDriver driver;

    public SecureAreaPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isAt() {
        return driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title);
    }
}
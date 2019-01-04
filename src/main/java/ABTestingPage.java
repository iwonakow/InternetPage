import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ABTestingPage {
    private String url = "https://the-internet.herokuapp.com/abtest";
    private WebDriver driver;
    //private String text;
    private String title = "The Internet";

    public ABTestingPage(WebDriver driver){
        this.driver = driver;
    }
    public ABTestingPage openABTesting(){
        driver.get(url);
        return this;
    }

    public boolean isAtABTesting(){
        return driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title);
        }
    }

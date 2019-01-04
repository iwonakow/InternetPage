import org.openqa.selenium.WebDriver;

public class HoversPage {
    private String title = "The Internet";
    private String url = "http://the-internet.herokuapp.com/hovers";
    private WebDriver driver;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public HoversPage open() {
        driver.get(url);
        return this;
    }

    public boolean isAt() {
        return driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title);
    }

}
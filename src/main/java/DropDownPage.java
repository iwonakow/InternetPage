import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    private String title = "The Internet";
    private String url = "http://the-internet.herokuapp.com/dropdown";
    private WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public DropDownPage open() {
        driver.get(url);
        return this;
    }

    public boolean isAt() {
        return driver.getCurrentUrl().equals(url) && driver.getTitle().equals(title);
    }
    public void selectOption(int option){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select selector = new Select(dropdown);
        selector.selectByIndex(option);
    }
    public String getSelectedOption(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select selector = new Select(dropdown);
        return selector.getFirstSelectedOption().getText();
    }
}

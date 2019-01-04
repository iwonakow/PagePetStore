import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    public boolean canCheckSiteAfterLogIn(){
        WebElement dogBanner = driver.findElement(By.id("Banner"));
        boolean dogBanner1 = dogBanner.isDisplayed();
        return dogBanner1;

    }

}

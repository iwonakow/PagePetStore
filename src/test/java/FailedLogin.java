import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FailedLogin {
private WebDriver driver;

@ Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rb26512\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://przyklady.javastart.pl/jpetstore/");




}
@After
    public void afterTest(){
        driver.close();
        driver.quit();
    }
@Test
    public void asUserTryToLogInWithIncorerectLoginAndPassword(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("NotExistingLogin");
        loginPage.typeIntoPasswordField("NotExistingLogin");
        loginPage.clickOnLoginButton();
        String warningMessage = loginPage.getWarningMessage();
        Assert.assertEquals(warningMessage,"Invalid username or password. Signon failed.");


}
    @Test
   public void asUserTryToLoginWithCorrectLoginAndPasswrd(){
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();
        TopMenuPage topMenuPage = new TopMenuPage(driver);
        topMenuPage.clickOnSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoUserNameField("j2ee");
        loginPage.typeIntoPasswordField("j2ee");
        loginPage.clickOnLoginButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.canCheckSiteAfterLogIn());
   }
   @Test
    public void asUserSearchThePetOnTheWebsite() throws InterruptedException {
       LandingPage landingPage = new LandingPage(driver);
       landingPage.clickOnEnterStoreLink();
       WebElement searchField = driver.findElement(By.name("keyword"));
       searchField.sendKeys("fish");
       WebElement searchButton = driver.findElement(By.name("searchProducts"));
       searchButton.click();



   }
}
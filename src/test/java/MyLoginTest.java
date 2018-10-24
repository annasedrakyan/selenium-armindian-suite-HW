import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertTrue;


public class MyLoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/annasedrakyan/dev/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void loginSuccess() {
        MyLoginPage login = new MyLoginPage(driver);
        login.loginAction("tomsmith", "SuperSecretPassword!");

        assertTrue(login.isLoginSuccess(), "Success login message was not displayed" );


    }

    @Test
    public void signOut() {
        MyLoginPage login = new MyLoginPage(driver);
          login.loginAction("tomsmith", "SuperSecretPassword!");
          login.signOut();

        assertTrue(login.isLoginSuccess(), "Logout message was not displayed" );


    }

    @Test
    public void loginFailed() {
        MyLoginPage login = new MyLoginPage(driver);
        login.loginAction(("aaaaa"), "asassa");

        assertTrue(login.isLoginFailed(), "error message was not displayed");
    }



    @AfterMethod
    public void quit() {
        driver.quit();
    }




}

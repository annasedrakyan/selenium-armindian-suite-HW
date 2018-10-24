import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;



public class MyLoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton   = By.className("fa-sign-in");
    private By successLogin  = By.className("success");
    private By errorMessage  = By.className("error");
    private By logoutButton  = By.className("icon-signout");


    public  MyLoginPage (WebDriver driver) {
        this.driver = driver;
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void loginAction (String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

    }

    public boolean isLoginSuccess() {
        return driver.findElement(successLogin).isDisplayed();
    }

    public boolean isLoginFailed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public void signOut() {
        driver.findElement(logoutButton).click();
    }

}


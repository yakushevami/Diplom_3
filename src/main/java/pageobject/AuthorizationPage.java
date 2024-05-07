package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static constants.Urls.*;

public class AuthorizationPage {
    private final By authorizationPageHeader = By.xpath(".//h2[text()='Вход']");
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private final By authorizeButton = By.xpath(".//*[text()='Войти']");

    private final WebDriver driver;

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open authorization page")
    public void openLoginPage() {
        driver.get(LOGIN_PAGE_URL);
    }

    @Step("Wait for authorization page to load")
    public void waitAuthorizationPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (driver.findElement(authorizationPageHeader).isEnabled()));
    }

    @Step("Enter user's email and password in authorization form")
    public void fillAuthorizationForm(String email, String password) {
        waitAuthorizationPageLoad();
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click authorize button")
    public void clickAuthorizeButton() {
        driver.findElement(authorizeButton).click();
    }
}
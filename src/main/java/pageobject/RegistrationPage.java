package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static constants.Urls.*;

public class RegistrationPage {
    private final By registrationPageHeader = By.xpath(".//h2[text()='Регистрация']");
    private final By nameField = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By passwordErrorMessage = By.xpath(".//p[text()='Некорректный пароль']");
    private final By authorizeText = By.xpath(".//*[text()='Войти']");

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open registration page")
    public void openRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
    }

    @Step("Wait for registration page to load")
    public void waitRegistrationPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (driver.findElement(registrationPageHeader).isEnabled()));
    }

    @Step("Enter user's email and password in authorization form")
    public void fillRegistrationForm(String name, String email, String password) {
        waitRegistrationPageLoad();
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);

        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Click register button")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Click authorize text")
    public void clickAuthorizeText() {
        driver.findElement(authorizeText).click();
    }

    @Step("Get password error text")
    public String getPasswordErrorText() {
        return driver.findElement(passwordErrorMessage).getText();
    }
}
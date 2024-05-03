package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static constants.Urls.*;

public class ForgotPasswordPage {
    private final By forgotPasswordPageHeader = By.xpath(".//h2[text()='Восстановление пароля']");
    private final By authorizeText = By.xpath(".//*[text()='Войти']");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open forgot password page")
    public void openForgotPasswordPage() {
        driver.get(FORGOT_PASSWORD_PAGE_URL);
    }

    @Step("Wait for home page to load")
    public void waitForgotPasswordPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (driver.findElement(forgotPasswordPageHeader).isEnabled()));
    }

    @Step("Click authorize text")
    public void clickAuthorizeText() {
        waitForgotPasswordPageLoad();
        driver.findElement(authorizeText).click();
    }
}
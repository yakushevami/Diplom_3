package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProfilePage {
    private final By homePageHeader = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private final By profilePageHeader = By.xpath(".//*[text()='Профиль']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logOutButton = By.xpath(".//button[text()='Выход']");

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Wait for profile page to load")
    public void waitProfilePageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (driver.findElement(profilePageHeader).isEnabled()));
    }

    @Step("Click constructor button")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Click home page header")
    public void clickHomePageHeader() {
        driver.findElement(homePageHeader).click();
    }

    @Step("Click logout button")
    public void clickLogoutButton() {
        waitProfilePageLoad();
        driver.findElement(logOutButton).click();
    }
}
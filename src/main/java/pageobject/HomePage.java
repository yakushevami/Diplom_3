package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static constants.Urls.*;

public class HomePage {
    private final By homePageHeader = By.xpath(".//*[@class='active']");
    private final By profileButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By orderButton = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button");
    private final By sectionBun = By.xpath(".//span[text()='Булки']");
    private final By sectionFiling = By.xpath(".//span[text()='Начинки']");
    private final By sectionSauce = By.xpath(".//span[text()='Соусы']");
    private final By chosenSection = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Open home page")
    public void openHomePage() {
        driver.get(BASE_URL);
    }

    @Step("Wait for home page to load")
    public void waitHomePageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (driver.findElement(homePageHeader).isEnabled()));
    }

    @Step("Click profile button")
    public void clickProfileButton() {
        waitHomePageLoad();
        driver.findElement(profileButton).click();
    }

    @Step("Click create order button")
    public void clickCreateOrderButton() {
        waitHomePageLoad();
        driver.findElement(orderButton).click();
    }

    @Step("Get create order button text")
    public String getTextFromOrderButton() {
        waitHomePageLoad();
        return driver.findElement(orderButton).getText();
    }

    @Step("Click bun section in constructor")
    public void clickBunSection() {
        waitHomePageLoad();
        clickSauceSection();
        driver.findElement(sectionBun).click();
    }

    @Step("Click sauce section in constructor")
    public void clickSauceSection() {
        waitHomePageLoad();
        driver.findElement(sectionSauce).click();
    }

    @Step("Click filling section in constructor")
    public void clickFillingSection() {
        waitHomePageLoad();
        driver.findElement(sectionFiling).click();
    }

    @Step("Get chosen section's name")
    public String getNameChosenSection() {
        waitHomePageLoad();
        return driver.findElement(chosenSection).getText();
    }
}
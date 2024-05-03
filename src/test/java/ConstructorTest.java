import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.HomePage;
import static org.junit.Assert.assertEquals;

public class ConstructorTest extends CreateAndDeleteUser {

    @Test
    @DisplayName("Click bun section in constructor")
    public void clickBunSectionTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickBunSection();
        assertEquals("Булки", homePage.getNameChosenSection());
    }

    @Test
    @DisplayName("Click sauce section in constructor")
    public void clickSauceSectionTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickSauceSection();
        assertEquals("Соусы", homePage.getNameChosenSection());
    }

    @Test
    @DisplayName("Click filling section in constructor")
    public void clickFillingSectionTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.clickFillingSection();
        assertEquals("Начинки", homePage.getNameChosenSection());
    }
}
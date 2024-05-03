import constants.UserApi;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pageobject.AuthorizationPage;
import pageobject.HomePage;
import pageobject.ProfilePage;
import static constants.Urls.*;
import static org.junit.Assert.assertEquals;

public class ProfilePageTest extends CreateAndDeleteUser {

    @Before
    public void setUp() {
        UserApi.createUserApi(user);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        authorizationPage.openLoginPage();
        authorizationPage.fillAuthorizationForm(user.getEmail(), user.getPassword());
        authorizationPage.clickAuthorizeButton();
    }

    @Test
    @DisplayName("Open profile page")
    public void checkUserWithAuthClickProfileButton() {
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        homePage.clickProfileButton();

        profilePage.waitProfilePageLoad();
        assertEquals(PROFILE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("From: profile page, to: home page")
    public void checkClickLogo() {
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        homePage.clickProfileButton();
        profilePage.clickHomePageHeader();

        homePage.waitHomePageLoad();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("From: profile page, to: constructor")
    public void checkClickConstructorButton() {
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        homePage.clickProfileButton();
        profilePage.clickConstructorButton();

        homePage.waitHomePageLoad();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }
}
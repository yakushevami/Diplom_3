import constants.UserApi;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.AuthorizationPage;
import pageobject.HomePage;
import pageobject.ProfilePage;
import static constants.Urls.LOGIN_PAGE_URL;
import static org.junit.Assert.assertEquals;

public class LogoutTest extends CreateAndDeleteUser {

    @Test
    @DisplayName("Logout from profile page")
    public void logoutTest() {
        UserApi.createUserApi(user);

        AuthorizationPage authorizationPage = new AuthorizationPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        authorizationPage.openLoginPage();
        authorizationPage.fillAuthorizationForm(user.getEmail(), user.getPassword());
        authorizationPage.clickAuthorizeButton();

        homePage.clickProfileButton();
        profilePage.clickLogoutButton();
        authorizationPage.waitAuthorizationPageLoad();

        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }
}
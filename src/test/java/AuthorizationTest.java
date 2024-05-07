import constants.UserApi;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.AuthorizationPage;
import pageobject.ForgotPasswordPage;
import pageobject.HomePage;
import pageobject.RegistrationPage;
import static org.junit.Assert.assertEquals;

public class AuthorizationTest extends CreateAndDeleteUser {

    @Test
    @DisplayName("Authorize user via main page login button")
    public void authorizeUserMainPageTest() {
        UserApi.createUserApi(user);
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        homePage.openHomePage();
        homePage.clickCreateOrderButton();

        authorizationPage.fillAuthorizationForm(user.getEmail(), user.getPassword());
        authorizationPage.clickAuthorizeButton();

        homePage.waitHomePageLoad();
        assertEquals("Оформить заказ", homePage.getTextFromOrderButton());
    }

    @Test
    @DisplayName("Authorize user via profile page")
    public void authorizeUserProfilePageTest() {
        UserApi.createUserApi(user);
        HomePage homePage = new HomePage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        homePage.openHomePage();
        homePage.clickProfileButton();

        authorizationPage.fillAuthorizationForm(user.getEmail(), user.getPassword());
        authorizationPage.clickAuthorizeButton();

        homePage.waitHomePageLoad();
        assertEquals("Оформить заказ", homePage.getTextFromOrderButton());
    }

    @Test
    @DisplayName("Authorize user via registration form login button")
    public void authorizeUserRegistrationPageTest() {
        UserApi.createUserApi(user);
        HomePage homePage = new HomePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        registrationPage.openRegisterPage();
        registrationPage.clickAuthorizeText();

        authorizationPage.fillAuthorizationForm(user.getEmail(), user.getPassword());
        authorizationPage.clickAuthorizeButton();

        homePage.waitHomePageLoad();
        assertEquals("Оформить заказ", homePage.getTextFromOrderButton());
    }

    @Test
    @DisplayName("Authorize user via forgot password form login button")
    public void authorizeUserForgotPasswordPageTest() {
        UserApi.createUserApi(user);
        HomePage homePage = new HomePage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        forgotPasswordPage.openForgotPasswordPage();
        forgotPasswordPage.clickAuthorizeText();

        authorizationPage.fillAuthorizationForm(user.getEmail(), user.getPassword());
        authorizationPage.clickAuthorizeButton();

        homePage.waitHomePageLoad();
        assertEquals("Оформить заказ", homePage.getTextFromOrderButton());
    }
}
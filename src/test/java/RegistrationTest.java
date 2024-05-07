import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.AuthorizationPage;
import pageobject.RegistrationPage;

import static constants.Urls.*;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends CreateAndDeleteUser {

    @Test
    @DisplayName("Register user with correct name, email and password values")
    public void registerUserWithAllFieldsCorrectTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        AuthorizationPage authorizationPage = new AuthorizationPage(driver);

        registrationPage.openRegisterPage();
        registrationPage.fillRegistrationForm(user.getName(), user.getEmail(), user.getPassword());
        registrationPage.clickRegisterButton();

        authorizationPage.waitAuthorizationPageLoad();
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Register user with correct name and email with password length = 5")
    public void registerUserWithPasswordLengthFiveTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.openRegisterPage();
        registrationPage.fillRegistrationForm(user.getName(), user.getEmail(), "12345");
        registrationPage.clickRegisterButton();

        assertEquals("Некорректный пароль", registrationPage.getPasswordErrorText());
    }
}
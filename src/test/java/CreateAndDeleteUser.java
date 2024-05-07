import org.junit.After;
import org.junit.Before;
import user.User;
import user.UserGenerator;
import constants.UserApi;
import browsersettings.BrowserSelector;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;

public class CreateAndDeleteUser {
    WebDriver driver;
    User user;
    String accessToken;

    @Before
    public void createUser() {
        driver = BrowserSelector.getDriver();
        user = UserGenerator.getNewRandomUser();
    }

    @After
    public void deleteUser() {
        Response responseLoginUser = UserApi.authorizeUserApi(user);
        try { accessToken = responseLoginUser.then().log().all().extract().path("accessToken").toString(); }
        catch (Exception e) { accessToken = null; }
        if (accessToken != null) { UserApi.deleteUserApi(accessToken); }
        driver.quit();
    }
}
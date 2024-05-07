package constants;

import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.qameta.allure.Step;
import user.User;
import static constants.Urls.*;
import static io.restassured.RestAssured.given;

public class UserApi {
    public static final String API_REGISTER = "api/auth/register";
    public static final String API_LOGIN = "/api/auth/login";
    public static final String API_USER = "api/auth/user";

    public static RequestSpecification getSpec() {
        return given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL);
    }

    @Step("Create user")
    public static Response createUserApi(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(API_REGISTER);
    }

    @Step("Authorize user")
    public static Response authorizeUserApi(User user) {
        return getSpec()
                .body(user)
                .when()
                .post(API_LOGIN);
    }

    @Step("Delete user")
    public static void deleteUserApi(String accessToken) {
        getSpec()
                .header("Authorization", accessToken)
                .when()
                .delete(API_USER);
    }
}
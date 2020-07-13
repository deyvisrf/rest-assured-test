package spec;

import org.junit.Test;
import support.BaseTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class Get extends BaseTest {

    @Test public void
    starWarsCheckTest() {
        given()
                .log().all()
        .when()
                .get("https://swapi.dev/api/people/1/")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Luke Skywalker"));
    }

    @Test public void
    dontAccessWithoutPassword() {
        given()
                .log().all()
        .when()
                .get("basicauth")
        .then()
                .log().all()
                .statusCode(401);
    }

    @Test public void
    authenticationSuccess() {
        given()
                .log().all()
                .auth().basic(user, password)
        .when()
                .get("basicauth")
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is("logado"));
    }

    @Test public void
    authentiction() {
        Map<String, String> postBody = new HashMap<>();

        postBody.put("email", "teste@teste.me");
        postBody.put("redirecionar", "false");
        postBody.put("senha", "qwer");



        given()
                .log().all()
                .body(postBody)
        .when()
                .post("https://barrigarest.wcaquino.me/signin")
        .then()
                .log().all()
                .statusCode(200)
                .body("token", is(notNullValue()));
    }
}
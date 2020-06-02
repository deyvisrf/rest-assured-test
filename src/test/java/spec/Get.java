package spec;

import org.junit.Test;
import support.BaseTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get extends BaseTest {

    @Test public void
    starWarsCheckTest() {
        given()
                .log().all()
        .when()
                .get("people/1/")
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Luke Skywalker"));
    }
}
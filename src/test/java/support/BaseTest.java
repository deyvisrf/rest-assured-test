package support;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.BeforeClass;

public class BaseTest implements Constants {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = baseUrl;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(contentType);
        RestAssured.requestSpecification = reqBuilder.build();
    }
}

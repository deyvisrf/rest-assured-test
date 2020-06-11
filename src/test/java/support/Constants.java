package support;

import io.restassured.http.ContentType;

public interface Constants {

    String baseUrl = "https://restapi.wcaquino.me/";

    String user = "admin";
    String password = "senha";

    ContentType contentType = ContentType.JSON;
}
package com.switchfully.modules.actions01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {

    public static final String EXPECTED_RESPONSE = "ok";
    public static final String BASE_URL = "http://localhost";
    public static final String PATH = "/actions";
    @LocalServerPort
    private int port;

    @Test
    void getOk_givenNothing_thenReturnOkString() {
        String response = given()
                .baseUri(BASE_URL)
                .port(port)
                .when()
                .contentType(JSON)
                .get(PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .asString();

        Assertions.assertThat(response).isEqualTo(EXPECTED_RESPONSE);
    }
}
package ru.netology.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        RestAssured.given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
                // static import для JsonSchemaValidator.matchesJsonSchemaInClasspath
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"))
        ;
    }
}

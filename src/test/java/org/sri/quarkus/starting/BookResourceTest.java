package org.sri.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import jakarta.ws.rs.core.HttpHeaders;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    public void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when().get("/api/books")
          .then()
             .statusCode(200)
             .body("size()", is(3));
    }


    @Test
    public void shouldCountAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when().get("/api/books/count")
                .then()
                .statusCode(200)
                .body( is("3"));
    }


    @Test
    public void shouldGetABook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParams("id", 3)
                .when().get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body( "title", is("Naaliyira Dhivya Prabhandham"))
                .body( "author", is("Alwar"))
                .body( "yearOfPublication", is(999))
                .body( "genre", is("Spiritual"));
    }
}
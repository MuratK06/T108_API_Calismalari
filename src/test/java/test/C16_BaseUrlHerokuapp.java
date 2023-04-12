package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

public class C16_BaseUrlHerokuapp extends HerokuAppBaseUrl {

/*

Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve
Response’ta 12 booking oldugunu test edin

2- https://restful-booker.herokuapp.com/booking
endpointine asagidaki body’ye sahip bir POST
request gonderdigimizde donen response’un
status code’unun 200 oldugunu ve “firstname”
degerinin “Ahmet” oldugunu test edin
 */

    @Test
    public void get01(){

        specHerokuApp.pathParam("pp1","booking");

        Response response = given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("booking", hasItem(12));

    }
}

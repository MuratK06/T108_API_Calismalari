package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_BodyTekrarlardanKurtulma {

     /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Jim",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */


    @Test
    public void get01() {
        // 1 - Request icin gerekli url hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";
        // 2 - Expected Data hazirla
        // 3 - Response'i kaydet
        Response response = given().when().get(url);
        response.prettyPrint();
        // 4 - Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mary"),
                        "lastname", Matchers.equalTo("Wilson"),
                        "totalprice", Matchers.equalTo(797),
                        "depositpaid", Matchers.equalTo(true),
                        "additionalneeds", Matchers.equalTo("Breakfast")
                );
    }
}

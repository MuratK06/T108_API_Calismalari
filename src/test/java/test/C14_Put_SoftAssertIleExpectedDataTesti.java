package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertIleExpectedDataTesti {

    /*

    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin
    Response Body
{ "status": "success",
"data": {
         "status": "success",
           "data": {
          "name": “Ahmet",
           "salary": "1230",
           "age": "44",
            "id": 40 }
              },
"message": "Successfully! Record ha
s been updated."}

     */

    @Test
    public void  get01(){

        // 1 - Url hazirla

        String url ="https://dummy.restapiexample.com/api/v1/update/21";

        JSONObject data = new JSONObject();


        data.put("name","Ahmet");
        data.put("salary",1230);
        data.put("age",44);
        data.put("id",40);

        JSONObject expBody = new JSONObject();

        expBody.put("status","success");
        expBody.put("message","\"Successfully! Record ha\n" +
                "s been updated.");
        expBody.put("data",data);

        System.out.println("expBody = " + expBody);


        // 3 - Response'i kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJS = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals( respJS.get("status") , expBody.get("status"));
        softAssert.assertEquals( respJS.get("message") , expBody.get("message"));
        softAssert.assertEquals( respJS.get("data.name") , expBody.getJSONObject("data").get("name"));
        softAssert.assertEquals( respJS.get("data.salary") , expBody.getJSONObject("data").get("salary"));
        softAssert.assertEquals( respJS.get("data.age") , expBody.getJSONObject("data").get("age"));
        softAssert.assertEquals( respJS.get("data.id") , expBody.getJSONObject("data").get("id"));


        softAssert.assertAll();



    }
}

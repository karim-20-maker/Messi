package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.ResponseMoel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIsCourse {
    public String  baseurl = "https://217ac6aa-afd9-413b-85e0-bb140f818ff6.mock.pstmn.io";
    @Test
    public void afirst (){
        String endpoint = "/course";
        var response = RestAssured.given().get(baseurl.concat(endpoint));
//        given().when().get(baseurl.concat(endpoint)).then().log().body();
        System.out.println(response.jsonPath().getString("name"));
        Assert.assertEquals((response.jsonPath().getString("name")),"karim");
        System.out.println(response.getBody().asString());
        System.out.println("******************************");


    }
    @Test
    public void bsecond (){
        String endpoint = "/course";
        given().
                when().
                get(baseurl.concat(endpoint)).
                then().assertThat()
                .statusCode(200)
                .body("name",equalTo("karim"));

    }
    @Test
    public void cThird (){
        String endpoint = "/course";
       int age=  given().
                when().
                get(baseurl.concat(endpoint)).
                as(ResponseMoel.class).getAge(); //pojo
        given().when().get(baseurl.concat(endpoint)).then();
        Assert.assertEquals(age,29);
        System.out.println(age);


    }
}

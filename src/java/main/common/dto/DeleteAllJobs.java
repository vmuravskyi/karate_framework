package common.dto;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class DeleteAllJobs {

    public static void deleteJob(int id) {
        RestAssured.given()
            .baseUri("https://jobportalkarate.herokuapp.com/normal/webapi/remove/" + id)
            .accept("application/json")
            .contentType("application/json")
            .when()
            .delete()
            .then()
            .statusCode(HttpStatus.SC_OK);
    }

    public static String getAllJobs() {
        Response response = RestAssured.given()
            .baseUri("https://jobportalkarate.herokuapp.com/normal/webapi/all")
            .accept("application/json")
            .when()
            .get()
            .then()
            .extract()
            .response();
        return response.asPrettyString();
    }

    public static void main(String[] args) {

        System.out.println(getAllJobs());

    }

}

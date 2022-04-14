package common.dto;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeleteAllJobs {

    private static final Logger LOGGER = LogManager.getLogger();

    public static Response getAllJobs() {
        return RestAssured.given()
            .baseUri("https://jobportalkarate.herokuapp.com/normal/webapi/all")
            .accept(ContentType.JSON)
            .when()
            .get()
            .then()
            .extract()
            .response();
    }

    public static void deleteJob(int id) {
        RestAssured.given()
            .baseUri("https://jobportalkarate.herokuapp.com/normal/webapi/remove/" + id)
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .when()
            .delete()
            .then()
            .statusCode(HttpStatus.SC_OK);
    }

    public static void deleteAllJobs(List<JobDto> jobs) {
        jobs.forEach(jobDto -> {
            if (jobDto.getJobId() != 1) {
                LOGGER.info("Deleting by JobId: id=[{}]", jobDto.getJobId());
                deleteJob(jobDto.getJobId());
            }
        });
    }

    public static void deleteAllJobs() {
        List<JobDto> jobs = Arrays.asList(getAllJobs().getBody().as(JobDto[].class));
        jobs.parallelStream()
            .forEach(jobDto -> {
                if (jobDto.getJobId() != 1) {
                    LOGGER.info("Deleting by JobId: id=[{}]", jobDto.getJobId());
                    System.out.println("Deleting job id: " + jobDto.getJobId()+ "\n" + jobDto.toString());
                    deleteJob(jobDto.getJobId());
                }
            });
    }

    public static void main(String[] args) {

//        List<JobDto> jobs = Arrays.asList(getAllJobs().getBody().as(JobDto[].class));
//        jobs.forEach(jobDto -> System.out.println(jobDto.getJobId()));

        deleteAllJobs();

    }

}

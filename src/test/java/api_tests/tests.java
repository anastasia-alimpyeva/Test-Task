package api_tests;

import dataProviders.dataProviders;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import readProperty.ReadProperties;

public class tests {
    private RequestSpecification requestSpecification;

@BeforeSuite
public void before() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(new ReadProperties().getDomain())
                .setBasePath(new ReadProperties().getPath())
                .build();
    }

    @Test(dataProvider = "titleAndUserIds",
            dataProviderClass = dataProviders.class)
    public void testWithQueryParameters(String title, int userId, int postsCount) {
        given(requestSpecification)
                .when()
                .queryParam("title", title)
                .get()
                .then()
                .statusCode(HTTP_OK)
                .and()
                .body("userId", Matchers.contains(userId));


        given(requestSpecification)
                .when()
                .queryParam("userId", String.valueOf(userId))
                .get()
                .then()
                .statusCode(HTTP_OK)
                .and()
                .body("body", hasSize(postsCount));
    }

    @Test(dataProvider = "idAndTitle",
            dataProviderClass = dataProviders.class)
    public void getResourceById(String id, String title) {
        given()
                .spec(requestSpecification)
                .param("id", id)
                .get()
                .then()
                .statusCode(HTTP_OK)
                .and()
                .body("title", Matchers.contains(title));
    }

    @Test
    public void getAllResources() {
        int sizeOfResponses = 100;
        given(requestSpecification)
                .get()
                .then()
                .statusCode(HTTP_OK)
                .and()
                .body("title", hasSize(sizeOfResponses))
                .and()
                .body("userId", hasSize(sizeOfResponses));
    }
}

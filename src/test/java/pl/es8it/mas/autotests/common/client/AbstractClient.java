package pl.es8it.mas.autotests.common.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class AbstractClient {

    private static final String PATH_HEALTH = "/actuator/health";

    private final String applicationName;
    private final RequestSpecification requestSpecification;

    protected AbstractClient(String applicationName, String baseUrl) {
        this.applicationName = applicationName;
        this.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setAccept(ContentType.JSON)
                .build();
    }

    public String getApplicationName() {
        return applicationName;
    }

    public boolean isReady() {
        return request()
                .get(PATH_HEALTH)
                .statusCode() == 200;
    }

    protected RequestSpecification request() {
        return given(requestSpecification);
    }
}

package pl.es8it.mas.autotests.common.context;

import io.restassured.response.Response;

public class ScenarioContext {

    private Response response;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        if (response == null) {
            throw new IllegalStateException("No request has been sent in this scenario");
        }
        return response;
    }
}

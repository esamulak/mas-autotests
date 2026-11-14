package pl.es8it.mas.autotests.diagnostics.client;

import io.restassured.response.Response;
import pl.es8it.mas.autotests.common.client.AbstractClient;

import static pl.es8it.mas.autotests.common.config.EnvironmentConfiguration.Variable.DIAGNOSTICS_SERVICE_URL;
import static pl.es8it.mas.autotests.common.config.EnvironmentConfiguration.getString;
import static pl.es8it.mas.contract.diagnostics.DiagnosticsApi.PATH_GET_IGNITION;

public class DiagnosticsClient extends AbstractClient {

    public DiagnosticsClient() {
        super("Diagnostics", getString(DIAGNOSTICS_SERVICE_URL));
    }

    public Response getIgnition() {
        return request().get(PATH_GET_IGNITION);
    }
}

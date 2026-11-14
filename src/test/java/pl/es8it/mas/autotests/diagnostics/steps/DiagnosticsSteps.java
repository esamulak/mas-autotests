package pl.es8it.mas.autotests.diagnostics.steps;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.es8it.mas.autotests.common.context.ScenarioContext;
import pl.es8it.mas.autotests.diagnostics.client.DiagnosticsClient;
import pl.es8it.mas.contract.diagnostics.dto.IgnitionDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.es8it.mas.autotests.common.mapper.JsonMapper.fromJson;

public class DiagnosticsSteps {

    private final DiagnosticsClient diagnosticsClient;
    private final ScenarioContext scenarioContext;

    public DiagnosticsSteps(DiagnosticsClient diagnosticsClient, ScenarioContext scenarioContext) {
        this.diagnosticsClient = diagnosticsClient;
        this.scenarioContext = scenarioContext;
    }

    @When("the ignition status is requested")
    public void theIgnitionStatusIsRequested() {
        scenarioContext.setResponse(diagnosticsClient.getIgnition());
    }

    @Then("the ignition details are returned")
    public void theIgnitionDetailsAreReturned(@Transpose IgnitionDTO expectedIgnition) {
        var response = scenarioContext.getResponse();

        assertThat(response.statusCode())
                .as("HTTP status, response body: %s", response.asString())
                .isEqualTo(200);
        assertThat(fromJson(response.asString(), IgnitionDTO.class))
                .isEqualTo(expectedIgnition);
    }
}

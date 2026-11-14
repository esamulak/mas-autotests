package pl.es8it.mas.autotests.diagnostics.steps;

import io.cucumber.java.en.Given;
import pl.es8it.mas.contract.vehicle.dto.IgnitionStatus;
import pl.es8it.mas.contract.vehicle.dto.VehicleIgnitionDTO;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.okJson;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static pl.es8it.mas.autotests.common.mapper.JsonMapper.toJson;
import static pl.es8it.mas.contract.vehicle.VehicleApi.PATH_FETCH_IGNITION_STATUS;

public class VehicleSteps {

    @Given("the vehicle reports the ignition {}")
    public void theVehicleReportsTheIgnition(IgnitionStatus status) {
        var jsonResponse = toJson(new VehicleIgnitionDTO(status));
        stubFor(get(PATH_FETCH_IGNITION_STATUS)
                .willReturn(okJson(jsonResponse)));
    }
}

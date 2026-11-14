package pl.es8it.mas.autotests.diagnostics.hooks;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

import static pl.es8it.mas.autotests.common.config.EnvironmentConfiguration.Variable.VEHICLE_SIMULATOR_HOST;
import static pl.es8it.mas.autotests.common.config.EnvironmentConfiguration.Variable.VEHICLE_SIMULATOR_PORT;
import static pl.es8it.mas.autotests.common.config.EnvironmentConfiguration.getInt;
import static pl.es8it.mas.autotests.common.config.EnvironmentConfiguration.getString;

public class VehicleSimulatorHooks {

    @BeforeAll
    public static void connectToVehicleSimulator() {
        WireMock.configureFor(
                getString(VEHICLE_SIMULATOR_HOST),
                getInt(VEHICLE_SIMULATOR_PORT)
        );
    }

    @Before
    public void resetVehicleSimulator() {
        WireMock.reset();
    }
}

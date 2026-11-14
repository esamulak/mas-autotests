package pl.es8it.mas.autotests.diagnostics.hooks;

import io.cucumber.java.BeforeAll;
import pl.es8it.mas.autotests.diagnostics.client.DiagnosticsClient;

import static pl.es8it.mas.autotests.common.hooks.Readiness.waitUntilReady;

public class DiagnosticsServiceHooks {

    @BeforeAll
    public static void waitForDiagnosticsService() {
        waitUntilReady(new DiagnosticsClient());
    }
}

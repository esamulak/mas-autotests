package pl.es8it.mas.autotests.common.hooks;

import pl.es8it.mas.autotests.common.client.AbstractClient;

import static org.awaitility.Awaitility.await;
import static pl.es8it.mas.autotests.common.config.TechnicalConfiguration.Property.SERVICES_READINESS_POLL_INTERVAL;
import static pl.es8it.mas.autotests.common.config.TechnicalConfiguration.Property.SERVICES_READINESS_TIMEOUT;
import static pl.es8it.mas.autotests.common.config.TechnicalConfiguration.getDurationInMillis;

public final class Readiness {

    private Readiness() {
    }

    public static void waitUntilReady(AbstractClient client) {
        await("%s is ready".formatted(client.getApplicationName()))
                .atMost(getDurationInMillis(SERVICES_READINESS_TIMEOUT))
                .pollInterval(getDurationInMillis(SERVICES_READINESS_POLL_INTERVAL))
                .ignoreExceptions()
                .until(client::isReady);
    }
}

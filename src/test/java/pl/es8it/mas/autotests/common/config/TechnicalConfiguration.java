package pl.es8it.mas.autotests.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.time.Duration;
import java.util.Properties;

public final class TechnicalConfiguration {

    private static final String CONFIGURATION_FILE = "requirements/technical/configuration.properties";
    private static final Properties PROPERTIES = load();

    private TechnicalConfiguration() {
    }

    public enum Property {
        ENDPOINTS_RESPONSE_TIMEOUT("endpoints.response-timeout"),
        ENDPOINTS_RESPONSE_ERROR_CODE_PATTERN("endpoints.response-error.error-code-pattern"),
        SERVICES_READINESS_TIMEOUT("services.readiness.timeout"),
        SERVICES_READINESS_POLL_INTERVAL("services.readiness.poll-interval");

        private final String name;

        Property(String name) {
            this.name = name;
        }
    }

    public static String getString(Property property) {
        String value = PROPERTIES.getProperty(property.name);
        if (value == null) {
            throw new IllegalStateException("Missing %s in %s".formatted(property.name, CONFIGURATION_FILE));
        }
        return value;
    }

    public static long getLong(Property property) {
        return Long.parseLong(getString(property));
    }

    public static Duration getDurationInMillis(Property property) {
        return Duration.ofMillis(getLong(property));
    }

    private static Properties load() {
        try (InputStream file = TechnicalConfiguration.class.getClassLoader().getResourceAsStream(CONFIGURATION_FILE)) {
            Properties properties = new Properties();
            properties.load(file);
            return properties;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

package pl.es8it.mas.autotests.common.config;

public final class EnvironmentConfiguration {

    public enum Variable {
        DIAGNOSTICS_SERVICE_URL,
        VEHICLE_SIMULATOR_HOST,
        VEHICLE_SIMULATOR_PORT
    }

    private EnvironmentConfiguration() {
    }

    public static String getString(Variable variable) {
        return System.getenv(variable.name());
    }

    public static int getInt(Variable variable) {
        return Integer.parseInt(getString(variable));
    }
}

package org.haycco.spring.api;

public abstract class ApiController {
    private static final String API_PATH = "/api/v1";

    public static final String AUTHENTICATE_URL = API_PATH + "/authenticate";
    public static final String STUFF_URL = API_PATH + "/stuff";

    // Spring Boot Actuator services
    public static final String HEALTH_ENDPOINT = "/actuator/health";
    public static final String INFO_ENDPOINT = "/actuator/info";
    public static final String DOCS_ENDPOINT = "/actuator/docs";
    public static final String CONDITIONS_ENDPOINT = "/actuator/conditions";
    public static final String BEANS_ENDPOINT = "/actuator/beans";
    public static final String CONFIGPROPS_ENDPOINT = "/actuator/configprops";
    public static final String ENV_ENDPOINT = "/actuator/env";
    public static final String MAPPINGS_ENDPOINT = "/actuator/mappings";
    public static final String METRICS_ENDPOINT = "/actuator/metrics";
    public static final String SHUTDOWN_ENDPOINT = "/actuator/shutdown";
}

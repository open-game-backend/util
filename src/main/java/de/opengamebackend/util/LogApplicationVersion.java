package de.opengamebackend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LogApplicationVersion {
    private static final String APPLICATION_NAME_PROPERTY = "spring.application.name";
    private static final String APPLICATION_VERSION_PROPERTY = "application.version";

    private Logger logger = LoggerFactory.getLogger(LogApplicationVersion.class);

    private Environment environment;

    public LogApplicationVersion(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void postConstruct() {
        String applicationName = this.environment.getProperty(APPLICATION_NAME_PROPERTY);
        String applicationVersion = this.environment.getProperty(APPLICATION_VERSION_PROPERTY);

        if (applicationName == null) {
            logger.warn(APPLICATION_NAME_PROPERTY + " not set.");
            return;
        }

        if (applicationVersion == null) {
            logger.warn(APPLICATION_VERSION_PROPERTY + " not set.");
            return;
        }

        logger.info(applicationName + " " + applicationVersion);
    }
}

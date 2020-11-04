package de.opengamebackend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LogApplicationVersion {
    private Logger logger = LoggerFactory.getLogger(LogApplicationVersion.class);

    private Environment environment;

    public LogApplicationVersion(Environment environment) {
        this.environment = environment;
    }

    @PostConstruct
    public void postConstruct() {
        String applicationName = this.environment.getProperty("spring.application.name");
        String applicationVersion = this.environment.getProperty("application.version");

        if (applicationName == null) {
            applicationVersion = "spring.application.name";
        }

        if (applicationVersion == null) {
            applicationVersion = "application.version";
        }

        logger.info(applicationName + " " + applicationVersion);
    }
}

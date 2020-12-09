package de.opengamebackend.util.logging;

import de.opengamebackend.util.config.ApplicationConfig;
import de.opengamebackend.util.config.SpringApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("!test")
public class LogApplicationVersion {
    private SpringApplicationConfig springApplicationConfig;
    private ApplicationConfig applicationConfig;

    private Logger logger = LoggerFactory.getLogger(LogApplicationVersion.class);

    @Autowired
    public LogApplicationVersion(SpringApplicationConfig springApplicationConfig, ApplicationConfig applicationConfig) {
        this.springApplicationConfig = springApplicationConfig;
        this.applicationConfig = applicationConfig;
    }

    @PostConstruct
    public void postConstruct() {
        logger.info(springApplicationConfig.getName() + " " + applicationConfig.getVersion());
    }
}

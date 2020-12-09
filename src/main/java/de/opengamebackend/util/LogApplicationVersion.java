package de.opengamebackend.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
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

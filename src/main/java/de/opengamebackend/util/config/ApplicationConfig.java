package de.opengamebackend.util.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ConstructorBinding
@ConfigurationProperties("de.opengamebackend.application")
@Validated
public class ApplicationConfig {
    @NotNull
    private String version;

    public ApplicationConfig(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}

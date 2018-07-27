package com.ap.archetypes.jboss_web_api.common.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

public final class AppConfiguration {

    private static final String           CONFIG_FILE = "${application.path.configuration}/app.properties";
    private static final AppConfiguration instance    = new AppConfiguration();
    private PropertiesConfiguration       properties  = null;

    public String HELLO_MESSAGE;

    private AppConfiguration() {
        try {
            properties = new PropertiesConfiguration(CONFIG_FILE);
            properties.setReloadingStrategy(new FileChangedReloadingStrategy());

            HELLO_MESSAGE = properties.getString("hello.message");

        } catch (ConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    public static AppConfiguration getInstance() {
        return instance;
    }

}

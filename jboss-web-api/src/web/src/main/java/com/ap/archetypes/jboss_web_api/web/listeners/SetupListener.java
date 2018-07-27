package com.ap.archetypes.jboss_web_api.web.listeners;

import com.ap.archetypes.jboss_web_api.common.logging.LoggerHelper;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SetupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LoggerHelper.initialize();
        LoggerHelper.getInstance().info("Application started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LoggerHelper.getInstance().info("Application terminated.");
    }

}

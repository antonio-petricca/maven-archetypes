package com.ap.archetypes.jboss_web_api.common.logging;

import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// https://logging.apache.org/log4j/2.0/faq.html
// https://logging.apache.org/log4j/2.x/manual/async.html
// https://logging.apache.org/log4j/2.x/manual/async.html#Location
// https://logging.apache.org/log4j/2.x/manual/configuration.html
// https://logging.apache.org/log4j/2.x/manual/migration.html
// https://logging.apache.org/log4j/2.x/maven-artifacts.html

public final class LoggerHelper {

    private static Logger instance;

    static {
        System.setProperty("org.apache.logging.log4j.simplelog.StatusLogger.level", "TRACE");
        System.setProperty("log4j2.contextSelector", "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");

        // https://stackoverflow.com/a/28598222/418599
        System.setProperty("log4j2.debug", "true");

        // Avoid XML parsing errors when "oracle.xml.jaxp.JXDocumentBuilderFactory" is present.
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
    }

    private LoggerHelper() {
        // Hidden constructor
    }

    public static void initialize() {
        String fileName       = "${application.path.configuration}/log4j.xml";
        File file             = new File(fileName);
        
        org.apache.logging.log4j.LogManager.getContext(null, false, file.toURI());
        instance = LoggerFactory.getLogger(LoggerHelper.class);

        String logMessage = String.format("Log4J initialized (%s).", fileName);
        System.out.println(logMessage);
    }

    public static Logger getInstance() {
        return instance;
    }

}

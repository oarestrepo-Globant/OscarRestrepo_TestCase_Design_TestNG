package org.espn.reporting;

import org.slf4j.LoggerFactory;

public class Logger {
    public Logger(){}

    private static org.slf4j.Logger getLogger(){return LoggerFactory.getLogger(Logger.class);
    }

    public static void info(String text){
        getLogger().info(text);
    }

    public static void error(String text){
        getLogger().error(text);
    }

    public static void warning(String text){
        getLogger().warn(text);
    }
}

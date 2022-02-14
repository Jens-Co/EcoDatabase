package dev.projectg.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class JavaUtilLogger implements EcoDatabaseLogger {
    private final Logger logger;
    private Level originLevel;

    public JavaUtilLogger(Logger logger) {
        this.logger = logger;
        EcoDatabaseLogger.setLogger(this);
    }

    @Override
    public void error(String message) {
        logger.severe(message);
    }

    @Override
    public void warn(String message) {
        logger.warning(message);
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void debug(String message) {
        logger.fine(message);
    }

    @Override
    public void trace(String message) {
        logger.finer(message);
    }

    @Override
    public void enableDebug() {
        originLevel = logger.getLevel();
        logger.setLevel(Level.ALL);
        info("Debug logging enabled");
    }

    @Override
    public void disableDebug() {
        if (originLevel != null) {
            logger.setLevel(originLevel);
            info("Debug logging disabled");
        }
    }

    @Override
    public boolean isDebug() {
        return logger.getLevel() == Level.ALL;
    }
}
package fr.lernejo.logger;

public interface Logger {
    void log(String message);

    class LoggerFactory {
        public static Logger getLogger(String name) {
            return new ConsoleLogger();
        }
    }
}

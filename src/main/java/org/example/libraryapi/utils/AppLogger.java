package org.example.libraryapi.utils;

public class AppLogger {

    private static AppLogger instance;

    private AppLogger() {}

    public static synchronized AppLogger getInstance() {
        if (instance == null) {
            instance = new AppLogger();
        }
        return instance;
    }

    public void info(String msg) {
        System.out.println("[INFO] " + msg);
    }
}

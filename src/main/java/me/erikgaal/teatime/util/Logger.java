package me.erikgaal.teatime.util;

import java.io.PrintStream;

public class Logger {

    static PrintStream out = System.out;

    public static void debug(String message) {
        println("[INFO] " + message);
    }

    public static void info(String message) {
        println("[INFO] " + message);
    }

    public static void warning(String message) {
        println("[WARNING] " + message);
    }

    public static void error(String message) {
        println("[ERROR] " + message);
    }

    public static void fatal(String message) {
        println("[FATAL] " + message);
    }

    public static void println(String message) {
        out.println(message);
    }
}

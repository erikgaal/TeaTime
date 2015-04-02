package me.erikgaal.teatime.client;

import me.erikgaal.teatime.util.Logger;

import java.io.IOException;

public class TeaTimeGame implements Runnable {

    public static final String USAGE_STRING = "usage: java server.TeaTimeGame [OPTIONS]\n" +
            "\t-h HOST, --host HOST\tremote hostname or address\n" +
            "\t-p PORT, --port PORT\tremote port number\n" +
            "\t-?, --help\t\t\t\tshow this message\n";

    public static final String DEFAULT_HOST = "xenon.student.utwente.nl";
    public static final int DEFAULT_PORT = 8844;

    private String serverHost;
    private int serverPort;

    private boolean running = true;

    public TeaTimeGame(String serverHost, int serverPort) {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
    }

    public void run() {
        init();
        // TODO: implement
    }

    private void init() {
        // TODO: implement
    }

    public static void main(String[] args) {
        String host = DEFAULT_HOST;
        int port = DEFAULT_PORT;

        try {
            for (int i = 0; i < args.length; i++) {
                String key = args[i];
                String value = i == args.length - 1 ? null : args[i + 1];

                if (key.startsWith("--")) {
                    switch (key) {
                        case "--help":
                            Logger.println(USAGE_STRING);
                            System.exit(0);
                            break;
                        case "-h":
                        case "--host":
                            if (value != null && !value.startsWith("--")) {
                                host = value;
                                ++i;
                            } else {
                                throw new IllegalArgumentException("Option " + key + " requires an argument");
                            }
                            break;
                        case "-p":
                        case "--port":
                            if (value != null && !value.startsWith("--")) {
                                try {
                                    port = Integer.parseInt(value);
                                } catch (NumberFormatException e) {
                                    throw new IllegalArgumentException("Invalid argument " + value + " for option " + key);
                                }
                                ++i;
                            } else {
                                throw new IllegalArgumentException("Option " + key + " requires an argument");
                            }
                            break;
                        default:
                            if (value != null && !value.startsWith("--")) {
                                ++i;
                            }
                            throw new IllegalArgumentException("Unknown option " + key);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            Logger.error(e.getMessage());
            Logger.println(USAGE_STRING);
            System.exit(1);
        }

        final TeaTimeGame client = new TeaTimeGame(host, port);
        client.run();
    }
}

package me.erikgaal.teatime.server;

import me.erikgaal.teatime.util.Logger;

public class TeaTimeServer implements Runnable {

    public static final String USAGE_STRING = "Usage: java server.TeaTimeServer [OPTIONS]\n" +
            "\t--port\t\tlocal port number\n" +
            "";

    private int serverPort;

    private Thread serverThread;

    public TeaTimeServer() {
        // TODO: needs implemention
    }

    public void run() {
        // TODO: needs implemention
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int port) {
        serverPort = port;
    }

    public void startServerThread() {
        serverThread = new Thread(this);
        serverThread.start();
    }

    public static void main(String[] args) {
        int port = -1;

        try {
            for (int i = 0; i < args.length; i++) {
                String key = args[i];
                String value = i == args.length - 1 ? null : args[i + 1];

                if (key.startsWith("--")) {
                    switch (key) {
                        case "--help":
                            Logger.println(USAGE_STRING);
                            System.exit(0);
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

        final TeaTimeServer server = new TeaTimeServer();

        if (port > 0) {
            server.setServerPort(port);
        }

        server.startServerThread();
    }
}

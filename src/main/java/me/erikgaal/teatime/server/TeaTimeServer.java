package me.erikgaal.teatime.server;

import me.erikgaal.teatime.util.Logger;

public class TeaTimeServer implements Runnable {

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

                if (key.equals("--help")) {
                    Logger.println("Usage: java teatime.server.TeaTimeServer [OPTION]...\n" +
                            "\t--port\t\tlocal port number");
                } else if (key.equals("--port") && value != null) {
                    try {
                        port = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid value " + value + " for key " + key);
                    }
                } else {
                    throw new IllegalArgumentException(key);
                }
            }
        } catch (IllegalArgumentException e) {
            Logger.error("Unknown option: " + e.getMessage());
            Logger.println("Usage: java teatime.server.TeaTimeServer [OPTION]...\n" +
                    "\t--port\t\tlocal port number");
            System.exit(1);
        }

        final TeaTimeServer server = new TeaTimeServer();

        if (port > 0) {
            server.setServerPort(port);
        }

        server.startServerThread();
    }
}

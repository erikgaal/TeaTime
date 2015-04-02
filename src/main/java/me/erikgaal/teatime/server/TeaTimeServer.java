package me.erikgaal.teatime.server;

import me.erikgaal.teatime.util.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class TeaTimeServer implements Runnable {

    public static final String USAGE_STRING = "usage: java server.TeaTimeServer [OPTIONS]\n" +
            "\t-p PORT, --port PORT\tlocal port number\n" +
            "\t-?, --help\t\t\t\tshow this message\n";

    public static final int DEFAULT_PORT = 8844;

    private int serverPort;

    private boolean running = true;

    private ServerSocket server;
    private Set<ClientHandler> clients;

    public TeaTimeServer(int serverPort) {
        this.serverPort = serverPort;
        this.clients = new HashSet<>();
    }

    public void run() {
        init();

        while (running) {
            try {
                Logger.debug("Waiting for a client...");
                Socket socket = server.accept();
                Logger.debug("Client connected!");
                clients.add(new ClientHandler(socket));
            } catch (IOException e) {
                e.printStackTrace();
                // TODO: exception handling
            }
        }
    }

    private void init() {
        try {
            server = new ServerSocket(serverPort);
            Logger.info(String.format("Starting server on port %s", serverPort));
        } catch (IOException e) {
            Logger.fatal(String.format("Unable to start server on port %s", serverPort));
            Logger.fatal(e.getMessage());
            System.exit(1);
        }
    }

    public int getServerPort() {
        return serverPort;
    }

    public static void main(String[] args) {
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

        final TeaTimeServer server = new TeaTimeServer(port);
        server.run();
    }
}

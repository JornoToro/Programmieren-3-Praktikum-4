package aufgabe2_kingsLakeServer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * MultiThreadedKingslakeServer
 */
public class MultiThreadedKingslakeServer {
    private static final int PORT = 57777;
    public static void main(String... args) throws IOException
    {
        try (ServerSocket server = new ServerSocket(PORT)) {
            boolean acceptRequests = true;
            while (acceptRequests)
            {
                Socket socket = server.accept();
                new RequestProcessorSocket(socket).start();
            }	
        }

    }
}
package aufgabe2_kingsLakeServer.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * KingslakeClient
 */
public class KingslakeClient {
    private static final int PORT = 57777;

    public static void main(String[] args) {
        try {
            Socket clientSocked = new Socket("localhost", PORT);

            PrintWriter to = new PrintWriter(new OutputStreamWriter(clientSocked.getOutputStream()));
            to.println("hi");
            to.flush();

            BufferedReader from = new BufferedReader(new InputStreamReader(clientSocked.getInputStream()));

            for(String line = from.readLine(); line != null; line = from.readLine()){
                System.out.println(line);
            }


        } catch (IOException e) {
            System.out.println("cannot create socket: " + e);
        }
    }
}
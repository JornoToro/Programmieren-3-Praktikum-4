package aufgabe3_colorPage.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author G. Schiedermeier, gschied@haw-landshut.de
 * @version 2019-12-19
 */
public class HTTPRequest{
    private static final int PORT = 57777;
    
    public static void main(String... args) throws IOException
    {
      
        try (Socket socket = new Socket("localhost", PORT);
             InputStream input = socket.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(input);
             BufferedReader reader = new BufferedReader(inputStreamReader);
             OutputStream output = socket.getOutputStream();
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(output);
             PrintWriter writer = new PrintWriter(outputStreamWriter))
        {
            // Request header senden
            writer.printf("GET /colorpage/255/128/0 HTTP/1.1%n");
            // obligatorische Leerzeile
            writer.println();
            writer.flush();

            // Response Header empfangen und anzeigen
            for (String line = reader.readLine(); !line.isEmpty(); line = reader.readLine())
                System.out.println(line);
            // Response Body empfangen und anzeigen
            for (String line = reader.readLine(); !line.isEmpty(); line = reader.readLine())
                System.out.println(line);

        }
    }
}

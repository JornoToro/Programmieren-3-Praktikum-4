package aufgabe3_colorPage.server;
/**
 * @author G. Schiedermeier, gschied@haw-landshut.de
 * @version 2019-12-19
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
public class NanoWebserver{
    private static final int PORT = 8080;
    /**
     * !BROWSER:
     * http://localhost:8080/colorpage/255/128/0
     */
    public static void main(String... args) throws IOException
    {
        System.out.println("Server started");
        ServerSocket server = new ServerSocket(PORT);
        boolean acceptRequests = true;
        while (acceptRequests)
        {
            try (Socket socket = server.accept();
                 InputStream inputStream = socket.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader from = new BufferedReader(inputStreamReader);
                 OutputStream outputStream = socket.getOutputStream();
                 OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                 PrintWriter writer = new PrintWriter(outputStreamWriter))
            {
                String filename = null;
                for (String line = from.readLine(); !line.isEmpty(); line = from.readLine())
                {
                    if (line.startsWith("GET"))
                    {
                        filename = line.split("\\s+")[1];
                    }
                }
                filename = filename.substring(1);
                System.out.println(filename);
                String[] stringArray = filename.split("/");

                System.out.println(Arrays.toString(stringArray));
                try
                {

                    //InputStream file = new FileInputStream(filename);
                    //byte[] content = new byte[file.available()];
                    //int length = file.read(content);
                    writer.println("HTTP/1.0 200 OK");
                    writer.println("");
                    writer.println("<html><body bgcolor= #" + stringArray[1] + stringArray[2] + stringArray[3] + "></body></html>");
                    writer.flush();
                } catch (Exception ex)
                {
                    writer.println("HTTP/1.0 404 Not Found");
                    writer.println("");
                    writer.println(ex.getMessage());
                }
                writer.flush();
            }
        }
        server.close();
    }

}


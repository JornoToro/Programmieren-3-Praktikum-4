package aufgabe2_kingsLakeServer.server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author G. Schiedermeier, gschied@haw-landshut.de
 * @version 2019-12-19
 */
public class RequestProcessorSocket extends Thread {
    private final Socket socket;

    public RequestProcessorSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader from = new BufferedReader(inputStreamReader);

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                PrintWriter to = new PrintWriter(outputStreamWriter)) {
            String inputWord = from.readLine();
            int wordLength = inputWord.length();

            while (wordLength > 0) {
                to.println("*" + inputWord + "*");
                wordLength--;
            }
            to.print("\0");
            to.flush();

        } catch (IOException ex) {
            throw new RuntimeException(ex);

        }

    }

}

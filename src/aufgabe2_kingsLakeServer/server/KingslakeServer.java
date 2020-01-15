package aufgabe2_kingsLakeServer.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * KingslakeServer
 */
public class KingslakeServer {
    private static final int PORT = 57777;


    public static void main(String[] args) throws IOException {
      try {
        Socket serverSocket = new ServerSocket(PORT).accept();
        BufferedReader from = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));

        String inputWord = from.readLine();
        int wordLength = inputWord.length();

        PrintWriter to = new PrintWriter(new OutputStreamWriter(serverSocket.getOutputStream()));
        
        while (wordLength > 0) {
            to.println("*" + inputWord + "*");
            wordLength--;
        }
        to.print("\0");
        to.flush();

      } catch (Exception e) {
          System.out.println("Cannot create Serversocket: " + e);
      }
    }

       
    
}
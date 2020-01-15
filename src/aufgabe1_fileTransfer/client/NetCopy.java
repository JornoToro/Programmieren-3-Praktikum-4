package aufgabe1_fileTransfer.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Uebertraegt ein File zwischen zwei Hosts. Arbeitet als Sender oder
 * Empfaenger, je nach Kommandozeilenargument: Wenn das einzige
 * Kommandozeilenargument ein regulaeres File ist, startet das Programm als
 * Server und sendet das File an den ersten Client. Andernfalls ist das
 * Kommandozeilenargument ein Hostname und das Programm holt sich ein File von
 * diesem. Der Sender schickt und der Empfaenger liest nacheinander: Filename
 * (ohne Pfad), 0-Byte, Inhalt des Files.
 */
public class NetCopy {
    /**
     * Port.
     */
    private static final int PORT = 5000;

    /**
     * Hauptprogramm. Sendet oder empfaengt ein File.
     *
     * @param args Kommandozeilenargument: Lokaler Pfadname (Sender) oder Hostname
     *             (Empfaenger).
     * @throws IOException wenn beim Zugriff aufs Filesystem oder aufs Netzwerk
     *                     etwas schief geht.
     */
    public static void main(String... args) throws IOException {
        if (!send(args[0]))
            receive(args[0]);
    }

    /**
     * Holt ein File vom Server.
     * 
     * @param hostname Hostname des Servers, der ein File liefert.
     * @throws IOException wenn beim Empfangen oder Schreiben des Files etwas schief
     *                     geht.
     */
    public static void receive(String hostname) throws IOException {
        // TODO - Client der File erhält

        Socket clientSocket = new Socket(hostname, PORT);
        BufferedReader from = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //System.out.println(from.readLine());
        PrintWriter writer = new PrintWriter("response.txt", "UTF-8");
        writer.println(from.readLine());
        writer.close();


    }

    /**
     * Schickt ein File zum Client.
     *
     * @param filename Pfadname eines lokalen Files.
     * @return true, wenn filename versendet wurde; false ansonsten.
     * @throws IOException wenn filename existiert, aber beim Lesen oder Senden
     *                     etwas schief ging.
     */
    public static boolean send(String filename) throws IOException {
        // TODO - Server der File sendet
        try {
            Socket serverSocket = new ServerSocket(PORT).accept();
            PrintWriter to = new PrintWriter(new OutputStreamWriter(serverSocket.getOutputStream()));

            try {
                String fname = "src/aufgabe1_fileTransfer/server/"+filename;
                File file = new File(fname);
                Scanner sc = new Scanner(file);

                while (sc.hasNext()) {
                    to.write(sc.nextLine());
                    to.flush();
                }

                return true;

            } catch (Exception e) {
                System.out.println("Cannot Read file:" + e);
            }

        } catch (Exception e) {
            System.out.println("Cannot create Server Socket" + e);
        }

        return false;
    }
}

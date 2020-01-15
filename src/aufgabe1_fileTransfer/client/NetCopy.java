package aufgabe1_fileTransfer.client;
import java.io.IOException;

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
     * Hauptprogramm.
     * Sendet oder empfaengt ein File.
     *
     * @param args Kommandozeilenargument: Lokaler Pfadname (Sender) oder Hostname (Empfaenger).
     * @throws IOException          wenn beim Zugriff aufs Filesystem oder aufs Netzwerk etwas schief geht.
     */
    public static void main(String... args) throws IOException {
        if(!send(args[0]))
            receive(args[0]);
    }

    /**
     * Holt ein File vom Server.
     * @param hostname Hostname des Servers, der ein File liefert.
     * @throws IOException wenn beim Empfangen oder Schreiben des Files etwas schief geht.
     */
    public static void receive(String hostname) throws IOException {
        //TODO
    }

    /**
     * Schickt ein File zum Client.
     *
     * @param filename Pfadname eines lokalen Files.
     * @return true, wenn filename versendet wurde; false ansonsten.
     * @throws IOException wenn filename existiert, aber beim Lesen oder Senden etwas schief ging.
     */
    public static boolean send(String filename) throws IOException {
        //TODO


        return true;
    }
}

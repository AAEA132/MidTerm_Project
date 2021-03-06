
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * The type Write client stuff for server to be printed.
 */
public class WriteClientStuffForServerToBePrinted extends Thread{
    private final DataOutputStream dataOutputStream;
    private final Client client;


    /**
     * Instantiates a new Write client stuff for server to be printed.
     *
     * @param dataOutputStream the data output stream
     * @param client           the client
     */
    public WriteClientStuffForServerToBePrinted(DataOutputStream dataOutputStream, Client client) {
        this.dataOutputStream = dataOutputStream;
        this.client = client;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        while ( !line.equals("EXIT")){
            line = scanner.nextLine();
            scanner = new Scanner(System.in);
            try {
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

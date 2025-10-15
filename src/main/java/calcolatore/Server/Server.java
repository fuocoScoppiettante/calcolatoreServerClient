package calcolatore.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(3000);
        do {

            Socket s = ss.accept();
            GestioneClient gs = new GestioneClient(s);
            gs.start();

        } while (true);
    }
}
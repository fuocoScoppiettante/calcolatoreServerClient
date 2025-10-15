package calcolatore.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GestioneClient extends Thread {
    Socket s;

    public GestioneClient(Socket socket) {
        this.s = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            do {

                Integer primoNum = Integer.parseInt(in.readLine());

                if (primoNum.equals("!")) {
                    break;
                }

                Integer secondoNum = Integer.parseInt(in.readLine());
                String operatore = in.readLine();

                if (secondoNum.equals("0") && operatore.equals("4")) {
                    out.println("Error!");
                    break;
                }

                if (operatore.equals("1")) {
                    int somma = primoNum + secondoNum;
                    out.println(somma);
                } else if (operatore.equals("2")) {
                    int sottrazione = primoNum - secondoNum;
                    out.println(sottrazione);
                } else if (operatore.equals("3")) {
                    int moltiplicazione = primoNum * secondoNum;
                    out.println(moltiplicazione);
                } else if (operatore.equals("4")) {
                    int divisione = primoNum / secondoNum;
                    out.println(divisione);
                }

            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

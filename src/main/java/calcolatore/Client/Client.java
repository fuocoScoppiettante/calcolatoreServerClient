package calcolatore.Client;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket s = new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        Scanner tastiera = new Scanner(System.in);

        do {

            System.out.println("Inserire il primo numero o ! per uscire: ");
            String primoNum = tastiera.nextLine();
            out.println(primoNum);

            if (primoNum.equals("!")) {
                out.println("!");
                break;
            }

            System.out.println("Inserire il secondo numero o ! per uscire: ");
            String secondoNum = tastiera.nextLine();
            out.println(secondoNum);

            System.out.println("Inserire l'operatore: (1 => somma, 2 => sottrazione, 3 => moltiplicazione, 4 => divisione, ! => esci)");
            String operatore = tastiera.nextLine();
            out.println(operatore);

            String stringClient = in.readLine();
            System.out.println("Risultato => " + stringClient);

        } while (true);
    }
}

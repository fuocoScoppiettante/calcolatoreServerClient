package calcolatore.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket mioServerSocket = new ServerSocket(3000);
        Socket mioSocket = mioServerSocket.accept();

        System.out.println("Qualcuno si è collegato!!");

        BufferedReader in = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        PrintWriter out = new PrintWriter(mioSocket.getOutputStream(), true);



        do{


            String primoNum = in.readLine();

            if(primoNum.equals("!")){break;}

            String secondoNum = in.readLine();
            String operatore = in.readLine();

            if(secondoNum.equals("0") && operatore.equals(4)){
                out.println("Error!");
                break;
            }

            if(operatore.equals(1))
            {
                int somma = Integer.parseInt(primoNum) + Integer.parseInt(secondoNum);
                out.println(somma);
            }
            else if(operatore.equals(2))
                {
                int sottrazione = Integer.parseInt(primoNum) - Integer.parseInt(secondoNum);
                out.println(sottrazione);
                }
                else if(operatore.equals(3))
                    {
                    int moltiplicazione = Integer.parseInt(primoNum) * Integer.parseInt(secondoNum);
                    out.println(moltiplicazione);
                    }
                    else if(operatore.equals(4))
                        {
                        int divisione = Integer.parseInt(primoNum) / Integer.parseInt(secondoNum);
                        out.println(divisione);
                        }


        }while(true);

    }
}
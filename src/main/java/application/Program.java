package application;

import model.entites.Contract;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato");
        System.out.print("Numero: ");
        int contractId = sc.nextInt();

        System.out.print("Data (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());

        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        System.out.print("Entre com o numero de parcelas: ");
        int installments = sc.nextInt();

        Contract contract = new Contract(contractId, date, contractValue);

        System.out.println("Parcelas (Data - valor): ");


        sc.close();
    }
}

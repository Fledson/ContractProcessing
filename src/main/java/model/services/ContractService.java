package model.services;

import model.entites.Contract;
import model.entites.Installment;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ContractService {


    public void processContract(Contract contract, Integer months){
        // definindo um calaendario
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(contract.getDate());



        // para cada mes, calcular a data da parcela e o valor
        for (int parcela = 1; parcela <= months; parcela ++) {
            // Incrementando um mês na data do contrato
            calendar.add(Calendar.MONTH, 1);

            // valor
            double valueInstallment = contract.getTotalValue() / months;

            // instanciando
            contract.getInstallments().add(new Installment(calendar.getTime(), valueInstallment));
        }
    }

}

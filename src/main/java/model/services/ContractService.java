package model.services;

import model.entites.Contract;
import model.entites.Installment;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ContractService {


    public void processContract(Contract contract, Integer months, OnlinePaymentService paymentService){
        // definindo um calaendario
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(contract.getDate());



        // para cada mes, calcular a data da parcela e o valor
        for (int installment = 1; installment <= months; installment ++) {
            // Incrementando um mês na data do contrato
            calendar.add(Calendar.MONTH, 1);

            // calculando valor da parcela
            double valueInstallment = contract.getTotalValue() / months;
            // calculando o valor do juros simples da parcela e somando a ela
            double valueWithSimpleInterest = valueInstallment + paymentService.interest(valueInstallment, installment);
            // calculando o valor da taxa de pagamento em cima do valor da parcela com o juros simples e somando
            double amountWithPaymentFee = valueWithSimpleInterest + paymentService.paymentFee(valueWithSimpleInterest);
            // instanciando e adicionando as parcelas a lista de parcelas
            contract.getInstallments().add(new Installment(calendar.getTime(), amountWithPaymentFee));
        }
    }

}

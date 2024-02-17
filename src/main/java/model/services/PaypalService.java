package model.services;

public class PaypalService implements OnlinePaymentService{
    private double monthlyInterest = 0.01;
    private double paymentFee = 0.02;

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * monthlyInterest * months;
    }

    @Override
    public Double paymentFee(Double amount) {
        return  amount * paymentFee;
    }
}

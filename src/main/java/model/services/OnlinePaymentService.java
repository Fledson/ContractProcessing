package model.services;

public interface OnlinePaymentService {
    double monthlyInterest = 0;
    double paymentFee = 0;

    Double interest(Double amount, Integer months);
    Double paymentFee(Double amount);
}

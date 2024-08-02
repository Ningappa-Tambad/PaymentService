package com.springacademy.paymentservice.services;

import com.razorpay.RazorpayException;

public interface PaymentService
{
    public String generatePayment(Long orderId) throws RazorpayException;
}

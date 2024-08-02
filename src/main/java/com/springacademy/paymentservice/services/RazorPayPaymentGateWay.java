package com.springacademy.paymentservice.services;


import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorPayPaymentGateWay implements PaymentService
{


    private RazorpayClient razorpPayClient;

    public RazorPayPaymentGateWay(RazorpayClient razorPayClient)
    {
        this.razorpPayClient = razorPayClient;
    }

    @Override
    public String generatePayment(Long orderId) throws RazorpayException {

        //Make a call to razorpay client to generate payment link



        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",true);
        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",1691097057);
        paymentLinkRequest.put("reference_id","TS1989");
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","+919999999999");
        customer.put("contact","Gaurav Kumar");
        customer.put("email","gaurav.kumar@example.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpPayClient.paymentLink.create(paymentLinkRequest);



        return payment.toString();
    }
}
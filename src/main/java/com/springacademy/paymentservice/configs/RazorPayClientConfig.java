package com.springacademy.paymentservice.configs;


import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorPayClientConfig
{

    @Value("${razorpay.key.id}")
    private String razorPayKeyid;


    @Value("${razorpay.key.secret}")
    private String razorPaySecret;


    @Bean
    public RazorpayClient createRazorPayClient() throws RazorpayException
    {
        return new RazorpayClient(razorPayKeyid, razorPaySecret);
    }
}

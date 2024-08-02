package com.springacademy.paymentservice.controllers;


import com.springacademy.paymentservice.dtos.GeneratePaymentLinkRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController
{

   @PostMapping
   public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDto requestDto)
   {
      return "Generated link";
   }
}

package com.example.currencyexchange.controller;


import com.example.currencyexchange.modle.CurrencyExchange;
import com.example.currencyexchange.repo.CurrencyExchangeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @Autowired
    private Environment environment;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){

         String port = environment.getProperty("local.server.port");
         CurrencyExchange currencyExchange = this.currencyExchangeRepo.findByFromAndTo(from,to);
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}

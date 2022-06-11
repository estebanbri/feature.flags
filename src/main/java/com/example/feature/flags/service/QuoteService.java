package com.example.feature.flags.service;

import com.example.feature.flags.service.feature.OffnetService;
import com.example.feature.flags.service.feature.QuoteXpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    @Autowired
    private QuoteXpressService quoteXpressService;

    @Autowired
    private OffnetService offnetService;

    public void runQuote() {
        System.out.println("Inicio runQuote");
        quoteXpressService.callXpress();
        offnetService.callOffnet();
        System.out.println("Fin runQuote");
    }

}

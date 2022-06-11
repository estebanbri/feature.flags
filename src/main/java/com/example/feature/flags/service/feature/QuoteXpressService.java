package com.example.feature.flags.service.feature;

import com.example.feature.flags.annotation.FeatureFlag;
import org.springframework.stereotype.Service;

@Service
public class QuoteXpressService {

    @FeatureFlag("XPRESS")
    public void callXpress() {
        System.out.println("Ejecutando logica cuando salga este feature de Xpress");
    }

}

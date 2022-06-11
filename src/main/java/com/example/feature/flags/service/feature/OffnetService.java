package com.example.feature.flags.service.feature;

import com.example.feature.flags.annotation.FeatureFlag;
import org.springframework.stereotype.Service;

@Service
public class OffnetService {

    @FeatureFlag("OFFNETQUOTING")
    public void callOffnet() {
        System.out.println("Ejecutando logica cuando salga este feature de Offnet");
    }

}

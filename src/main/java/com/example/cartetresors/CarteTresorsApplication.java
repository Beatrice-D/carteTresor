package com.example.cartetresors;

import com.example.cartetresors.model.*;
import com.example.cartetresors.service.EcrireFichierService;
import com.example.cartetresors.service.LireFichierService;
import com.example.cartetresors.service.SimulationMouvementsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;


@SpringBootApplication
public class CarteTresorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarteTresorsApplication.class, args);
        try {
            // Appel de la méthode lireFichier de la classe LireFichierService
            StructureGlobal structureGlobal = LireFichierService.lireFichier("file.txt");
            // Appel de la méthode simulationMouvements de la classe SimulationMouvementsService
            structureGlobal = SimulationMouvementsService.simulationMouvements(structureGlobal);
            // Appel de la méthode ecrireFichier de la classe EcrireFichierService
            EcrireFichierService.ecrireFichier(structureGlobal, "resultFile.txt");
            System.out.print(structureGlobal.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

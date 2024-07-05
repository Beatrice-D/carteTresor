package com.example.cartetresors.service;

import com.example.cartetresors.model.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class EcrireFichierServiceTest {

    StructureGlobal structureGlobal;

    @Before
    public void setup(){
        Aventurier aventurier1 = AventurierBuilder.anAventurier()
                .withNom("Toto")
                .withOrdreApparition(0L)
                .withOrientation("E")
                .withAxeHorizontal(2L)
                .withAxeVertical(2L)
                .withNombreTresorsRamasses(1L)
                .build();
        Aventurier aventurier2 = AventurierBuilder.anAventurier()
                .withNom("Titi")
                .withOrdreApparition(1L)
                .withOrientation("S")
                .withAxeHorizontal(3L)
                .withAxeVertical(2L)
                .withNombreTresorsRamasses(0L)
                .build();
        List<Aventurier> aventurierList = Arrays.asList(aventurier1, aventurier2);
        structureGlobal = StructureGlobalBuilder.aStructureGlobal()
                .withCarte(CarteBuilder.aCarte()
                        .withNombreCaseLargeur(4L)
                        .withNombreCaseHauteur(4L)
                        .build())
                .withListMontagne(Arrays.asList(MontagneBuilder.aMontagne()
                        .withAxeHorizontal(3L)
                        .withAxeVertical(3L)
                        .build()))
                .withListTresor(Arrays.asList(TresorBuilder.aTresor()
                        .withAxeHorizontal(1L)
                        .withAxeVertical(2L)
                        .withNombreTresors(2L)
                        .build()))
                .withListAventuriers(aventurierList)
                .build();
    }

    @org.junit.Test
    public void testEcrireFichier() throws IOException {
        EcrireFichierService.ecrireFichier(structureGlobal, "resultFileTest.txt");
    }
}

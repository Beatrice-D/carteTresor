package com.example.cartetresors.service;

import com.example.cartetresors.model.*;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class LireFichierServiceTest {
    StructureGlobal structureGlobalExpected;

    @Before
    public void setup() {
        Aventurier aventurier1 = AventurierBuilder.anAventurier()
                .withNom("Toto")
                .withOrdreApparition(0L)
                .withOrientation("S")
                .withAxeHorizontal(0L)
                .withAxeVertical(0L)
                .withMouvements("AAGAA")
                .withNombreTresorsRamasses(0L)
                .build();
        Aventurier aventurier2 = AventurierBuilder.anAventurier()
                .withNom("Titi")
                .withOrdreApparition(1L)
                .withOrientation("S")
                .withAxeHorizontal(3L)
                .withAxeVertical(0L)
                .withMouvements("AAA")
                .withNombreTresorsRamasses(0L)
                .build();
        List<Aventurier> aventurierList = Arrays.asList(aventurier1, aventurier2);
        structureGlobalExpected = StructureGlobalBuilder.aStructureGlobal()
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
                        .withNombreTresors(3L)
                        .build()))
                .withListAventuriers(aventurierList)
                .build();
    }

    @org.junit.Test
    public void testLireFichier() throws FileNotFoundException {
        StructureGlobal structureGlobalResult = LireFichierService.lireFichier("testFile.txt");
        assertNotNull(structureGlobalResult);
        assertEquals(structureGlobalResult, structureGlobalExpected);
    }
}

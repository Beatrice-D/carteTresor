package com.example.cartetresors.service;

import com.example.cartetresors.model.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SimulationMouvementsServiceTest {
    StructureGlobal structureGlobalInitial;
    StructureGlobal structureGlobalResultExpected;

    @Before
    public void setup(){
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
        structureGlobalInitial = StructureGlobalBuilder.aStructureGlobal()
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
        Aventurier aventurierRes1 = AventurierBuilder.anAventurier()
                .withNom("Toto")
                .withOrdreApparition(0L)
                .withOrientation("E")
                .withAxeHorizontal(2L)
                .withAxeVertical(2L)
                .withMouvements("AAGAA")
                .withNombreTresorsRamasses(1L)
                .build();
        Aventurier aventurierRes2 = AventurierBuilder.anAventurier()
                .withNom("Titi")
                .withOrdreApparition(1L)
                .withOrientation("S")
                .withAxeHorizontal(3L)
                .withAxeVertical(2L)
                .withMouvements("AAA")
                .withNombreTresorsRamasses(0L)
                .build();

        List<Aventurier> aventurierListRest = Arrays.asList(aventurierRes1, aventurierRes2);
        structureGlobalResultExpected = StructureGlobalBuilder.aStructureGlobal()
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
                .withListAventuriers(aventurierListRest)
                .build();
    }

    @org.junit.Test
    public void testSimulationMouvements() throws IOException {
        StructureGlobal structureGlobalResult = SimulationMouvementsService
                .simulationMouvements(structureGlobalInitial);
        assertNotNull(structureGlobalResult);
        assertEquals(structureGlobalResult, structureGlobalResultExpected);
    }
}


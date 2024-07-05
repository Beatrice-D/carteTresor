package com.example.cartetresors.service;

import com.example.cartetresors.model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LireFichierService {
    /**
     * Lecture du fichier d'entrée et construction de la structure globale
     * qui contient un objet carte, et un ensemble de aventuriers, montagnes
     * et tresors
     * @return StructureInitial
     * @throws FileNotFoundException
     */
    public static StructureGlobal lireFichier(String fileName) throws FileNotFoundException {
        // Initialisation des attributs de la structure StructureGlobale
        Carte carte = null;
        List<Montagne> listMontagne = new ArrayList<>();
        List<Tresor> listTresor = new ArrayList<>();
        List<Aventurier> listAventurier = new ArrayList<>();
        long ordreApparitionCpt = 0;

        // Le fichier d'entrée
        FileInputStream file = new FileInputStream(fileName);
        Scanner scanner = new Scanner(file);

        // On lit le contenu du fichier ligne par ligne
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // On divise la chaine en mots, le séparateur est un tiret
            String[] words = line.split("-");

            // Détermine la lettre correspondante au premier mot de la ligne
            switch (words[0]) {
                // Si c'est le mot #, un commentaire donc on ignore
                case "#":
                    break;
                // Si c'est le mot C, on construit une instance Carte
                case "C":
                    carte = CarteBuilder.aCarte()
                            .withNombreCaseLargeur(Long.valueOf(words[1]))
                            .withNombreCaseHauteur(Long.valueOf(words[2]))
                            .build();
                    break;
                // Si c'est le mot A, on construit une instance Aventurier et
                // on l'ajoute à liste de aventuriers
                case "A":
                    Aventurier aventurier = AventurierBuilder.anAventurier()
                            .withNom(words[1])
                            .withAxeHorizontal(Long.valueOf(words[2]))
                            .withAxeVertical(Long.valueOf(words[3]))
                            .withOrientation(words[4])
                            .withMouvements(words[5])
                            .withOrdreApparition(Long.valueOf(ordreApparitionCpt++))
                            .withNombreTresorsRamasses(0L)
                            .build();
                    listAventurier.add(aventurier);
                    break;
                // Si c'est le mot M, on construit une instance Montagne et
                // on l'ajoute à liste de montagnes
                case "M":
                    Montagne montagne = MontagneBuilder.aMontagne()
                            .withAxeHorizontal(Long.valueOf(words[1]))
                            .withAxeVertical(Long.valueOf(words[2]))
                            .build();
                    listMontagne.add(montagne);
                    break;
                // Si c'est le mot T, on construit une instance Tresor et
                // on l'ajoute à liste de trésors
                case "T":
                    Tresor tresor = TresorBuilder.aTresor()
                            .withAxeHorizontal(Long.valueOf(words[1]))
                            .withAxeVertical(Long.valueOf(words[2]))
                            .withNombreTresors(Long.valueOf(words[3]))
                            .build();
                    listTresor.add(tresor);
                    break;
                default:
                    break;
            }
        }
        scanner.close();

        return StructureGlobalBuilder.aStructureGlobal()
                .withCarte(carte)
                .withListMontagne(listMontagne)
                .withListTresor(listTresor)
                .withListAventuriers(listAventurier)
                .build();
    }
}

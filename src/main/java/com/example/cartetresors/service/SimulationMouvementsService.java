package com.example.cartetresors.service;

import com.example.cartetresors.model.*;

import java.util.List;

public class SimulationMouvementsService {
    /**
     * Simulation des mouvements des aventuriers, gestion collecte des trésors et
     * modification de la structure globale avec les nouvelles données
     * @param structureGlobal
     * @return
     */
    public static StructureGlobal simulationMouvements(StructureGlobal structureGlobal) {

        // On parcourt la liste des aventuriers
        if (!structureGlobal.getListAventuriers().isEmpty()) {
            for (Aventurier aventurierCourant : structureGlobal.getListAventuriers()) {

                // On parcourt la séquence de mouvements de l'aventurier
                for (int i = 0; i < aventurierCourant.getMouvements().length(); i++) {
                    char mouvementAventurierCourant = aventurierCourant.getMouvements().charAt(i);
                    // Calcul de la nouvelle position de l'aventurier courant
                    SimulationMouvement simulationMouvementCourant = simulationMouvement(aventurierCourant,
                            mouvementAventurierCourant);
                    aventurierCourant.setOrientation(simulationMouvementCourant.getNouveauOrientation());

                    // Si le mouvement est sur avancer, on teste s'il y a collision avec une montagne
                    // pour éviter les mouvements bloquants
                    // Si ce n'est le cas, l'aventurier avance d'une case et on met à jour les différents
                    // attributs d'axes horizontaux et verticaux ainsi que l'orientation
                    if (simulationMouvementCourant.getMouvement() == 'A') {
                        if (peutAvancer(structureGlobal, simulationMouvementCourant, aventurierCourant, i) &&
                                !collisionAvecMontagne(structureGlobal, simulationMouvementCourant.getNouveauAxeHorizontal(),
                                simulationMouvementCourant.getNouveauAxeVertical())) {
                            aventurierCourant.setAxeHorizontal(simulationMouvementCourant.getNouveauAxeHorizontal());
                            aventurierCourant.setAxeVertical(simulationMouvementCourant.getNouveauAxeVertical());
                            // On teste également si l'aventurier est sur une case trésor pour mettre à jour les données
                            surUneCaseTresors(structureGlobal, aventurierCourant);
                            structureGlobal.getListTresor().removeIf((tresor -> tresor.getNombreTresors().equals(0L)));
                        }
                    }
                } // MOUVEMENTS
            } // AVENTURIERS
        }
        return structureGlobal;
    }

    /**
     * En fonction de l'orientation ainsi que le mouvement de l'aventurier
     * On calcule les nouveaux axes verticaux ou horizontaux si le mouvement est sur avancer
     * Sinon on calcule la nouvelle orientation si le mouvement est sur tourner à grauche ou à droite
     * @param aventurierCourant
     * @param mouvement
     * @return
     */
    public static SimulationMouvement simulationMouvement(Aventurier aventurierCourant, char mouvement) {
        // On définit les variables suivant pour mettre à jour les axes horizontaux et verticaux,
        // l'orientation ainsi que le nombre de trésors ramassés de l'aventurier à chaque mouvement
        Long nouveauAxeHorizontal = aventurierCourant.getAxeHorizontal();
        Long nouveauAxeVertical = aventurierCourant.getAxeVertical();
        String nouveauOrientation = aventurierCourant.getOrientation();

        switch (aventurierCourant.getOrientation()) {
            case "N":
                switch (mouvement) {
                    case 'A':
                        nouveauAxeVertical = aventurierCourant.getAxeVertical() - 1;
                        break;
                    case 'G':
                        nouveauOrientation = "O";
                        break;
                    case 'D':
                        nouveauOrientation = "E";
                        break;
                    default:
                        break;
                }
                break;
            case "S":
                switch (mouvement) {
                    case 'A':
                        nouveauAxeVertical = aventurierCourant.getAxeVertical() + 1;
                        break;
                    case 'G':
                        nouveauOrientation = "E";
                        break;
                    case 'D':
                        nouveauOrientation = "O";
                        break;
                    default:
                        break;
                }
                break;
            case "E":
                switch (mouvement) {
                    case 'A':
                        nouveauAxeHorizontal = aventurierCourant.getAxeHorizontal() + 1;
                        break;
                    case 'G':
                        nouveauOrientation = "N";
                        break;
                    case 'D':
                        nouveauOrientation = "S";
                        break;
                    default:
                        break;
                }
                break;
            case "O":
                switch (mouvement) {
                    case 'A':
                        nouveauAxeHorizontal = aventurierCourant.getAxeHorizontal() - 1;
                        break;
                    case 'G':
                        nouveauOrientation = "S";
                        break;
                    case 'D':
                        nouveauOrientation = "N";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return SimulationMouvementBuilder.aSimulationMouvement()
                .withMouvement(mouvement)
                .withNouveauAxeHorizontal(nouveauAxeHorizontal)
                .withNouveauAxeVertical(nouveauAxeVertical)
                .withNouveauOrientation(nouveauOrientation)
                .build();
    }


    /**
     * Test si l'aventurier peut avancer malgrè les conflits de mouvements entre aventuriers
     * @param structureGlobal
     * @param simulationMouvementCourant
     * @param aventurierCourant
     * @param position
     * @return
     */
    public static boolean peutAvancer(StructureGlobal structureGlobal,
                                     SimulationMouvement simulationMouvementCourant,
                                     Aventurier aventurierCourant, int position) {
        boolean peutAvancer = true;

        List<Aventurier> listAventuriersConcurents = structureGlobal.getListAventuriers()
                .stream().filter(av -> !av.equals(aventurierCourant)).toList();

        // On parcourt la liste des aventuriers concurrents
        for (Aventurier aventurierConcurrent: listAventuriersConcurents) {

            if (position < aventurierConcurrent.getMouvements().length()) {
                // Calcul de la nouvelle position de l'aventurier concurrent
                SimulationMouvement simulationMouvementConccurent = simulationMouvement(aventurierConcurrent,
                        aventurierConcurrent.getMouvements().charAt(position));

                // On teste si les positions se croisent
                // Si oui, la priorité des mouvements revient à l'aventurier avec un ordre
                // d'apparition prioritaire
                if (simulationMouvementCourant.getNouveauAxeHorizontal()
                        .equals(simulationMouvementConccurent.getNouveauAxeHorizontal())
                        && simulationMouvementCourant.getNouveauAxeVertical()
                        .equals(simulationMouvementConccurent.getNouveauAxeVertical())) {
                    if (aventurierCourant.getOrdreApparition().longValue() > aventurierConcurrent.getOrdreApparition().longValue()) {
                        peutAvancer = false;
                        break;
                    }
                }
            }
        }
        return peutAvancer;
    }

    /**
     * Test pour déterminer si l'aventurier est bloqué par une montagne
     * @param structureGlobal
     * @param axeHorizontalAventurier
     * @param axeVerticalAventurier
     * @return
     */
    private static boolean collisionAvecMontagne(StructureGlobal structureGlobal, Long axeHorizontalAventurier,
                                                 Long axeVerticalAventurier) {
        boolean collision = false;
        // On parcourt la liste de montagnes
        if (!structureGlobal.getListMontagne().isEmpty()) {
            for (Montagne montagne : structureGlobal.getListMontagne()) {
                if (montagne.getAxeHorizontal().equals(axeHorizontalAventurier)
                        && montagne.getAxeVertical().equals(axeVerticalAventurier)) {
                    collision = true;
                    break;
                }
            }
        }
        return collision;
    }

    /**
     * Test pour déterminer si l'aventurier est sur une case trésor, mis à jour des données si c'est le cas
     * @param structureGlobal
     * @param aventurier
     */
    private static void surUneCaseTresors(StructureGlobal structureGlobal, Aventurier aventurier) {
        // On parcout la liste des trésors
        if (!structureGlobal.getListTresor().isEmpty()) {
            for (Tresor tresor : structureGlobal.getListTresor()) {
                if (tresor.getAxeHorizontal().equals(aventurier.getAxeHorizontal())
                        && tresor.getAxeVertical().equals(aventurier.getAxeVertical())) {
                    tresor.setNombreTresors(tresor.getNombreTresors() - 1L);
                    long nombreTresorsRamasses = aventurier.getNombreTresorsRamasses() + 1;
                    aventurier.setNombreTresorsRamasses(Long.valueOf(nombreTresorsRamasses));
                    break;
                }
            }
        }
    }
}

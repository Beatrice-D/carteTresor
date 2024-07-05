package com.example.cartetresors.service;

import com.example.cartetresors.model.Aventurier;
import com.example.cartetresors.model.Montagne;
import com.example.cartetresors.model.StructureGlobal;
import com.example.cartetresors.model.Tresor;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

public class EcrireFichierService {

    /**
     * Ecriture du fichier de sortie contenant le résultat final de la simulation
     * @param structureGlobal
     * @throws IOException
     */
    public static void ecrireFichier(StructureGlobal structureGlobal, String resultFileName) throws IOException {
        FileWriter fw = new FileWriter(resultFileName);
        fw.write("C-" + structureGlobal.getCarte().getNombreCaseLargeur() + "-"
                + structureGlobal.getCarte().getNombreCaseHauteur() + "\n");
        // Parcours de la liste de montagne et écriture des attributs propre à l'entité Montagne dans le fichier
        for (Montagne montagne : structureGlobal.getListMontagne()) {
            fw.write("M-" + montagne.getAxeHorizontal() + "-"
                    + montagne.getAxeVertical() + "\n");
        }
        // Parcours de la liste de trésor et écriture des attributs propre à l'entité Tresor dans le fichier
        for (Tresor tresor : structureGlobal.getListTresor()) {
            fw.write("T-" + tresor.getAxeHorizontal() + "-"
                    + tresor.getAxeVertical() + "-" + tresor.getNombreTresors() + "\n");
        }
        // Parcours de la liste d'aventuriers et écriture des attributs propre à l'entité Aventurier dans le fichier
        for (Aventurier aventurier : structureGlobal.getListAventuriers()) {
            fw.write("A-" + aventurier.getNom() + "-" +aventurier.getAxeHorizontal() + "-"
                    + aventurier.getAxeVertical() + "-" + aventurier.getOrientation() + "-"
                    + aventurier.getNombreTresorsRamasses() + "\n");
        }
        fw.close();
    }
}

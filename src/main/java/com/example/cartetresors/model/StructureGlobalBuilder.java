package com.example.cartetresors.model;

import java.util.List;

public final class StructureGlobalBuilder {
    private Carte carte;
    private List<Montagne> listMontagne;
    private List<Tresor> listTresor;
    private List<Aventurier> listAventuriers;

    private StructureGlobalBuilder() {
    }

    public static StructureGlobalBuilder aStructureGlobal() {
        return new StructureGlobalBuilder();
    }

    public StructureGlobalBuilder withCarte(Carte carte) {
        this.carte = carte;
        return this;
    }

    public StructureGlobalBuilder withListMontagne(List<Montagne> listMontagne) {
        this.listMontagne = listMontagne;
        return this;
    }

    public StructureGlobalBuilder withListTresor(List<Tresor> listTresor) {
        this.listTresor = listTresor;
        return this;
    }

    public StructureGlobalBuilder withListAventuriers(List<Aventurier> listAventuriers) {
        this.listAventuriers = listAventuriers;
        return this;
    }

    public StructureGlobal build() {
        StructureGlobal structureGlobal = new StructureGlobal();
        structureGlobal.setCarte(carte);
        structureGlobal.setListMontagne(listMontagne);
        structureGlobal.setListTresor(listTresor);
        structureGlobal.setListAventuriers(listAventuriers);
        return structureGlobal;
    }
}

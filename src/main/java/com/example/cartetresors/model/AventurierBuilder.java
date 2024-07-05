package com.example.cartetresors.model;

public final class AventurierBuilder {
    private Long axeHorizontal;
    private String nom;
    private Long axeVertical;
    private String orientation;
    private String mouvements;
    private Long nombreTresorsRamasses;
    private Long ordreApparition;

    private AventurierBuilder() {
    }

    public static AventurierBuilder anAventurier() {
        return new AventurierBuilder();
    }

    public AventurierBuilder withAxeHorizontal(Long axeHorizontal) {
        this.axeHorizontal = axeHorizontal;
        return this;
    }

    public AventurierBuilder withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public AventurierBuilder withAxeVertical(Long axeVertical) {
        this.axeVertical = axeVertical;
        return this;
    }

    public AventurierBuilder withOrientation(String orientation) {
        this.orientation = orientation;
        return this;
    }

    public AventurierBuilder withMouvements(String mouvements) {
        this.mouvements = mouvements;
        return this;
    }

    public AventurierBuilder withNombreTresorsRamasses(Long nombreTresorsRamasses) {
        this.nombreTresorsRamasses = nombreTresorsRamasses;
        return this;
    }

    public AventurierBuilder withOrdreApparition(Long ordreApparition) {
        this.ordreApparition = ordreApparition;
        return this;
    }

    public Aventurier build() {
        Aventurier aventurier = new Aventurier();
        aventurier.setAxeHorizontal(axeHorizontal);
        aventurier.setNom(nom);
        aventurier.setAxeVertical(axeVertical);
        aventurier.setOrientation(orientation);
        aventurier.setMouvements(mouvements);
        aventurier.setNombreTresorsRamasses(nombreTresorsRamasses);
        aventurier.setOrdreApparition(ordreApparition);
        return aventurier;
    }
}

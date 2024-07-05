package com.example.cartetresors.model;

import java.util.Objects;

public class Aventurier {
    private String nom;
    private Long axeHorizontal;
    private Long axeVertical;
    private String orientation;
    private String mouvements;
    private Long nombreTresorsRamasses;

    private Long ordreApparition;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getAxeHorizontal() {
        return axeHorizontal;
    }

    public void setAxeHorizontal(Long axeHorizontal) {
        this.axeHorizontal = axeHorizontal;
    }

    public Long getAxeVertical() {
        return axeVertical;
    }

    public void setAxeVertical(Long axeVertical) {
        this.axeVertical = axeVertical;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getMouvements() {
        return mouvements;
    }

    public void setMouvements(String mouvements) {
        this.mouvements = mouvements;
    }

    public Long getNombreTresorsRamasses() {
        return nombreTresorsRamasses;
    }

    public void setNombreTresorsRamasses(Long nombreTresorsRamasses) {
        this.nombreTresorsRamasses = nombreTresorsRamasses;
    }

    public Long getOrdreApparition() {
        return ordreApparition;
    }

    public void setOrdreApparition(Long ordreApparition) {
        this.ordreApparition = ordreApparition;
    }

    @Override
    public String toString() {
        return "Aventurier{" +
                "axeHorizontal=" + axeHorizontal +
                ", axeVertical=" + axeVertical +
                ", mouvements='" + mouvements + '\'' +
                ", nom='" + nom + '\'' +
                ", nombreTresorsRamasses=" + nombreTresorsRamasses +
                ", ordreApparition=" + ordreApparition +
                ", orientation='" + orientation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aventurier that = (Aventurier) o;
        return Objects.equals(nom, that.nom) && Objects.equals(axeHorizontal, that.axeHorizontal) && Objects.equals(axeVertical, that.axeVertical) && Objects.equals(orientation, that.orientation) && Objects.equals(mouvements, that.mouvements) && Objects.equals(nombreTresorsRamasses, that.nombreTresorsRamasses) && Objects.equals(ordreApparition, that.ordreApparition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, axeHorizontal, axeVertical, orientation, mouvements, nombreTresorsRamasses, ordreApparition);
    }
}

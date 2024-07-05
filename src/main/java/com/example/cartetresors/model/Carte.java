package com.example.cartetresors.model;

import java.util.Objects;

public class Carte {
    private Long nombreCaseLargeur;
    private Long nombreCaseHauteur;

    public Carte(Long nombreCaseLargeur, Long nombreCaseHauteur) {
        this.nombreCaseLargeur = nombreCaseLargeur;
        this.nombreCaseHauteur = nombreCaseHauteur;
    }

    public Long getNombreCaseLargeur() {
        return nombreCaseLargeur;
    }

    public void setNombreCaseLargeur(Long nombreCaseLargeur) {
        this.nombreCaseLargeur = nombreCaseLargeur;
    }

    public Long getNombreCaseHauteur() {
        return nombreCaseHauteur;
    }

    public void setNombreCaseHauteur(Long nombreCaseHauteur) {
        this.nombreCaseHauteur = nombreCaseHauteur;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "nombreCaseHauteur=" + nombreCaseHauteur +
                ", nombreCaseLargeur=" + nombreCaseLargeur +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return Objects.equals(nombreCaseLargeur, carte.nombreCaseLargeur) && Objects.equals(nombreCaseHauteur, carte.nombreCaseHauteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreCaseLargeur, nombreCaseHauteur);
    }
}

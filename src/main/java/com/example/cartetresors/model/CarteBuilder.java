package com.example.cartetresors.model;

public final class CarteBuilder {
    private Long nombreCaseLargeur;
    private Long nombreCaseHauteur;

    private CarteBuilder() {
    }

    public static CarteBuilder aCarte() {
        return new CarteBuilder();
    }

    public CarteBuilder withNombreCaseLargeur(Long nombreCaseLargeur) {
        this.nombreCaseLargeur = nombreCaseLargeur;
        return this;
    }

    public CarteBuilder withNombreCaseHauteur(Long nombreCaseHauteur) {
        this.nombreCaseHauteur = nombreCaseHauteur;
        return this;
    }

    public Carte build() {
        return new Carte(nombreCaseLargeur, nombreCaseHauteur);
    }
}

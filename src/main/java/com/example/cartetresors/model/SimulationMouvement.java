package com.example.cartetresors.model;

public class SimulationMouvement {
    private String nouveauOrientation;
    private Long nouveauAxeVertical;
    private Long nouveauAxeHorizontal;
    private char mouvement;

    public char getMouvement() {
        return mouvement;
    }

    public void setMouvement(char mouvement) {
        this.mouvement = mouvement;
    }
    public Long getNouveauAxeHorizontal() {
        return nouveauAxeHorizontal;
    }

    public void setNouveauAxeHorizontal(Long nouveauAxeHorizontal) {
        this.nouveauAxeHorizontal = nouveauAxeHorizontal;
    }

    public Long getNouveauAxeVertical() {
        return nouveauAxeVertical;
    }

    public void setNouveauAxeVertical(Long nouveauAxeVertical) {
        this.nouveauAxeVertical = nouveauAxeVertical;
    }

    public String getNouveauOrientation() {
        return nouveauOrientation;
    }

    public void setNouveauOrientation(String nouveauOrientation) {
        this.nouveauOrientation = nouveauOrientation;
    }
}

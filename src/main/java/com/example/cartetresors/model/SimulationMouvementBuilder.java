package com.example.cartetresors.model;

public final class SimulationMouvementBuilder {
    private char mouvement;
    private String nouveauOrientation;
    private Long nouveauAxeVertical;
    private Long nouveauAxeHorizontal;

    private SimulationMouvementBuilder() {
    }

    public static SimulationMouvementBuilder aSimulationMouvement() {
        return new SimulationMouvementBuilder();
    }

    public SimulationMouvementBuilder withMouvement(char mouvement) {
        this.mouvement = mouvement;
        return this;
    }

    public SimulationMouvementBuilder withNouveauOrientation(String nouveauOrientation) {
        this.nouveauOrientation = nouveauOrientation;
        return this;
    }

    public SimulationMouvementBuilder withNouveauAxeVertical(Long nouveauAxeVertical) {
        this.nouveauAxeVertical = nouveauAxeVertical;
        return this;
    }

    public SimulationMouvementBuilder withNouveauAxeHorizontal(Long nouveauAxeHorizontal) {
        this.nouveauAxeHorizontal = nouveauAxeHorizontal;
        return this;
    }

    public SimulationMouvement build() {
        SimulationMouvement simulationMouvement = new SimulationMouvement();
        simulationMouvement.setMouvement(mouvement);
        simulationMouvement.setNouveauOrientation(nouveauOrientation);
        simulationMouvement.setNouveauAxeVertical(nouveauAxeVertical);
        simulationMouvement.setNouveauAxeHorizontal(nouveauAxeHorizontal);
        return simulationMouvement;
    }
}

package com.example.cartetresors.model;

public final class TresorBuilder {
    private Long axeHorizontal;
    private Long axeVertical;
    private Long nombreTresors;

    private TresorBuilder() {
    }

    public static TresorBuilder aTresor() {
        return new TresorBuilder();
    }

    public TresorBuilder withAxeHorizontal(Long axeHorizontal) {
        this.axeHorizontal = axeHorizontal;
        return this;
    }

    public TresorBuilder withAxeVertical(Long axeVertical) {
        this.axeVertical = axeVertical;
        return this;
    }

    public TresorBuilder withNombreTresors(Long nombreTresors) {
        this.nombreTresors = nombreTresors;
        return this;
    }

    public Tresor build() {
        Tresor tresor = new Tresor();
        tresor.setAxeHorizontal(axeHorizontal);
        tresor.setAxeVertical(axeVertical);
        tresor.setNombreTresors(nombreTresors);
        return tresor;
    }
}

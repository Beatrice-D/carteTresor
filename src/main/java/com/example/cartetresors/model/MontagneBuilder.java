package com.example.cartetresors.model;

public final class MontagneBuilder {
    private Long axeHorizontal;
    private Long axeVertical;

    private MontagneBuilder() {
    }

    public static MontagneBuilder aMontagne() {
        return new MontagneBuilder();
    }

    public MontagneBuilder withAxeHorizontal(Long axeHorizontal) {
        this.axeHorizontal = axeHorizontal;
        return this;
    }

    public MontagneBuilder withAxeVertical(Long axeVertical) {
        this.axeVertical = axeVertical;
        return this;
    }

    public Montagne build() {
        Montagne montagne = new Montagne();
        montagne.setAxeHorizontal(axeHorizontal);
        montagne.setAxeVertical(axeVertical);
        return montagne;
    }
}

package com.example.cartetresors.model;

import java.util.Objects;

public class Montagne {
    private Long axeHorizontal;
    private Long axeVertical;

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

    @Override
    public String toString() {
        return "Montagne{" +
                "axeHorizontal=" + axeHorizontal +
                ", axeVertical=" + axeVertical +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Montagne montagne = (Montagne) o;
        return Objects.equals(axeHorizontal, montagne.axeHorizontal) && Objects.equals(axeVertical, montagne.axeVertical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(axeHorizontal, axeVertical);
    }
}

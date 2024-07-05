package com.example.cartetresors.model;

import java.util.Objects;

public class Tresor {
    private Long axeHorizontal;
    private Long axeVertical;
    private Long nombreTresors;

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

    public Long getNombreTresors() {
        return nombreTresors;
    }

    public void setNombreTresors(Long nombreTresors) {
        this.nombreTresors = nombreTresors;
    }

    @Override
    public String toString() {
        return "Tresor{" +
                "axeHorizontal=" + axeHorizontal +
                ", axeVertical=" + axeVertical +
                ", nombreTresors=" + nombreTresors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tresor tresor = (Tresor) o;
        return Objects.equals(axeHorizontal, tresor.axeHorizontal) && Objects.equals(axeVertical, tresor.axeVertical) && Objects.equals(nombreTresors, tresor.nombreTresors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(axeHorizontal, axeVertical, nombreTresors);
    }
}

package com.example.cartetresors.model;

import java.util.List;
import java.util.Objects;

public class StructureGlobal {
    private Carte carte;
    private List<Montagne> listMontagne;
    private List<Tresor> listTresor;
    private List<Aventurier> listAventuriers;

    public List<Aventurier> getListAventuriers() {
        return listAventuriers;
    }

    public void setListAventuriers(List<Aventurier> listAventuriers) {
        this.listAventuriers = listAventuriers;
    }

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public List<Montagne> getListMontagne() {
        return listMontagne;
    }

    public void setListMontagne(List<Montagne> listMontagne) {
        this.listMontagne = listMontagne;
    }

    public List<Tresor> getListTresor() {
        return listTresor;
    }

    public void setListTresor(List<Tresor> listTresor) {
        this.listTresor = listTresor;
    }

    @Override
    public String toString() {
        return "StructureInitial{" +
                "carte=" + carte +
                ", listMontagne=" + listMontagne +
                ", listTresor=" + listTresor +
                ", listAventuriers=" + listAventuriers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructureGlobal that = (StructureGlobal) o;
        return Objects.equals(carte, that.carte) && Objects.equals(listMontagne, that.listMontagne)
                && Objects.equals(listTresor, that.listTresor) && Objects.equals(listAventuriers, that.listAventuriers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carte, listMontagne, listTresor, listAventuriers);
    }
}

package com.mycompany.guiquiniela2;

import java.io.Serializable;

public class Seleccion implements Serializable {
    private String nombre;
    private int ranking;
    private int puntosGrupo;
    public Seleccion(String nombre, int ranking) {
        this.nombre = nombre;
        this.ranking = ranking;
        puntosGrupo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPuntosGrupo() {
        return puntosGrupo;
    }

    public void setPuntosGrupo(int puntosGrupo) {
        this.puntosGrupo += puntosGrupo;
    }
}

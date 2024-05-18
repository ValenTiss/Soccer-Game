/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiquiniela2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author valentin
 */
public class Elo implements Serializable {
    int puntosTotal;

    List<Partido> mundialJugado = new ArrayList<>();
    Map<Partido,Integer> usuariosPuntaje = new HashMap<Partido,Integer>();

    public Elo(List<Partido> historial) {
        for (Partido partido:
             historial) {
            usuariosPuntaje.put(partido,-1);
        }
    }

    public boolean seJugoMundial(int partido){
        if((mundialJugado.get(partido).getMarcadorEquipo() != -1) && (mundialJugado.get(partido).getMarcadorContrincante() != -1))
            return true;
        return false;
    }


}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiquiniela2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author valentin
 */
public class Partido implements Serializable {
    private LocalDate fecha;
    private Seleccion equipo;
    private Seleccion contrincante;
    private boolean estado;
    private int marcadorEquipo;
    private int marcadorContrincante;
    private String grupoAsignado;
    private BDMundiales faseAsignada;

    private double marcadoresPenales;

    public Partido(LocalDate fecha, Seleccion equipo, Seleccion contrincante, String equipoAsignado) {
        this.fecha = fecha;
        this.equipo = equipo;
        this.contrincante = contrincante;
        this.grupoAsignado = equipoAsignado;
        marcadoresPenales = -1;
    }

    public Partido(LocalDate fecha) {
        this.fecha = fecha;
        marcadorEquipo = -1;
        marcadorContrincante = -1;
        marcadoresPenales = -1;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Seleccion getEquipo() {
        return equipo;
    }

    public void setEquipo(Seleccion equipo) {
        this.equipo = equipo;
    }

    public Seleccion getContrincante() {
        return contrincante;
    }

    public void setContrincante(Seleccion contrincante) {
        this.contrincante = contrincante;
    }

    public int getMarcadorEquipo() {
        return marcadorEquipo;
    }

    public int setMarcadorEquipo(int marcadorEquipo) {
        this.marcadorEquipo = marcadorEquipo;
        return marcadorEquipo;
    }

    public int getMarcadorContrincante() {
        return marcadorContrincante;
    }

    public int setMarcadorContrincante(int marcadorContrincante) {
        this.marcadorContrincante = marcadorContrincante;
        return marcadorContrincante;
    }

    public int setMarcadorEquipoAleatorio() {
        Random rm = new Random();
        marcadorEquipo = probabildadGoles(rm.nextInt(101));
        return marcadorEquipo;
    }
    public int setMarcadorContrincanteAleatorio() {
        Random rm = new Random();
        marcadorContrincante = probabildadGoles(rm.nextInt(101));
        return marcadorContrincante;
    }

    public int setMarcadorEquipo(int rankEquipo,int rankContrincante){

        return marcadorEquipo;
    }
    private int probabildadGoles(int aleatorio){
        Random rm = new Random();
        if((aleatorio >= 1) && (aleatorio <= 26))
            return 0;
        else if ((aleatorio >= 27) && (aleatorio <= 53))
            return 1;
        else if ((aleatorio >= 54) && (aleatorio <= 80))
            return 2;
        else if ((aleatorio >= 81) && (aleatorio <= 87))
            return 3;
        else if ((aleatorio >= 88) && (aleatorio <= 95))
            return 4;
        else
        {
            int entreCincoYOcho = rm.nextInt(5,8);
            return entreCincoYOcho;
        }
    }

    public void setMarcadoresHeuristicos(){
        Random rm = new Random();
        int golesEquipo,golesContrincante;
        int probabilidadEquipo = rm.nextInt(equipo.getRanking());
        int probabilidadContrincante = rm.nextInt(contrincante.getRanking());
        if(probabilidadEquipo > probabilidadContrincante){
            golesEquipo = probabildadGoles(rm.nextInt(83)+(int)(equipo.getRanking()/100));
            golesContrincante = probabildadGoles(rm.nextInt(83)-(int)(equipo.getRanking()/100));
        }else if(probabilidadEquipo < probabilidadContrincante)
        {
            golesEquipo = probabildadGoles(rm.nextInt(83)+(int)(equipo.getRanking()/100));
            golesContrincante = probabildadGoles(rm.nextInt(83)-(int)(equipo.getRanking()/100));

        }else
        {
            golesEquipo = probabildadGoles(rm.nextInt(101));
            golesContrincante = probabildadGoles(rm.nextInt(101));
        }
        marcadorEquipo = golesEquipo;
        marcadorContrincante = golesContrincante;
        setMarcadorContrincante(golesContrincante);
        setMarcadorEquipo(golesEquipo);
    }
    public Seleccion seDefinePorPenales(){
        Random rm = new Random();
        int penalesEquipo = rm.nextInt(0,9);
        double penalesContrincante = rm.nextDouble(0,0.9);
        while(penalesEquipo == ((int)(10*(penalesContrincante-(int)penalesContrincante)))){
            penalesEquipo = rm.nextInt(0,9);
            penalesContrincante = rm.nextDouble(0,0.9);
        }
        setMarcadoresPenales(penalesEquipo+penalesContrincante);
        if(penalesEquipo > (penalesContrincante*10))
            return equipo;
        else
            return contrincante;
    }
    public Seleccion seDefinePorPenalesH(){
        Random rm = new Random();
        Seleccion ganador = null;
        double golesContrincante = 0;
        int golesEquipo = 0;
        int ganarEquipo = rm.nextInt(equipo.getRanking());
        int ganarContrincante = rm.nextInt(contrincante.getRanking());
        while(ganarEquipo == ganarContrincante){
            ganarEquipo = rm.nextInt(equipo.getRanking());
            ganarContrincante = rm.nextInt(contrincante.getRanking());
        }
        if(ganarEquipo > ganarContrincante){
            golesEquipo = rm.nextInt(5,9);
            golesContrincante =rm.nextDouble(0,(double) golesEquipo-1/10 );
            ganador = equipo;
        }else if(ganarEquipo < ganarContrincante)
        {
            golesContrincante = rm.nextDouble(0.5,0.9);
            golesEquipo = rm.nextInt(0,(int)((golesContrincante-0.1)*10));
            ganador = contrincante;
        }
        setMarcadoresPenales(golesEquipo+golesContrincante);
        return ganador;
    }
    public String getGrupoAsignado() {
        return grupoAsignado;
    }

    public double getMarcadoresPenales() {
        return marcadoresPenales;
    }

    public void setMarcadoresPenales(double marcadoresPenales) {
        this.marcadoresPenales = marcadoresPenales;
    }


}

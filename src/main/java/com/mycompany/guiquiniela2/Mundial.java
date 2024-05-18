package com.mycompany.guiquiniela2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Mundial implements Serializable {
    private List<Partido> historialDePartidos = new ArrayList<>();
    private List<Seleccion> seleccionesPresentes = new ArrayList<>();
    private List<Seleccion> convocadosAOctavos = new ArrayList<>();
    private List<Seleccion> Ganadores = new ArrayList<>();

    /**
     * Metodo constructor del mundial
     */
    public Mundial() {
        String nombre = "Qatar 2022";
        cargarSelecciones();
        cargarItinerario();
    }

    /**
     * Metodo para cargar las selecciones
     */
    public void cargarSelecciones(){
        seleccionesPresentes.add(new Seleccion("Qatar",1441));
        seleccionesPresentes.add(new Seleccion("Ecuador",1463));
        seleccionesPresentes.add(new Seleccion("Senegal",1584));
        seleccionesPresentes.add(new Seleccion("Países Bajos",1679));
        seleccionesPresentes.add(new Seleccion("Inglaterra",1737));
        seleccionesPresentes.add(new Seleccion("Iran",1558));
        seleccionesPresentes.add(new Seleccion("EE.UU.",1635));
        seleccionesPresentes.add(new Seleccion("Gales",1582));
        seleccionesPresentes.add(new Seleccion("Argentina",1770));
        seleccionesPresentes.add(new Seleccion("Arabia Saudita",1435));
        seleccionesPresentes.add(new Seleccion("México",1649));
        seleccionesPresentes.add(new Seleccion("Polonia",1546));
        seleccionesPresentes.add(new Seleccion("Francia",1764));
        seleccionesPresentes.add(new Seleccion("Australia",1483));
        seleccionesPresentes.add(new Seleccion("Dinamarca",1665));
        seleccionesPresentes.add(new Seleccion("Túnez",1507));
        seleccionesPresentes.add(new Seleccion("España",1716));
        seleccionesPresentes.add(new Seleccion("Costa Rica",1500));
        seleccionesPresentes.add(new Seleccion("Alemania",1658));
        seleccionesPresentes.add(new Seleccion("Japón",1554));
        seleccionesPresentes.add(new Seleccion("Bélgica",1821));
        seleccionesPresentes.add(new Seleccion("Canada",1473));
        seleccionesPresentes.add(new Seleccion("Croacia",1632));
        seleccionesPresentes.add(new Seleccion("Marruecos",1558));
        seleccionesPresentes.add(new Seleccion("Brasil",1837));
        seleccionesPresentes.add(new Seleccion("Serbia",1549));
        seleccionesPresentes.add(new Seleccion("Suiza",1621));
        seleccionesPresentes.add(new Seleccion("Camerún",1484));
        seleccionesPresentes.add(new Seleccion("Portugal",1678));
        seleccionesPresentes.add(new Seleccion("Ghana",1393));
        seleccionesPresentes.add(new Seleccion("Uruguay",1640));
        seleccionesPresentes.add(new Seleccion("Corea Del Sur",1526));
    }

    /**
     * Metodo para buscar una seleccion
     * @param seleccionBuscar Nombre de la seleccion
     * @return La seleccion si fue encontrada
     */
    private Seleccion buscarSeleccion(String seleccionBuscar){
        for (Seleccion selecciones :
                seleccionesPresentes) {
            if(selecciones.getNombre().equals(seleccionBuscar))
                return selecciones;
        }
        return null;
    }

    /**
     * Metodos para inicializar los partidos,por fase.
     */
    public void cargarItinerario(){
        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("calendarioDePartidos.csv"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy H:m", Locale.ENGLISH);
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(splitBy);
                if (datos.length == 7) {
                    historialDePartidos.add(new Partido(LocalDate.parse(datos[2],formatter),buscarSeleccion(datos[4]),buscarSeleccion(datos[5]),datos[6]));

                }else{
                    historialDePartidos.add(new Partido(LocalDate.parse(datos[2],formatter)));
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Metodo para inicializar los partidos de octavo de final
     */
    public void crearItinerarioOctavos(){
        int nroDePartido = 48;
        for (int i = 0; i < 4; i++) {
            historialDePartidos.get(nroDePartido).setEquipo(convocadosAOctavos.get(i*4));
            historialDePartidos.get(nroDePartido).setContrincante(convocadosAOctavos.get(3+(4*i)));
            nroDePartido += 1;
        }
        for (int i = 1; i <= 14; i+=4) {
            historialDePartidos.get(nroDePartido).setContrincante(convocadosAOctavos.get(i));
            historialDePartidos.get(nroDePartido).setEquipo(convocadosAOctavos.get(i+1));
            nroDePartido += 1;
        }
    }

    /**
     * Metodo para inicializar los partidos de cuarto de final
     */
    public void crearItinerarioCuartos(List<Seleccion>seleccionesPresentes){
        int nroDePartido = 56;
        for (int i = 0; i <= 6; i+=2) {
            historialDePartidos.get(nroDePartido).setEquipo(seleccionesPresentes.get(i));
            historialDePartidos.get(nroDePartido).setContrincante(seleccionesPresentes.get(i+1));
            nroDePartido += 1;
        }
    }

    /**
     * Metodo para inicializar los partidos de semifinal
     */
    public void crearItinerarioSemi(List<Seleccion>seleccionesPresentes){
        int nroDePartido = 60;
        for (int i = 0; i < 3; i+=2) {
            historialDePartidos.get(nroDePartido).setEquipo(seleccionesPresentes.get(i));
            historialDePartidos.get(nroDePartido).setContrincante(seleccionesPresentes.get(i+1));
            nroDePartido += 1;
        }
    }
    public void crearItinerarioFinal(List<Seleccion>seleccionesPresentes){
        historialDePartidos.get(62).setEquipo(seleccionesPresentes.get(2));
        historialDePartidos.get(63).setEquipo(seleccionesPresentes.get(0));
        historialDePartidos.get(63).setContrincante(seleccionesPresentes.get(1));
    }

    /**
     * Tipos de creacion de mundiales.
     */
    public List<Seleccion> jugarMundialAleatorio() {
        jugarFaseDeGrupoAleatoria();
        siguenJugando();
        List<Seleccion> pasanACuarto = jugarOctavosAleatorio();
        List<Seleccion> pasanASemi = jugarCuartosAleatorio(pasanACuarto);
        List<Seleccion> pasanAFinal = jugarSemiAleatorio(pasanASemi);
        List<Seleccion> Final = jugarFinalAleatorio(pasanAFinal);
        imprimirPartidos();
        return Final;
    }

    public List<Seleccion> jugarMundialHeuristico(){
        jugarFaseDeGrupoHeuristico();
        siguenJugando();
        List<Seleccion> pasanACuarto = jugarOctavosHeuristico();
        List<Seleccion> pasanASemi = jugarCuartosHeuristicos(pasanACuarto);
        List<Seleccion> pasanAFinal = jugarSemiHeuristico(pasanASemi);
        List<Seleccion> Final = jugarFinalHeuristico(pasanAFinal);
        imprimirPartidos();
        return pasanACuarto;
    }
    /**
     * Metodos para jugar mundial aleatoriamente.
     */
    public void jugarFaseDeGrupoAleatoria() {
        for (int i = 0; i < 48; i++) {
            Partido modificar = historialDePartidos.get(i);
            int marcadorEquipo = modificar.setMarcadorEquipoAleatorio();
            int marcadorContrincante = modificar.setMarcadorContrincanteAleatorio();
            comportamientoDePuntos(modificar,marcadorEquipo,marcadorContrincante);
        }
    }

    public List<Seleccion> jugarOctavosAleatorio(){
        List<Seleccion> pasanACuarto = new ArrayList<>();
        crearItinerarioOctavos();
        for (int i = 48; i <= 55; i++) {
            Partido partido = historialDePartidos.get(i);
            partido.setMarcadorContrincanteAleatorio();
            partido.setMarcadorEquipoAleatorio();
            Seleccion seleccionGanadora = comportamientoPartidosOctavosYMas(partido);
            pasanACuarto.add(seleccionGanadora);
        }
         return pasanACuarto;
    }

    public List<Seleccion> jugarCuartosAleatorio(List<Seleccion>seleccionesPresentes){
        List<Seleccion> pasanASemi = new ArrayList<>();
        crearItinerarioCuartos(seleccionesPresentes);
        for (int i = 56; i <= 59; i++) {
            Partido partido = historialDePartidos.get(i);
            partido.setMarcadorContrincanteAleatorio();
            partido.setMarcadorEquipoAleatorio();
            Seleccion seleccionGanadora = comportamientoPartidosOctavosYMas(partido);
            pasanASemi.add(seleccionGanadora);
        }
        return pasanASemi;
    }

    public List<Seleccion> jugarSemiAleatorio(List<Seleccion>seleccionesPresentes){
        List<Seleccion> pasanFinal = new ArrayList<>();
        crearItinerarioSemi(seleccionesPresentes);
        for (int i = 60; i <= 61; i++) {
            Partido partido = historialDePartidos.get(i);
            partido.setMarcadorContrincanteAleatorio();
            partido.setMarcadorEquipoAleatorio();
            Seleccion seleccionGanadora = comportamientoPartidosOctavosYMas(partido);
            seleccionesPresentes.remove(seleccionGanadora);
            pasanFinal.add(seleccionGanadora);
        }
        Partido partidoTercero = historialDePartidos.get(62);
        partidoTercero.setEquipo(seleccionesPresentes.get(0));
        partidoTercero.setContrincante(seleccionesPresentes.get(1));
        partidoTercero.setMarcadorContrincanteAleatorio();
        partidoTercero.setMarcadorEquipoAleatorio();
        Seleccion seleccionTercera = comportamientoPartidosOctavosYMas(partidoTercero);
        pasanFinal.add(seleccionTercera);
        return pasanFinal;
    }

    public List<Seleccion> jugarFinalAleatorio(List<Seleccion>seleccionesPresentes){
        List<Seleccion>ganadores = new ArrayList<>();
        crearItinerarioFinal(seleccionesPresentes);
        historialDePartidos.get(63).setMarcadorEquipoAleatorio();
        historialDePartidos.get(63).setMarcadorContrincanteAleatorio();
        Seleccion ganador = comportamientoPartidosOctavosYMas(historialDePartidos.get(63));
        if(ganador.equals(seleccionesPresentes.get(0))){
            ganadores.add(ganador);
            ganadores.add(seleccionesPresentes.get(1));
        }else
        {
            ganadores.add(ganador);
            ganadores.add(seleccionesPresentes.get(0));
        }
        ganadores.add(seleccionesPresentes.get(2));
        return ganadores;
    }

    /**
     * Metodos para jugar un mundial heuristico.
     */
    public void jugarFaseDeGrupoHeuristico() {

        for (int i = 0; i < 48; i++) {
            Partido modificar = historialDePartidos.get(i);
            modificar.setMarcadoresHeuristicos();
            comportamientoDePuntos(modificar,modificar.getMarcadorEquipo(),modificar.getMarcadorContrincante());
        }
    }

    public List<Seleccion> jugarOctavosHeuristico(){
        List<Seleccion> pasanACuarto = new ArrayList<>();
        crearItinerarioOctavos();
        for (int i = 48; i <= 55; i++) {
            Partido partido = historialDePartidos.get(i);
            partido.setMarcadoresHeuristicos();
            Seleccion seleccionGanadora = comportamientoPartidosOctavosHeuristicos(partido);
            pasanACuarto.add(seleccionGanadora);
        }
        return pasanACuarto;
    }
    public Seleccion comportamientoPartidosOctavosHeuristicos(Partido partido){
        if(partido.getMarcadorEquipo() == partido.getMarcadorContrincante()){
            return partido.seDefinePorPenalesH();
        }else if(partido.getMarcadorEquipo() > partido.getMarcadorContrincante())
        {
            return partido.getEquipo();
        }
        else
        {
            return partido.getContrincante();
        }
    }

    public List<Seleccion> jugarCuartosHeuristicos(List<Seleccion>seleccionesPresentes){
        List<Seleccion> pasanASemi = new ArrayList<>();
        crearItinerarioCuartos(seleccionesPresentes);
        for (int i = 56; i <= 59; i++) {
            Partido partido = historialDePartidos.get(i);
            partido.setMarcadoresHeuristicos();
            Seleccion seleccionGanadora = comportamientoPartidosOctavosYMas(partido);
            pasanASemi.add(seleccionGanadora);
        }
        return pasanASemi;
    }

    public List<Seleccion> jugarSemiHeuristico(List<Seleccion>seleccionesPresentes){
        List<Seleccion> pasanFinal = new ArrayList<>();
        crearItinerarioSemi(seleccionesPresentes);
        for (int i = 60; i <= 61; i++) {
            Partido partido = historialDePartidos.get(i);
            partido.setMarcadoresHeuristicos();
            Seleccion seleccionGanadora = comportamientoPartidosOctavosHeuristicos(partido);
            seleccionesPresentes.remove(seleccionGanadora);
            pasanFinal.add(seleccionGanadora);
        }
        Partido partidoTercero = historialDePartidos.get(62);
        partidoTercero.setEquipo(seleccionesPresentes.get(0));
        partidoTercero.setContrincante(seleccionesPresentes.get(1));
        partidoTercero.setMarcadoresHeuristicos();
        Seleccion seleccionTercera = comportamientoPartidosOctavosHeuristicos(partidoTercero);
        pasanFinal.add(seleccionTercera);
        return pasanFinal;
    }

    public List<Seleccion> jugarFinalHeuristico(List<Seleccion>seleccionesPresentes){
        List<Seleccion>ganadores = new ArrayList<>();
        crearItinerarioFinal(seleccionesPresentes);
        historialDePartidos.get(63).setMarcadoresHeuristicos();
        Seleccion ganador = comportamientoPartidosOctavosHeuristicos(historialDePartidos.get(63));
        if(ganador.equals(seleccionesPresentes.get(0))){
            ganadores.add(ganador);
            ganadores.add(seleccionesPresentes.get(1));
        }else
        {
            ganadores.add(ganador);
            ganadores.add(seleccionesPresentes.get(0));
        }
        ganadores.add(seleccionesPresentes.get(2));
        return ganadores;
    }

    /**
     *Metodos reglamentales del mundial.
     */
    public void comportamientoDePuntos(Partido modificar,int marcadorEquipo ,int marcadorContrincante){
        if(marcadorEquipo > marcadorContrincante)
        {
            modificar.getEquipo().setPuntosGrupo(3);
        }
        else if (marcadorEquipo < marcadorContrincante)
        {
            modificar.getContrincante().setPuntosGrupo(3);
        } else
        {
            modificar.getEquipo().setPuntosGrupo(0);
            modificar.getContrincante().setPuntosGrupo(0);
        }
        modificar.getEquipo().setPuntosGrupo(marcadorEquipo - marcadorContrincante);
        modificar.getContrincante().setPuntosGrupo(marcadorContrincante - marcadorEquipo);
    }
    public List<Seleccion> siguenJugando(){
        Seleccion gruposAJugar[][] = new Seleccion[8][4];
        List<String> grupos = Arrays.asList("Grupo A","Grupo B", "Grupo C" ,"Grupo D","Grupo E", "Grupo F","Grupo G", "Grupo H");
        for (int i = 0; i <16; i++) {
            Partido modificar = historialDePartidos.get(i);
            int EquipoAsignar = grupos.indexOf(modificar.getGrupoAsignado());
            if(gruposAJugar[EquipoAsignar][0] == null && gruposAJugar[EquipoAsignar][1] == null){
                gruposAJugar[EquipoAsignar][0] = modificar.getEquipo();
                gruposAJugar[EquipoAsignar][1] = modificar.getContrincante();
            }else
            {
                gruposAJugar[EquipoAsignar][2] = modificar.getEquipo();
                gruposAJugar[EquipoAsignar][3] = modificar.getContrincante();
            }

        }
        for (int i = 0; i < gruposAJugar.length; i++) {
            List<Integer> puntosSeleccionPorGrupo = new ArrayList<>();
            for (Seleccion seleccionJugar :
                    gruposAJugar[0]) {
                puntosSeleccionPorGrupo.add(seleccionJugar.getPuntosGrupo());
            }
            List<Integer> ganadores = obtenerEquiposMayor(puntosSeleccionPorGrupo);
            convocadosAOctavos.add(gruposAJugar[i][ganadores.get(0)]);
            convocadosAOctavos.add(gruposAJugar[i][ganadores.get(1)]);
        }
        crearItinerarioOctavos();
        return convocadosAOctavos;
    }
    private List<Integer> obtenerEquiposMayor(List<Integer> listaDePuntosPorEquipo){
        List<Integer> devolver = new ArrayList<>();
        int primero = listaDePuntosPorEquipo.indexOf(Collections.max(listaDePuntosPorEquipo));
        int minimo = Collections.min(listaDePuntosPorEquipo);
        listaDePuntosPorEquipo.set(primero,minimo-1);
        int segundo = listaDePuntosPorEquipo.indexOf(Collections.max(listaDePuntosPorEquipo));
        return devolver = Arrays.asList(primero,segundo);
    }
    public Seleccion comportamientoPartidosOctavosYMas(Partido partido){
        if(partido.getMarcadorEquipo() == partido.getMarcadorContrincante()){
            return partido.seDefinePorPenales();
        }else if(partido.getMarcadorEquipo() > partido.getMarcadorContrincante())
            return partido.getEquipo();
        else
            return partido.getContrincante();
    }
    public void imprimirPartidos(){
        for (Partido partidoJugar :
                historialDePartidos) {
            if((partidoJugar.getContrincante() != null) && (partidoJugar.getMarcadoresPenales() == -1))
                System.out.println("La fecha: " + partidoJugar.getFecha() + " ,"+partidoJugar.getEquipo().getNombre()
                        +"("+partidoJugar.getMarcadorEquipo()+") vs "+ partidoJugar.getContrincante().getNombre()+
                        "("+ partidoJugar.getMarcadorContrincante() + ").");
            else if(partidoJugar.getMarcadoresPenales() != -1) {
                double penales = partidoJugar.getMarcadoresPenales();
                System.out.println("La fecha: " + partidoJugar.getFecha() + " ," + partidoJugar.getEquipo().getNombre()
                        + "(" + partidoJugar.getMarcadorEquipo() + ") vs " + partidoJugar.getContrincante().getNombre() +
                        "(" + partidoJugar.getMarcadorContrincante() + ").   Penales:" +
                        "(" + String.valueOf((int) penales) + "-" + String.valueOf((int) (10 * (penales - (int) penales))) + ")");
            }
        }

    }


    /**
     * Metodos getters y setters.
     */

    public List<Seleccion> getGanadores() {
        return Ganadores;
    }

    public void setGanadores(List<Seleccion> ganadores) {
        Ganadores = ganadores;
    }
    public List<Partido> getHistorialDePartidos() {
        return historialDePartidos;
    }

    public void setHistorialDePartidos(List<Partido> historialDePartidos) {
        this.historialDePartidos = historialDePartidos;
    }

    public List<Seleccion> getConvocadosAOctavos() {
        return convocadosAOctavos;
    }

    public void setConvocadosAOctavos(List<Seleccion> convocadosAOctavos) {
        this.convocadosAOctavos = convocadosAOctavos;
    }
}

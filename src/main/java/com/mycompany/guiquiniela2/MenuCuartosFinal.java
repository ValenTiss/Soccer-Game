package com.mycompany.guiquiniela2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCuartosFinal extends JFrame{
    private JPanel principalPanel;
    private JTextField txtfMarcadorEquipo01;
    private JTextField txtfMarcadorCont01;
    private JLabel lblEquipo01;
    private JLabel lblContrincante01;
    private JPanel PnlRdo01;
    private JLabel RdoPartido01;
    private JLabel lblEquipo04;
    private JTextField txtfMarcadorEquipo04;
    private JTextField txtfMarcadorCont04;
    private JLabel lblContrincante04;
    private JPanel PnlRdo04;
    private JLabel RdoPartido04;
    private JLabel lblEquipo03;
    private JTextField txtfMarcadorEquipo03;
    private JTextField txtfMarcadorCont03;
    private JLabel lblContrincante03;
    private JPanel PnlRdo03;
    private JLabel RdoPartido03;
    private JPanel PnlRdo02;
    private JLabel RdoPartido02;
    private JLabel lblContrincante02;
    private JTextField txtfMarcadorCont02;
    private JTextField txtfMarcadorEquipo02;
    private JLabel lblEquipo02;
    private JLabel lblEquipo07;
    private JTextField txtfMarcadorEquipo07;
    private JTextField txtfMarcadorCont07;
    private JLabel lblContrincante07;
    private JTextField txtfMarcadorCont06;
    private JTextField txtfMarcadorEquipo06;
    private JLabel lblEquipo06;
    private JLabel lblContrincante08;
    private JButton LftBttn;
    private JButton RigthBttn;
    private JButton aleatorioCuartos;
    private JButton heuristicoCuartos;
    private JButton guardarCuartos;
    private JLabel lblEquipo08;
    private JTextField txtfMarcadorEquipo08;
    private JTextField txtfMarcadorCont08;
    private JPanel PnlRdo08;
    private JLabel RdoPartido08;
    private JPanel PnlRdo05;
    private JLabel RdoPartido05;
    private JPanel PnlRdo06;
    private JLabel RdoPartido06;
    private JPanel PnlRdo07;
    private JLabel RdoPartido07;
    private JLabel lblContrincante06;
    private JLabel lblContrincante05;
    private JTextField txtfMarcadorCont05;
    private JTextField txtfMarcadorEquipo05;
    private JLabel lblEquipo05;
    private JButton guardarSemi;
    private JButton guardarFinal;
    private JButton aleatorioSemi;
    private JButton heuristicoSemi;
    private JLabel equipoLabels[] = new JLabel[]{lblEquipo01, lblEquipo02, lblEquipo03, lblEquipo04, lblEquipo05, lblEquipo06, lblEquipo07,
            lblEquipo08};

    private JLabel contrincanteLabels[] = new JLabel[]{lblContrincante01, lblContrincante02, lblContrincante03, lblContrincante04, lblContrincante05, lblContrincante06, lblContrincante07,
            lblContrincante08};

    private JTextField marcadoresEquipo[] = new JTextField[]{txtfMarcadorEquipo01, txtfMarcadorEquipo02, txtfMarcadorEquipo03, txtfMarcadorEquipo04, txtfMarcadorEquipo05, txtfMarcadorEquipo06,
            txtfMarcadorEquipo07, txtfMarcadorEquipo08};

    private JTextField marcadoresContrincante[] = new JTextField[]{txtfMarcadorCont01, txtfMarcadorCont02, txtfMarcadorCont03, txtfMarcadorCont04, txtfMarcadorCont05,
            txtfMarcadorCont06, txtfMarcadorCont07, txtfMarcadorCont08};

    private JLabel labelsMarcadores[] = new JLabel[]{RdoPartido01, RdoPartido02, RdoPartido03, RdoPartido04, RdoPartido05, RdoPartido06, RdoPartido07,
            RdoPartido08};

    private JPanel panelsResultado[] = new JPanel[]{PnlRdo01, PnlRdo02, PnlRdo03, PnlRdo04, PnlRdo05, PnlRdo06, PnlRdo07,PnlRdo08};
    private List<Integer> partidos = Arrays.asList(56,60,62);
    private BDMundiales mundiales;
    private Usuario usuarioMomento;
    private List<Seleccion> siguenCuartos ;
    private List<Seleccion> siguenSemi;
    List<Seleccion> siguenFinal;

    private BDPuntosUsuario puntosUsuario;
    public MenuCuartosFinal(Usuario usuarioMomento,List<Seleccion> siguenCuartos) {
        super(usuarioMomento.getUsuario());
        mundiales = new BDMundiales();
        siguenSemi = new ArrayList<>();
        siguenFinal = new ArrayList<>();
        this.usuarioMomento = usuarioMomento;
        this.siguenCuartos = siguenCuartos;

        mundiales.buscarMundialPorUsuario(usuarioMomento).crearItinerarioCuartos(siguenCuartos);
        this.setVisible(true);
        this.add(principalPanel, BorderLayout.CENTER);
        initPanel();
        initLabelsCuartos(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(0));
        comportButtons();
        this.pack();
    }

    private void initLablelsJugado(Mundial mundialUsar,int partido){
        String lblMarcador;
        setPanelesRdo(1);
        for(int i = 0 ; i < 8;i++){
            equipoLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getEquipo().getNombre());
            contrincanteLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getContrincante().getNombre());
            marcadoresEquipo[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            lblMarcador = "Rdo: ( "+ String.valueOf(mundiales.getMundialJugado().getHistorialDePartidos().get(partido).getMarcadorEquipo()) +" - ";
            labelsMarcadores[i].setText(lblMarcador + String.valueOf(mundiales.getMundialJugado().getHistorialDePartidos().get(partido).getMarcadorContrincante())+ " ) +" );
            partido += 1;
        }
    }
    private void setPanelesRdo(int opcion){
        if(opcion == 1){
            for (JPanel panelMarcador:
                    panelsResultado) {
                panelMarcador.enable();

            }
            for (JTextField panelMarcador:
                    marcadoresEquipo) {
                panelMarcador.setEditable(false);

            }
            for (JTextField panelMarcador:
                    marcadoresContrincante) {
                panelMarcador.setEditable(false);

            }
            return;
        }
        for (JPanel panelMarcador:
                panelsResultado) {
            panelMarcador.disable();
        }
    }
    private void initPanel(){
        this.setSize(new Dimension(1500,800));
        this.setMinimumSize(new Dimension(1200,600));
        this.setPreferredSize(new Dimension(1200,600));
        this.setMaximumSize(new Dimension(1200,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initLabelsCuartos(Mundial mundialUsar,int partido){
        for(int i = 0 ; i < 4;i++){
            equipoLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getEquipo().getNombre());
            contrincanteLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getContrincante().getNombre());
            marcadoresEquipo[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
    }

    private void initLabelsSemi(Mundial mundialUsar,int partido){
        mundialUsar.crearItinerarioSemi(siguenSemi);
        for(int i = 4 ; i <= 5;i++){
            equipoLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getEquipo().getNombre());
            contrincanteLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getContrincante().getNombre());
            marcadoresEquipo[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
    }

    private void initLabelsFinal(Mundial mundialUsar,List<Seleccion> siguenFinal){
        mundialUsar.crearItinerarioFinal(siguenFinal);
        int partido = 62;
        for(int i = 6 ; i < 8;i++){
            equipoLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getEquipo().getNombre());
            contrincanteLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getContrincante().getNombre());
            marcadoresEquipo[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
    }


    private void guardarDatosBDCuartos(int partido){
        for (int i = 0; i < 4; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipo(Integer.parseInt(marcadoresEquipo[i].getText()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincante(Integer.parseInt(marcadoresContrincante[i].getText()));
            Seleccion seleccionAgregar = mundiales.buscarMundialPorUsuario(usuarioMomento).comportamientoPartidosOctavosHeuristicos(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido));
            siguenSemi.add(seleccionAgregar);
            partido += 1;
        }

    }
    private void guardarDatosBDSemi(int partido){
        for (int i = 4; i < 6; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipo(Integer.parseInt(marcadoresEquipo[i].getText()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincante(Integer.parseInt(marcadoresContrincante[i].getText()));
            Seleccion seleccionAgregar = mundiales.buscarMundialPorUsuario(usuarioMomento).comportamientoPartidosOctavosYMas(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido));
            siguenFinal.add(seleccionAgregar);
            siguenSemi.remove(seleccionAgregar);
            partido += 1;
        }
    }
    private void guardarDatosBDFinal(){

        mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(63).setMarcadorEquipo(Integer.parseInt(marcadoresEquipo[8].getText()));
        mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(63).setMarcadorContrincante(Integer.parseInt(marcadoresContrincante[8].getText()));
    }
    private void jugarAleatorioCuartos(int partido){
        for (int i = 0; i < 4; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipoAleatorio();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincanteAleatorio();
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
        mundiales.guardar();
    }

    private void jugarHeuristicoCuartos(int partido){
        for (int i = 0; i < 4; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadoresHeuristicos();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
        mundiales.guardar();
    }

    private void jugarAleatorioSemi(int partido){
        for (int i = 0; i < 3; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipoAleatorio();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincanteAleatorio();
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
        mundiales.guardar();
    }

//    mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(62).setEquipo(siguenSemi.get(0));
//        mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(62).setContrincante(siguenSemi.get(0));
    private void jugarHeuristicoSemi(int partido){
        for (int i = 0; i < 3; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadoresHeuristicos();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
        mundiales.guardar();
    }
    private void comportButtons(){
        guardarCuartos.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatosBDCuartos(partidos.get(0));
                initLabelsSemi(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(1));
            }
        });

        guardarSemi.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatosBDSemi(partidos.get(1));
                initLabelsFinal(mundiales.buscarMundialPorUsuario(usuarioMomento),siguenFinal);
            }
        });

        guardarFinal.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatosBDFinal();
            }
        });

        aleatorioCuartos.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarAleatorioCuartos(partidos.get(0));
                initLabelsSemi(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(0));
            }
        });

        aleatorioSemi.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarAleatorioCuartos(partidos.get(1));
                initLabelsSemi(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(1));
            }
        });

        heuristicoCuartos.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarHeuristicoCuartos(partidos.get(0));
                initLabelsSemi(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(0));
            }
        });

        heuristicoSemi.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarHeuristicoCuartos(partidos.get(1));
                initLabelsSemi(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(1));
            }
        });

        LftBttn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame octavos = new MostrarOctavos(usuarioMomento);
                dispose();
            }
        });


    }
}

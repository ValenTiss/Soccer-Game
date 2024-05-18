package com.mycompany.guiquiniela2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostrarOctavos extends JFrame{
    private JPanel panel1;
    private JPanel principalPanel;
    private JTextField txtfMarcadorEquipo01;
    private JTextField txtfMarcadorEquipo02;
    private JTextField txtfMarcadorEquipo03;
    private JTextField txtfMarcadorEquipo05;
    private JTextField txtfMarcadorCont01;
    private JTextField txtfMarcadorCont02;
    private JTextField txtfMarcadorCont03;
    private JTextField txtfMarcadorCont05;
    private JLabel lblEquipo01;
    private JLabel lblEquipo03;
    private JLabel lblEquipo05;
    private JLabel lblContrincante03;
    private JLabel lblContrincante02;
    private JLabel lblContrincante01;
    private JLabel lblEquipo02;
    private JLabel lblContrincante05;
    private JLabel lblEquipo06;
    private JTextField txtfMarcadorEquipo06;
    private JTextField txtfMarcadorCont06;
    private JLabel lblContrincante06;
    private JLabel lblEquipo07;
    private JLabel lblContrincante07;
    private JTextField txtfMarcadorEquipo07;
    private JTextField txtfMarcadorCont07;
    private JPanel PnlRdo01;
    private JLabel RdoPartido01;
    private JPanel PnlRdo02;
    private JLabel RdoPartido02;
    private JPanel PnlRdo03;
    private JLabel RdoPartido03;
    private JPanel PnlRdo05;
    private JLabel RdoPartido05;
    private JPanel PnlRdo06;
    private JLabel RdoPartido06;
    private JPanel PnlRdo07;
    private JLabel RdoPartido07;
    private JTextField txtfMarcadorEquipo04;
    private JTextField txtfMarcadorCont04;
    private JTextField txtfMarcadorEquipo08;
    private JTextField txtfMarcadorCont08;
    private JLabel lblEquipo08;
    private JLabel lblContrincante08;
    private JPanel PnlRdo08;
    private JLabel RdoPartido08;
    private JLabel lblEquipo04;
    private JLabel lblContrincante04;
    private JPanel PnlRdo04;
    private JLabel RdoPartido04;
    private JButton RigthBttn;
    private JButton guardarButton;
    private JButton aleatorioButton;
    private JButton LftBttn;
    private JButton heuristicoButton;
    private Usuario usuarioMomento;

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
    private List<Integer> partidos = Arrays.asList(47);
    private BDMundiales mundiales;
    private List<Seleccion> siguenCuartos;
    private BDPuntosUsuario puntosUsuario;
    public MostrarOctavos(Usuario usuarioMomento) {
        super(usuarioMomento.getUsuario());
        mundiales = new BDMundiales();
        this.usuarioMomento = usuarioMomento;
        puntosUsuario = new BDPuntosUsuario();
        siguenCuartos = new ArrayList<>();
        mundiales.buscarMundialPorUsuario(usuarioMomento).jugarFaseDeGrupoAleatoria();
        mundiales.buscarMundialPorUsuario(usuarioMomento).siguenJugando();
        mundiales.buscarMundialPorUsuario(usuarioMomento).crearItinerarioOctavos();
        this.setVisible(true);
        this.add(principalPanel,BorderLayout.CENTER);
        initPanel();
        if(puntosUsuario.seJugoMundial(15) && (!usuarioMomento.getUsuario().equals("admin")) ){
            initLabelsJugado(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(0));
        }
        else{
            initLablels(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(0));
        }
        comportButtons();
        setVisible(true);
        this.pack();

    }

    private void initPanel(){
        this.setSize(new Dimension(800,400));
    }

    private void initLablels(Mundial mundialUsar,int partido){
        for(int i = 0 ; i < 8;i++){
            equipoLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getEquipo().getNombre());
            contrincanteLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getContrincante().getNombre());
            marcadoresEquipo[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
    }

    private void initLabelsJugado(Mundial mundialUsar,int partido){
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
    private void guardarDatosBD(int partido){
        if (siguenCuartos != null)
            siguenCuartos.clear();
        for (int i = 0; i < 8; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipo(Integer.parseInt(marcadoresEquipo[i].getText()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincante(Integer.parseInt(marcadoresContrincante[i].getText()));
            Seleccion seleccionAgregar = mundiales.buscarMundialPorUsuario(usuarioMomento).comportamientoPartidosOctavosHeuristicos(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido));
            siguenCuartos.add(seleccionAgregar);
            partido += 1;
        }
        mundiales.guardar();
    }

    private void jugarAleatorio(int partido){
        if (siguenCuartos != null)
            siguenCuartos.clear();
        for (int i = 0; i < 8; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipoAleatorio();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincanteAleatorio();
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            Seleccion seleccionAgregar = mundiales.buscarMundialPorUsuario(usuarioMomento).comportamientoPartidosOctavosHeuristicos(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido));
            siguenCuartos.add(seleccionAgregar);
            partido += 1;
        }
        mundiales.guardar();
    }

    private void jugarHeuristico(int partido){
        if (siguenCuartos != null)
            siguenCuartos.clear();
        for (int i = 0; i < 8; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadoresHeuristicos();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            Seleccion seleccionAgregar = mundiales.buscarMundialPorUsuario(usuarioMomento).comportamientoPartidosOctavosHeuristicos(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido));
            siguenCuartos.add(seleccionAgregar);
            partido += 1;
        }
        mundiales.guardar();
    }
    private void comportButtons(){
        guardarButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatosBD(partidos.get(0));
            }
        });


        aleatorioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarAleatorio(partidos.get(0));
            }
        });

        RigthBttn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatosBD(partidos.get(0));
                JFrame octavos = new MenuCuartosFinal(usuarioMomento,siguenCuartos);
                dispose();
            }
        });

        LftBttn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                guardarDatosBD(partidos.get(0));
                JFrame faseDeGrupo = new MostrarQuiniela(usuarioMomento,2);
                dispose();
            }
        });

        heuristicoButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                jugarHeuristico(partidos.get(0));
            }
        });
    }

}

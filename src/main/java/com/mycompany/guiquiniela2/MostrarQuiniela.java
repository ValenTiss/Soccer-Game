package com.mycompany.guiquiniela2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class MostrarQuiniela extends JFrame{
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
    private JButton RigthBttn;
    private JButton heuristicoButton;
    private JButton aleatorioButton;
    private JTextField txtfMarcadorEquipo04;
    private JTextField txtfMarcadorEquipo06;
    private JTextField txtfMarcadorEquipo07;
    private JTextField txtfMarcadorEquipo08;
    private JTextField txtfMarcadorEquipo09;
    private JTextField txtfMarcadorEquipo10;
    private JTextField txtfMarcadorEquipo11;
    private JTextField txtfMarcadorEquipo12;
    private JTextField txtfMarcadorEquipo13;
    private JTextField txtfMarcadorEquipo14;
    private JTextField txtfMarcadorEquipo15;
    private JTextField txtfMarcadorEquipo16;
    private JTextField txtfMarcadorCont04;
    private JTextField txtfMarcadorCont06;
    private JTextField txtfMarcadorCont07;
    private JTextField txtfMarcadorCont08;
    private JTextField txtfMarcadorCont09;
    private JTextField txtfMarcadorCont10;
    private JTextField txtfMarcadorCont11;
    private JTextField txtfMarcadorCont12;
    private JTextField txtfMarcadorCont13;
    private JTextField txtfMarcadorCont14;
    private JTextField txtfMarcadorCont15;
    private JTextField txtfMarcadorCont16;
    private JLabel lblEquipo03;
    private JLabel lblEquipo05;
    private JLabel lblContrincante03;
    private JLabel lblContrincante02;
    private JLabel lblContrincante01;
    private JLabel lblEquipo02;
    private JLabel lblContrincante05;
    private JLabel lblEquipo09;
    private JLabel lblEquipo11;
    private JLabel lblEquipo12;
    private JLabel lblEquipo13;
    private JLabel lblEquipo14;
    private JLabel lblContrincante14;
    private JLabel lblEquipo07;
    private JLabel lblContrincante07;
    private JLabel lblContrincante15;
    private JLabel lblEquipo08;
    private JLabel lblContrincante08;
    private JLabel lblEquipo16;
    private JLabel lblContrincante16;
    private JLabel lblEquipo04;
    private JLabel lblContrincante04;
    private JLabel lblContrincante12;
    private JLabel lblEquipo10;
    private JLabel lblContrincante09;
    private JLabel lblContrincante10;
    private JLabel lblContrincante11;
    private JLabel lblContrincante13;
    private JLabel lblEquipo06;
    private JLabel lblContrincante06;
    private JButton guardarButton;
    private JLabel lblEquipo15;
    private JLabel RdoPartido01;
    private JLabel RdoPartido02;
    private JLabel RdoPartido03;
    private JLabel RdoPartido04;
    private JLabel RdoPartido05;
    private JLabel RdoPartido07;
    private JLabel RdoPartido06;
    private JLabel RdoPartido08;
    private JLabel RdoPartido09;
    private JLabel RdoPartido10;
    private JLabel RdoPartido11;
    private JLabel RdoPartido12;
    private JLabel RdoPartido13;
    private JLabel RdoPartido14;
    private JLabel RdoPartido16;
    private JLabel RdoPartido15;
    private JPanel PnlRdo01;
    private JPanel PnlRdo02;
    private JPanel PnlRdo03;
    private JPanel PnlRdo04;
    private JPanel PnlRdo05;
    private JPanel PnlRdo06;
    private JPanel PnlRdo07;
    private JPanel PnlRdo08;
    private JPanel PnlRdo09;
    private JPanel PnlRdo10;
    private JPanel PnlRdo11;
    private JPanel PnlRdo12;
    private JPanel PnlRdo13;
    private JPanel PnlRdo14;
    private JPanel PnlRdo15;
    private JPanel PnlRdo16;
    private JButton LftBttn;

    private int SIZE = 50;
    private JLabel equipoLabels[] = new JLabel[]{lblEquipo01, lblEquipo02, lblEquipo03, lblEquipo04, lblEquipo05, lblEquipo06, lblEquipo07,
                                                lblEquipo08, lblEquipo09, lblEquipo10, lblEquipo11, lblEquipo12, lblEquipo13, lblEquipo14,
                                                lblEquipo15, lblEquipo16};

    private JLabel contrincanteLabels[] = new JLabel[]{lblContrincante01, lblContrincante02, lblContrincante03, lblContrincante04, lblContrincante05, lblContrincante06, lblContrincante07,
            lblContrincante08, lblContrincante09, lblContrincante10, lblContrincante11, lblContrincante12, lblContrincante13, lblContrincante14,
            lblContrincante15, lblContrincante16};

    private JTextField marcadoresEquipo[] = new JTextField[]{txtfMarcadorEquipo01, txtfMarcadorEquipo02, txtfMarcadorEquipo03, txtfMarcadorEquipo04, txtfMarcadorEquipo05, txtfMarcadorEquipo06,
            txtfMarcadorEquipo07, txtfMarcadorEquipo08, txtfMarcadorEquipo09, txtfMarcadorEquipo10, txtfMarcadorEquipo11, txtfMarcadorEquipo12,
            txtfMarcadorEquipo13, txtfMarcadorEquipo14, txtfMarcadorEquipo15, txtfMarcadorEquipo16};

    private JTextField marcadoresContrincante[] = new JTextField[]{txtfMarcadorCont01, txtfMarcadorCont02, txtfMarcadorCont03, txtfMarcadorCont04, txtfMarcadorCont05,
            txtfMarcadorCont06, txtfMarcadorCont07, txtfMarcadorCont08, txtfMarcadorCont09, txtfMarcadorCont10,
            txtfMarcadorCont11, txtfMarcadorCont12, txtfMarcadorCont13, txtfMarcadorCont14, txtfMarcadorCont15, txtfMarcadorCont16};

    private JLabel labelsMarcadores[] = new JLabel[]{RdoPartido01, RdoPartido02, RdoPartido03, RdoPartido04, RdoPartido05, RdoPartido06, RdoPartido07,
                                                    RdoPartido08, RdoPartido09, RdoPartido10, RdoPartido11, RdoPartido12, RdoPartido13, RdoPartido14,
                                                    RdoPartido15, RdoPartido16};

    private JPanel panelsResultado[] = new JPanel[]{PnlRdo01, PnlRdo02, PnlRdo03, PnlRdo04, PnlRdo05, PnlRdo06, PnlRdo07, PnlRdo08, PnlRdo09, PnlRdo10,
                                                    PnlRdo11, PnlRdo12, PnlRdo13, PnlRdo14, PnlRdo15, PnlRdo16};
   private BDMundiales mundiales;
   private Usuario usuarioMomento;

   private BDPuntosUsuario puntosUsuario;

   private List<Integer> partidos = Arrays.asList(0,15,31);

   private int cualesPartidos;


    public MostrarQuiniela(Usuario usuarioMomento,int cualesPartidos) {
        super(usuarioMomento.getUsuario());
        mundiales = new BDMundiales();
        puntosUsuario = new BDPuntosUsuario();
        this.usuarioMomento = usuarioMomento;
        initPanel();
        this.cualesPartidos = cualesPartidos;
        this.getContentPane().add(principalPanel);
        this.setVisible(true);
        if(puntosUsuario.seJugoMundial(15) && (!usuarioMomento.getUsuario().equals("admin")) ){
            initLabelsJugado(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(cualesPartidos));
        }
        else{
            initLablels(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(cualesPartidos));
        }

        comportButtons();
        this.pack();

    }

    private Mundial mundialUsar(Usuario usuarioAnalizar){
        Mundial mundial = mundiales.buscarMundialPorUsuario(usuarioAnalizar);
        if(mundial.equals(null)){
             Mundial nuevoMundial = mundiales.generarMundial(usuarioAnalizar);
            return nuevoMundial;
        }
        return mundial;
    }

    private void initPanel(){
        this.setMinimumSize(new Dimension(1200 ,600));
        this.setPreferredSize(new Dimension(1200 ,600));
        this.setMaximumSize(new Dimension(1200 ,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initLablels(Mundial mundialUsar,int partido){
        for(int i = 0 ; i < 16;i++){
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
        for(int i = 0 ; i < 16;i++){
            equipoLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getEquipo().getNombre());
            contrincanteLabels[i].setText(mundialUsar.getHistorialDePartidos().get(partido).getContrincante().getNombre());
            marcadoresEquipo[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            marcadoresContrincante[i].setText(String.valueOf(mundialUsar.getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            lblMarcador = "Rdo: ( "+ String.valueOf(mundiales.getMundialJugado().getHistorialDePartidos().get(partido).getMarcadorEquipo()) +" - ";
            labelsMarcadores[i].setText(lblMarcador + String.valueOf(mundiales.getMundialJugado().getHistorialDePartidos().get(partido).getMarcadorContrincante())+ " ) +" );
            partido += 1;
        }
    }

    private void esAdmin(){

    }

    private void seJugoMundial(){
        
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
        for (int i = 0; i < 16; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipo(Integer.parseInt(marcadoresEquipo[i].getText()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincante(Integer.parseInt(marcadoresContrincante[i].getText()));
            partido += 1;
        }
        mundiales.guardar();
    }

    private void jugarAleatorio(int partido){
        for (int i = 0; i < 16; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipoAleatorio();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincanteAleatorio();
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
            partido += 1;
        }
        mundiales.guardar();
    }

    private void jugarHeuristico(int partido){
        for (int i = 0; i < 16; i++) {
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorEquipoAleatorio();
            marcadoresEquipo[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorEquipo()));
            mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).setMarcadorContrincanteAleatorio();
            marcadoresContrincante[i].setText(String.valueOf(mundiales.buscarMundialPorUsuario(usuarioMomento).getHistorialDePartidos().get(partido).getMarcadorContrincante()));
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

                guardarDatosBD(partidos.get(cualesPartidos));
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
                jugarAleatorio(partidos.get(cualesPartidos));
                guardarDatosBD(partidos.get(cualesPartidos));
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
                jugarHeuristico(partidos.get(cualesPartidos));
                guardarDatosBD(partidos.get(cualesPartidos));
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
                switch(cualesPartidos)
                {
                    case 0:
                    case 1:
                    {
                        guardarDatosBD(partidos.get(cualesPartidos));
                        cualesPartidos += 1;
                        initLablels(mundiales.buscarMundialPorUsuario(usuarioMomento),partidos.get(cualesPartidos));
                        break;
                    }
                    case 2:
                    {
                        JFrame octavos = new MostrarOctavos(usuarioMomento);
                        dispose();
                        break;
                    }
                }
            }
        });

        LftBttn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            public void actionPerformed(ActionEvent e) {
                switch (cualesPartidos) {
                    case 1:
                    case 2:
                    case 3:
                    {
                        guardarDatosBD(partidos.get(cualesPartidos));
                        cualesPartidos -= 1;
                        initLablels(mundiales.buscarMundialPorUsuario(usuarioMomento), partidos.get(cualesPartidos));
                        break;
                    }
                }
            }
        });
    }

    public void setCualesPartidos(int cualesPartidos) {
        this.cualesPartidos = cualesPartidos;
    }
}


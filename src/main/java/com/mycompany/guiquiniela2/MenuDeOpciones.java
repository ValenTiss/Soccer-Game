package com.mycompany.guiquiniela2;

import javax.swing.*;
import java.awt.*;

public class MenuDeOpciones extends JFrame{
    private JPanel panel1;
    private JButton button1;

    private BDMundiales mundiales;
    private Usuario usuarioMomento;
    private CardLayout cLayout ;
    private MostrarQuiniela faseDeGrupo;
    private JPanel mainPanel;
    private JPanel octavos;

    public MenuDeOpciones(Usuario usuarioMomento) {
        //super(usuarioMomento.getUsuario());
        mundiales = new BDMundiales();
        this.usuarioMomento = usuarioMomento;
        initPanel();
        this.setContentPane(panel1);
//        comportButtons();
        this.pack();
    }

    private void initPanel(){
        this.setMinimumSize(new Dimension(1200 ,600));
        this.setPreferredSize(new Dimension(1200 ,600));
        this.setMaximumSize(new Dimension(1200 ,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cLayout = new CardLayout();
        mainPanel = new JPanel();
//        faseDeGrupo new MostrarQuiniela(mundiales.buscarMundialPorUsuario(usuarioMomento));
        octavos = new JPanel();
        mainPanel.add("faseGrupos",faseDeGrupo);
        setLayout(new BorderLayout());
        add(faseDeGrupo,BorderLayout.CENTER);
        setVisible(true);
        mainPanel.setLayout(cLayout);
    }
}

package com.mycompany.guiquiniela2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginCenter extends JFrame{
    private JPanel panel1;
    private JPanel loginPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginBttn;
    private JLabel imgLeft;
    private JLabel imgRight;
    private JLabel noEntroLbl;
    private JButton registerButton;
    BDUsuarios usuarios;


    loginCenter(String title){
        super(title);
        usuarios = new BDUsuarios();
        this.setVisible(true);
        this.setMinimumSize(new Dimension(480,340));
        this.setPreferredSize(new Dimension(480,340));
        this.setMaximumSize(new Dimension(480,340));
        this.setContentPane(loginPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        loginBttn.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarios.buscarUsuario(textField1.getText(), passwordField1.getText())){
                    MostrarQuiniela ventana = new MostrarQuiniela(usuarios.getSpecificUser(textField1.getText(), passwordField1.getText()),0);
                    setVisible(false);
                }else
                {
                    noEntroLbl.setText("");
                    noEntroLbl.setText("Usuario o contraseña incorrecta,intente nuevamente.");
                    passwordField1.setText("");
                }

            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario nuevoUsuario = usuarios.crearUsuario(textField1.getText(), passwordField1.getText());
                if(nuevoUsuario == null){
                    noEntroLbl.setText("");
                    noEntroLbl.setText("Este usuario ya existe,ingrese otro nombre de usuario para registrarse.");
                    passwordField1.setText("");
                }else
                {
                    textField1.setText("");
                    passwordField1.setText("");
                    noEntroLbl.setText("Nuevo usuario creado con exito,ingrese sus credenciales para logearse.");
                    usuarios.guardar();
                }
            }
        });
        this.pack();

    }
}

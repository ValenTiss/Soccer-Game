/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guiquiniela2;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author valentin
 */
public class BDUsuarios implements Serializable{
    
    private final String FILE_PATH = "usuarios.dat";
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public BDUsuarios() {
        restaurar();
    }

    public void guardar(){
        FileManager.writeObject(this, FILE_PATH);
    }
    
    public void restaurar(){
        BDUsuarios bd = (BDUsuarios)FileManager.readObject(FILE_PATH);
        this.usuarios = bd.usuarios;
    }

    public boolean buscarUsuario(String user, String psw){
        for (Usuario usuario : usuarios) {
            if ((usuario.getUsuario().equals(user))  && (usuario.getPassword().equals(psw)))
                return true;
        }
        return false;
    }

    public boolean validarNmbUsuario(String user){
        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(user))
                return true;
        }
        return false;
    }
    public Usuario crearUsuario(String nombreUsuario,String password){
        boolean existeUsuario = validarNmbUsuario(nombreUsuario);
        if(existeUsuario)
            return null;
        Usuario nuevoUsuario = new Usuario(nombreUsuario,password);
        usuarios.add(nuevoUsuario);
        guardar();
        return usuarios.get(usuarios.size()-1);
    }

    public Usuario getSpecificUser(String user, String psw){
        for (Usuario usuario : usuarios) {
            if ((usuario.getUsuario().equals(user))  && (usuario.getPassword().equals(psw)))
                return usuario;
        }
        return null;
    }
    
}

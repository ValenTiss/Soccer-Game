package com.mycompany.guiquiniela2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDMundiales implements Serializable {
    BDUsuarios BUsuarios = new BDUsuarios();
    Map<Usuario,Mundial> usuarioApuestas = new HashMap<Usuario,Mundial>();
    private final String FILE_PATH = "mundiales.dat";

    public BDMundiales() {
        restaurar();
    }

    public void guardar(){
        FileManager.writeObject(this, FILE_PATH);
    }
    public void restaurar(){
        BDMundiales bd = (BDMundiales)FileManager.readObject(FILE_PATH);
        this.usuarioApuestas = bd.usuarioApuestas;
    }

    public Mundial buscarMundialPorUsuario(Usuario user){
        for (Map.Entry<Usuario,Mundial> usr:
             usuarioApuestas.entrySet()) {
            if((usr.getKey().getUsuario().equals(user.getUsuario())) &&(usr.getKey().getPassword().equals(user.getPassword())))
                return usr.getValue();
        }
        return null;
    }
    public Mundial generarMundial(Usuario usuarioAgregar){
        usuarioApuestas.put(usuarioAgregar,new Mundial());
        guardar();
        return buscarMundialPorUsuario(usuarioAgregar);
    }

    public Mundial getMundialJugado(){
        for (Map.Entry<Usuario,Mundial> usr:
                usuarioApuestas.entrySet()) {
            if((usr.getKey().getUsuario().equals("admin") &&(usr.getKey().getPassword().equals("admin"))));
                return usr.getValue();
        }
        return null;
    }

    public Mundial nuevoMundial(Usuario user){
        for (Map.Entry<Usuario,Mundial> usr:
                usuarioApuestas.entrySet()) {
            if((usr.getKey().getUsuario().equals(user.getUsuario())) &&(usr.getKey().getPassword().equals(user.getPassword())))
                return usr.setValue(new Mundial());
        }
        return null;
    }
}

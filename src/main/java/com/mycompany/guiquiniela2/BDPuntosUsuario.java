package com.mycompany.guiquiniela2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BDPuntosUsuario implements Serializable {
    BDMundiales bdMundiales = new BDMundiales() ;
    BDUsuarios bdUsuarios = new BDUsuarios();
    Mundial mundialStd;
    Map<Usuario,Elo> usuariosPuntaje = new HashMap<Usuario,Elo>();
    private final String FILE_PATH = "ranking.dat";

    public BDPuntosUsuario() {
        mundialStd = bdMundiales.buscarMundialPorUsuario(bdUsuarios.getSpecificUser("admin","admin"));
        restaurar();
    }

    public void guardar(){
        FileManager.writeObject(this, FILE_PATH);
    }
    public void restaurar(){
        BDPuntosUsuario bd = (BDPuntosUsuario)FileManager.readObject(FILE_PATH);
        this.usuariosPuntaje = bd.usuariosPuntaje;
    }

    public Map<Usuario, Elo> getUsuariosPuntaje() {
        return usuariosPuntaje;
    }

    public boolean seJugoMundial(int partido){
        if((mundialStd.getHistorialDePartidos().get(partido+1).getMarcadorEquipo() != -1) &&
                (mundialStd.getHistorialDePartidos().get(partido+1).getMarcadorContrincante() != -1))
            return true;
        return false;
    }
}

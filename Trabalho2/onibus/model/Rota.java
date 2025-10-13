/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onibus.model;

import java.util.ArrayList;

/**
 *
 * @author eduardo
 */
public class Rota {
    private final String origem;
    private final String destino;
    private ArrayList<Trecho>   trechos;

    public Rota(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.trechos = new ArrayList();
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }
    
    public void addTrecho(Trecho trecho){
        if(trechos.isEmpty())
            trechos.add(trecho);
        else {
            Trecho ultimo = trechos.get(trechos.size()-1);
            if(ultimo.getFim().equals(trecho.getInicio()))
                trechos.add(trecho);
        }
    }

    public ArrayList<Trecho> getTrechos() {
        return trechos;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onibus.model;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author eduardo
 */
public class Viagem {
    private class Lugar {
        private final int numero;
        private Passageiro passageiro;

        public Lugar(int numero) {
            this.numero = numero;
            this.passageiro = null;
        }

        public int getNumero() {
            return numero;
        }

        public Passageiro getPassageiro() {
            return passageiro;
        }

        public void setPassageiro(Passageiro passageiro) {
            this.passageiro = passageiro;
        }
        
        public boolean ocupado(){
            return passageiro != null;
        }
    }
    
    private Onibus onibus;
    private Motorista motorista;
    private final Rota rota;
    private final Date Data;
    private final HashMap<Integer,Lugar> lugares;

    public Viagem(Rota rota, Date Data) {
        this.rota = rota;
        this.Data = Data;
        this.lugares = new HashMap();
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Rota getRota() {
        return rota;
    }

    public Date getData() {
        return Data;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
        this.lugares.clear();
        for(int i=1; i < this.onibus.getQuantidade_lugares(); i++){
            this.lugares.put(i,new Lugar(i));
        }
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    
    public void addPassageiro(int lugar, Passageiro passageiro){
        Lugar l = this.lugares.get(lugar);
        if(l != null && l.getPassageiro() == null){
            l.setPassageiro(passageiro);
        }
    }
    
    public Passageiro getPassageiro(int lugar){
        Lugar l = this.lugares.get(lugar);
        if(l != null)
            return l.getPassageiro();
        return null;
    }
}

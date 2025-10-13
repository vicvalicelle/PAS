/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onibus.model;

/**
 *
 * @author eduardo
 */
public class Passageiro extends Pessoa{
    private String email;

    public Passageiro(String email, String nome, String CPF) {
        super(nome, CPF);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}

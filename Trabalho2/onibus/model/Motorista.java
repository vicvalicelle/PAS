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
public class Motorista extends Pessoa{
    private final int idade;
    private float valor_diaria;

    public Motorista(int idade, String nome, String CPF) {
        super(nome, CPF);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public float getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(float valor_diaria) {
        this.valor_diaria = valor_diaria;
    }
    
    
}

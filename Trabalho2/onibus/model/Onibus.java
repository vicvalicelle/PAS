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
public class Onibus {
    public enum Classe { ECONOMICA, EXECUTIVA, LUXO };
    private final String placa;
    private final int quantidade_lugares;
    private final Classe classe;
    private float custo;

    public Onibus(String placa, int quantidade_lugares, Classe classe, float custo) {
        this.placa = placa;
        this.quantidade_lugares = quantidade_lugares;
        this.classe = classe;
        this.custo = custo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getQuantidade_lugares() {
        return quantidade_lugares;
    }

    public Classe getClasse() {
        return classe;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }
    
    
}

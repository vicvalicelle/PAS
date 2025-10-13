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
public class Trecho {
    
    public class Duracao {
        private final int horas;
        private final int minutos;
        
        private Duracao(int horas, int minutos){
          this.horas = horas;
          this.minutos = minutos;
        } 

        public int getHoras() {
            return horas;
        }

        public int getMinutos() {
            return minutos;
        }
        
    } 
    
    private final String inicio;
    private final String fim;
    private Duracao duracao;

    public Trecho(String inicio, String fim, Duracao duracao) {
        this.inicio = inicio;
        this.fim = fim;
        this.duracao = duracao;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFim() {
        return fim;
    }

    public Duracao getDuracao() {
        return duracao;
    }

    public void setDuracao(int horas, int minutos) {
        this.duracao = new Duracao(horas,minutos);
    }
    
}

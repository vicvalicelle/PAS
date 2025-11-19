package leilao;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random gerador = new Random();
        
        double valorIdeal = 100 + gerador.nextInt(401); 
        Produto pista = new Produto("Pista do Tubarão HotWheels", valorIdeal, 10);

        System.out.println("INÍCIO DO LEILÃO");
        System.out.println("Produto: Pista do Tubarão HotWheels (Valor Ideal estimado: " + valorIdeal + ")");

        for (int i = 1; i <= 10; i++) {
            double teto = 200 + gerador.nextInt(801);
            
            Comprador c = new Comprador("Comprador " + i, pista, teto);
            c.start();
        }
    }
}
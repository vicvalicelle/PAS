package leilao;

import java.util.Random;

public class Comprador extends Thread {
    private String nome;
    private Produto produto;
    private double valorMaximo;
    private double ultimoLance;
    private Random random;
    private boolean ativo;

    public Comprador(String nome, Produto produto, double valorMaximo) {
        this.nome = nome;
        this.produto = produto;
        this.valorMaximo = valorMaximo;
        this.ultimoLance = 0;
        this.random = new Random();
        this.ativo = true;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        System.out.println(this.nome + " entrou no leilão com teto de R$ " + valorMaximo);

        while (ativo && !produto.isVendido()) {
            try {
                Thread.sleep(30000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (produto.isVendido()) break;

            double lanceAtualNoProduto = produto.getMaiorLanceAtual();


            if (lanceAtualNoProduto > valorMaximo) {
                desistir();
            } else {
                boolean vaiDarLance = random.nextBoolean();

                if (vaiDarLance) {
                    double novoLance = lanceAtualNoProduto + 10;
                    
                    if (novoLance <= valorMaximo) {
                        this.ultimoLance = novoLance;
                        produto.realizarLance(this, novoLance);
                    } else {
                        desistir();
                    }
                }
            }
        }
    }

    private void desistir() {
        this.ativo = false;
        produto.sairDoLeilao(this);
    }
}

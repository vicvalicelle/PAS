package leilao;

public class Produto {
    private String nome;
    private double valorIdeal;
    private boolean vendido;
    private double maiorLanceAtual;
    private Comprador compradorMaiorLance;
    private int compradoresAtivos;

    public Produto(String nome, double valorIdeal, int totalParticipantes) {
        this.nome = nome;
        this.valorIdeal = valorIdeal;
        this.vendido = false;
        this.maiorLanceAtual = valorIdeal;
        this.compradoresAtivos = totalParticipantes;
    }

    public synchronized double getMaiorLanceAtual() {
        return maiorLanceAtual;
    }

    public synchronized boolean isVendido() {
        return vendido;
    }

    public synchronized void realizarLance(Comprador comprador, double valor) {
        if (vendido) return;

        if (valor > maiorLanceAtual) {
            maiorLanceAtual = valor;
            compradorMaiorLance = comprador;
            System.out.println("-> LANCE ACEITO: " + comprador.getNome() + " ofereceu R$ " + valor);
        }
    }

    public synchronized void sairDoLeilao(Comprador c) {
        compradoresAtivos--;
        System.out.println(c.getNome() + " saiu. (Restam: " + compradoresAtivos + ")");

        if (compradoresAtivos == 1 && !vendido) {
            vendido = true;
            System.out.println("\nLEILÃO ENCERRADO!");
            if (compradorMaiorLance != null) {
                System.out.println("Produto VENDIDO para " + compradorMaiorLance.getNome() + " pelo valor de R$ " + maiorLanceAtual);
            } else {
                System.out.println("O produto não recebeu lances válidos.");
            }
        }
    }
}

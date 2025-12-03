package restaurante;

import java.util.ArrayList;

public class Cardapio {
    private final String nome;
    private final ArrayList<Item>    itens = new ArrayList();
 
    public Cardapio(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void addItem(Item it){
        itens.add(it);
    }
    public Item getItem(int i){
        return itens.get(i);
    }
    public int getNumItens(){
        return itens.size();
    }
    public void imprimirCardapio() {
        for (Item i : itens) {
            System.out.println(i.getNome() + " - R$ " + i.getPreco());
        }
    }
}

package restaurante;

import java.util.ArrayList;

// Objetos formado pelo conjunto de outros objetos onde
// o objeto composto pode ser tratado de forma igual as
// suas partes.

// O tamanho da hierarquia gerava redundância de código
// dificultando o tratamento do todo pelas suas partes
// como não ser possível inserir um item isolado no megaCombo.

// O conjunto de objetos de uma classe (item) agora compõem uma estrutura (combo composite).
// Essa estrutura pode ser tratada como um objeto dessa classe.

public class ComboComposite extends Item {
    private final ArrayList<Item> itens = new ArrayList();
    
    public ComboComposite(int codigo, String nome){
        super(codigo,nome,0.0);
    }
    public void addItem(Item it){
        itens.add(it);
    }
    public void removeItem(Item it) {
        itens.remove(it);
    }    
    public Item getItem(int i){
        return itens.get(i);
    }
    public int numItens(){
        return itens.size();
    }
    public float getPreco(){
        float total=0;
        for(Item i:itens){
            total += i.getPreco();
        }
        return total;
    }
}

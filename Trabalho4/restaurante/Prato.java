package restaurante;

public class Prato extends Item{

    private final int tempoPreparo;
    private final String receita;

    public Prato(int codigo, String nome,float preco, String receita, int tempoPreparo) {
        super(codigo,nome,preco);
        this.tempoPreparo = tempoPreparo;
        this.receita = receita;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public String getReceita(){
        return receita;
    }

}

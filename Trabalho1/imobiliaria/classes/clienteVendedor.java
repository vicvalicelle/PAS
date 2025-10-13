package imobiliaria.classes;

import java.util.ArrayList;
import java.util.List;

public class clienteVendedor extends pessoa {
    private List<imovel> imoveis;

    public clienteVendedor(String cpf, String nome, String endereco, String telefone, String email, List<imovel> imoveis) {
        super(cpf, nome, endereco, telefone, email);
        this.imoveis = new ArrayList<>();
    }

    public void adicionarImovel(imovel imovel) {
        this.imoveis.add(imovel);
    }

    public List<imovel> getImoveis() {
        return imoveis;
    }
}

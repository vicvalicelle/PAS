package imobiliaria.classes;

import imobiliaria.enumeraveis.TipoImovel;

public class clienteComprador extends pessoa {
    private String cidadeDesejada;
    private String bairroDesejado;
    private TipoImovel tipoImovelDesejado;
    private int quartosDesejados;

    public clienteComprador(String cpf, String nome, String endereco, String telefone, String email, String cidade, String bairro, TipoImovel tipo, int quartos) {
        super(cpf, nome, endereco, telefone, email);
        this.cidadeDesejada = cidade;
        this.bairroDesejado = bairro;
        this.tipoImovelDesejado = tipo;
        this.quartosDesejados = quartos;
    }

    public String getCidadeDesejada() {
        return cidadeDesejada;
    }

    public void setCidadeDesejada(String cidadeDesejada) {
        this.cidadeDesejada = cidadeDesejada;
    }

    public String getBairroDesejado() {
        return bairroDesejado;
    }

    public void setBairroDesejado(String bairroDesejado) {
        this.bairroDesejado = bairroDesejado;
    }

    public TipoImovel getTipoImovelDesejado() {
        return tipoImovelDesejado;
    }

    public void setTipoImovelDesejado(TipoImovel tipoImovelDesejado) {
        this.tipoImovelDesejado = tipoImovelDesejado;
    }

    public int getQuartosDesejados() {
        return quartosDesejados;
    }

    public void setQuartosDesejados(int quartosDesejados) {
        this.quartosDesejados = quartosDesejados;
    }
}

package imobiliaria.classes;

import imobiliaria.enumeraveis.ModalidadeImovel;
import imobiliaria.enumeraveis.StatusImovel;
import imobiliaria.enumeraveis.TipoImovel;

public class imovel {
    private String codigo;
    private clienteVendedor proprietario;
    private String descricao;
    private String endereco;
    private String bairro;
    private String cidade;
    private TipoImovel tipo; 
    private ModalidadeImovel modalidade;
    private int quartos;
    private double valor;
    private StatusImovel status;

    private clienteComprador clienteComprador;

    public imovel(String codigo, clienteVendedor proprietario, String descricao, String endereco, String bairro, String cidade, TipoImovel tipo, ModalidadeImovel modalidade, int quartos, double valor, StatusImovel status) {
        this.codigo = codigo;
        this.proprietario = proprietario;
        this.descricao = descricao;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.tipo = tipo;
        this.modalidade = modalidade;
        this.quartos = quartos;
        this.valor = valor;
        this.status = StatusImovel.DISPONIVEL;
        this.clienteComprador = null;
    }

    public void registrarVenda(clienteComprador comprador) {
        this.clienteComprador = comprador;
        this.status = StatusImovel.VENDIDO;
    }

    public void registrarAluguel(clienteComprador locatario) {
        this.clienteComprador = locatario;
        this.status = StatusImovel.ALUGADO;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public clienteVendedor getProprietario() {
        return proprietario;
    }

    public void setProprietario(clienteVendedor proprietario) {
        this.proprietario = proprietario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public TipoImovel getTipo() {
    return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }

    public ModalidadeImovel getModalidade() {
        return modalidade;
    }

    public void setModalidade(ModalidadeImovel modalidade) {
        this.modalidade = modalidade;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public clienteComprador getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(clienteComprador clienteComprador) {
        this.clienteComprador = clienteComprador;
    }

    public StatusImovel getStatusImovel(){
        return status;
    }
    
    public void setStatusImovel(StatusImovel status){
        this.status = status;
    }
}

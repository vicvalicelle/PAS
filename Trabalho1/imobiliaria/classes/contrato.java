package imobiliaria.classes;
import java.time.LocalDate;

public class contrato {
    private long id;
    private imovel imovel;
    private clienteVendedor vendedor;
    private clienteComprador comprador;
    private corretor corretor;
    private LocalDate data;
    private double valorFinal;

    public contrato(long id, imovel imovel, clienteVendedor vendedor, clienteComprador comprador, corretor corretor, double valorFinal) {
        this.id = id;
        this.imovel = imovel;
        this.vendedor = vendedor;
        this.comprador = comprador;
        this.corretor = corretor;
        this.data = LocalDate.now();
        this.valorFinal = valorFinal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public imovel getImovel() {
        return imovel;
    }

    public void setImovel(imovel imovel) {
        this.imovel = imovel;
    }

    public clienteVendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(clienteVendedor vendedor) {
        this.vendedor = vendedor;
    }

    public clienteComprador getComprador() {
        return comprador;
    }

    public void setComprador(clienteComprador comprador) {
        this.comprador = comprador;
    }

    public corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(corretor corretor) {
        this.corretor = corretor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

}

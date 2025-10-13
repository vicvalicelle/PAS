package imobiliaria.classes;

public class corretor extends pessoa {
    private String matricula;
    private double comissao;

    public corretor(String cpf, String nome, String endereco, String telefone, String email, String matricula, double comissao) {
        super(cpf, nome, endereco, telefone, email);
        this.matricula = matricula;
        this.comissao = comissao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}

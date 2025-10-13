package onibus.control;

import java.util.ArrayList;
import java.util.Date;
import onibus.exceptions.*;
import onibus.model.*;

public class Controller {

    private final ArrayList<Onibus> listaOnibus = new ArrayList<>();
    private final ArrayList<Motorista> listaMotoristas = new ArrayList<>();
    private final ArrayList<Passageiro> listaPassageiros = new ArrayList<>();
    private final ArrayList<Rota> listaRotas = new ArrayList<>();
    private final ArrayList<Viagem> listaViagens = new ArrayList<>();

    public void cadastrarOnibus(String placa, int qtdLugares, Onibus.Classe classe, float custo) throws CadastroDuplicadoException {
        if (buscarOnibusPorPlaca(placa) != null) {
            throw new CadastroDuplicadoException("Já existe um ônibus cadastrado com a placa: " + placa);
        }
        Onibus novoOnibus = new Onibus(placa, qtdLugares, classe, custo);
        listaOnibus.add(novoOnibus);
    }

    public void cadastrarMotorista(int idade, String nome, String cpf, float valorDiaria) throws CadastroDuplicadoException {
        if (buscarPessoaPorCPF(cpf) != null) {
            throw new CadastroDuplicadoException("Já existe uma pessoa motorista com o CPF: " + cpf);
        }
        Motorista novoMotorista = new Motorista(idade, nome, cpf);
        novoMotorista.setValor_diaria(valorDiaria);
        listaMotoristas.add(novoMotorista);
    }

    public void cadastrarPassageiro(String email, String nome, String cpf) throws CadastroDuplicadoException {
        if (buscarPessoaPorCPF(cpf) != null) {
            throw new CadastroDuplicadoException("Já existe uma pessoa passageiro com o CPF: " + cpf);
        }
        Passageiro novoPassageiro = new Passageiro(email, nome, cpf);
        listaPassageiros.add(novoPassageiro);
    }

    public void cadastrarRota(String origem, String destino, ArrayList<Trecho> trechos) throws RotaInvalidaException {
        if (trechos == null || trechos.isEmpty()) {
            throw new RotaInvalidaException("A lista de trechos não pode ser vazia.");
        }
        if (!trechos.get(0).getInicio().equalsIgnoreCase(origem) || !trechos.get(trechos.size() - 1).getFim().equalsIgnoreCase(destino)) {
            throw new RotaInvalidaException("A origem ou destino da rota não corresponde ao início ou fim do trecho");
        }

        Rota novaRota = new Rota(origem, destino);
        for (Trecho t : trechos) {
            novaRota.addTrecho(t);
        }

        if (novaRota.getTrechos().size() != trechos.size()) {
             throw new RotaInvalidaException("Erro de conexão: um ou mais trechos não são sequenciais.");
        }

        listaRotas.add(novaRota);
    }
    
    public void cadastrarViagem(Rota rota, Date data, Onibus onibus, Motorista motorista) {
        Viagem novaViagem = new Viagem(rota, data);
        novaViagem.setOnibus(onibus);
        novaViagem.setMotorista(motorista);
        listaViagens.add(novaViagem);
    }

    public Onibus buscarOnibusPorPlaca(String placa) {
        for (Onibus onibus : listaOnibus) {
            if (onibus.getPlaca().equalsIgnoreCase(placa)) {
                return onibus;
            }
        }
        return null;
    }

    public Pessoa buscarPessoaPorCPF(String cpf) {
        for (Motorista motorista : listaMotoristas) {
            if (motorista.getCPF().equals(cpf)) {
                return motorista;
            }
        }
        for (Passageiro passageiro : listaPassageiros) {
            if (passageiro.getCPF().equals(cpf)) {
                return passageiro;
            }
        }
        return null;
    }
    
    public Motorista buscarMotoristaPorCPF(String cpf) {
        for (Motorista motorista : listaMotoristas) {
            if (motorista.getCPF().equals(cpf)) {
                return motorista;
            }
        }
        return null;
    }
    
    public Rota buscarRota(String origem, String destino) {
        for (Rota rota : listaRotas) {
            if (rota.getOrigem().equalsIgnoreCase(origem) && rota.getDestino().equalsIgnoreCase(destino)) {
                return rota;
            }
        }
        return null;
    }

    public ArrayList<Onibus> getListaOnibus() {
        return listaOnibus;
    }

    public ArrayList<Motorista> getListaMotoristas() {
        return listaMotoristas;
    }
    
    public ArrayList<Passageiro> getListaPassageiros() {
        return listaPassageiros;
    }

    public ArrayList<Rota> getListaRotas() {
        return listaRotas;
    }
    
    public ArrayList<Viagem> getListaViagens() {
        return listaViagens;
    }
}
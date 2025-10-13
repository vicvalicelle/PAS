package onibus.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import onibus.control.Controller;
import onibus.exceptions.*;
import onibus.model.*;

public class SistemaView {
    private final Controller controlador;
    private final Scanner scanner;

    public SistemaView(Controller controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Sistema de Venda de Passagens ---");
            System.out.println("1. Cadastrar Ônibus");
            System.out.println("2. Cadastrar Motorista");
            System.out.println("3. Cadastrar Passageiro");
            System.out.println("4. Cadastrar Rota");
            System.out.println("5. Cadastrar Viagem");
            System.out.println("6. Listar Cadastros");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1: handleCadastrarOnibus(); break;
                    case 2: handleCadastrarMotorista(); break;
                    case 3: handleCadastrarPassageiro(); break;
                    case 4: handleCadastrarRota(); break;
                    case 5: handleCadastrarViagem(); break;
                    case 6: handleListarCadastros(); break;
                    case 0: System.out.println("Saindo do sistema..."); break;
                    default: System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
                opcao = -1;
            }
        }
        scanner.close();
    }
    
    private void handleCadastrarOnibus() {
        try {
            System.out.println("\n-- Cadastro de Ônibus --");
            System.out.print("Placa: ");
            String placa = scanner.nextLine();
            System.out.print("Quantidade de lugares: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Classe (ECONOMICA, EXECUTIVA, LUXO): ");
            Onibus.Classe classe = Onibus.Classe.valueOf(scanner.nextLine().toUpperCase());
            System.out.print("Custo de manutenção: ");
            float custo = scanner.nextFloat();
            scanner.nextLine();

            controlador.cadastrarOnibus(placa, qtd, classe, custo);
            System.out.println("Ônibus cadastrado com sucesso!");
        } catch (CadastroDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IllegalArgumentException e) {
             System.out.println("Erro: Classe de ônibus inválida. Use uma das opções listadas.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: Formato de número inválido para quantidade ou custo.");
            scanner.nextLine();
        }
    }

    private void handleCadastrarMotorista() {
        try {
            System.out.println("\n-- Cadastro de Motorista --");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Valor da diária: ");
            float diaria = scanner.nextFloat();
            scanner.nextLine();

            controlador.cadastrarMotorista(idade, nome, cpf, diaria);
            System.out.println("Motorista cadastrado com sucesso!");

        } catch (CadastroDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erro: Formato de número inválido para idade ou diária.");
            scanner.nextLine();
        }
    }

    private void handleCadastrarPassageiro() {
        try {
            System.out.println("\n-- Cadastro de Passageiro --");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            controlador.cadastrarPassageiro(email, nome, cpf);
            System.out.println("Passageiro cadastrado com sucesso!");

        } catch (CadastroDuplicadoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private void handleCadastrarRota() {
        try {
            System.out.println("\n-- Cadastro de Rota --");
            System.out.print("Cidade de Origem da Rota: ");
            String origem = scanner.nextLine();
            System.out.print("Cidade de Destino da Rota: ");
            String destino = scanner.nextLine();

            ArrayList<Trecho> trechos = new ArrayList<>();
            String continuar;
            do {
                System.out.println("\nAdicionando Trecho:");
                System.out.print("Início do trecho: ");
                String inicioTrecho = scanner.nextLine();
                System.out.print("Fim do trecho: ");
                String fimTrecho = scanner.nextLine();
                System.out.print("Duração (horas): ");
                int horas = scanner.nextInt();
                System.out.print("Duração (minutos): ");
                int minutos = scanner.nextInt();
                scanner.nextLine();

                Trecho trecho = new Trecho(inicioTrecho, fimTrecho, null);
                trecho.setDuracao(horas, minutos);
                trechos.add(trecho);

                System.out.print("Deseja adicionar outro trecho? (s/n): ");
                continuar = scanner.nextLine();
            } while (continuar.equalsIgnoreCase("s"));

            controlador.cadastrarRota(origem, destino, trechos);
            System.out.println("Rota cadastrada com sucesso!");

        } catch (RotaInvalidaException e) {
            System.out.println("Erro ao cadastrar rota: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Erro: Formato de número inválido para horas ou minutos.");
            scanner.nextLine();
        }
    }

    private void handleCadastrarViagem() {
        try {
            System.out.println("\n-- Cadastro de Viagem --");
            if (controlador.getListaRotas().isEmpty() || controlador.getListaOnibus().isEmpty() || controlador.getListaMotoristas().isEmpty()) {
                System.out.println("É necessário ter ao menos uma Rota, um Ônibus e um Motorista cadastrados para criar uma viagem.");
                return;
            }

            System.out.print("Origem da Rota: ");
            String origem = scanner.nextLine();
            System.out.print("Destino da Rota: ");
            String destino = scanner.nextLine();
            Rota rota = controlador.buscarRota(origem, destino);
            if (rota == null) {
                System.out.println("Erro: Rota não encontrada.");
                return;
            }

            System.out.print("Placa do Ônibus: ");
            String placa = scanner.nextLine();
            Onibus onibus = controlador.buscarOnibusPorPlaca(placa);
            if (onibus == null) {
                System.out.println("Erro: Ônibus não encontrado.");
                return;
            }

            System.out.print("CPF do Motorista: ");
            String cpf = scanner.nextLine();
            Motorista motorista = controlador.buscarMotoristaPorCPF(cpf);
            if (motorista == null) {
                System.out.println("Erro: Motorista não encontrado.");
                return;
            }

            System.out.print("Data da viagem (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataStr);

            controlador.cadastrarViagem(rota, data, onibus, motorista);
            System.out.println("Viagem cadastrada com sucesso!");

        } catch (ParseException e) {
            System.out.println("Erro: Formato de data inválido. Use dd/MM/yyyy.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
    
    private void handleListarCadastros() {
        System.out.println("\n--- LISTAGEM DE CADASTROS ---");
        
        System.out.println("\n** Ônibus Cadastrados **");
        if(controlador.getListaOnibus().isEmpty()){
            System.out.println("Nenhum ônibus cadastrado.");
        } else {
            controlador.getListaOnibus().forEach(o -> 
                System.out.printf("Placa: %s, Lugares: %d, Classe: %s\n", o.getPlaca(), o.getQuantidade_lugares(), o.getClasse())
            );
        }

        System.out.println("\n** Motoristas Cadastrados **");
        if (controlador.getListaMotoristas().isEmpty()){
            System.out.println("Nenhum motorista cadastrado.");
        } else {
            controlador.getListaMotoristas().forEach(m -> 
                System.out.printf("Nome: %s, CPF: %s, Idade: %d\n", m.getNome(), m.getCPF(), m.getIdade())
            );
        }
        
        System.out.println("\n** Passageiros Cadastrados **");
         if (controlador.getListaPassageiros().isEmpty()){
            System.out.println("Nenhum passageiro cadastrado.");
        } else {
            controlador.getListaPassageiros().forEach(p -> 
                System.out.printf("Nome: %s, CPF: %s, Email: %s\n", p.getNome(), p.getCPF(), p.getEmail())
            );
        }

        System.out.println("\n** Rotas Cadastradas **");
        if (controlador.getListaRotas().isEmpty()){
            System.out.println("Nenhuma rota cadastrada.");
        } else {
            controlador.getListaRotas().forEach(r -> {
                System.out.printf("Rota: %s -> %s\n", r.getOrigem(), r.getDestino());
                r.getTrechos().forEach(t -> 
                    System.out.printf("  - Trecho: %s a %s\n", t.getInicio(), t.getFim())
                );
            });
        }
        
        System.out.println("\n** Viagens Cadastradas **");
        if (controlador.getListaViagens().isEmpty()){
            System.out.println("Nenhuma viagem cadastrada.");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            controlador.getListaViagens().forEach(v -> 
                System.out.printf("Data: %s, Rota: %s-%s, Ônibus: %s, Motorista: %s\n", 
                    sdf.format(v.getData()), v.getRota().getOrigem(), v.getRota().getDestino(), v.getOnibus().getPlaca(), v.getMotorista().getNome())
            );
        }
    }
}
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class main {

    public static void main(String[] args) {
        boolean validaEntrada = false;

        while (validaEntrada == false) {//1
            validaEntrada = true;
            String Validacao = Tela("Deseja realizar uma operação ? s/n");

            if (Validacao.equals("n")) {
                JOptionPane.showMessageDialog(null, "Operação Finalizada");

            } else if (Validacao.equals("s")) {

                String Cont = Tela("Com quantos clientes deseja interação ? ");

                if (Cont.matches("[0-9]*")) {
                    Integer Contint = Integer.parseInt(Cont);
                    for (int Count = 0; Count < Contint; Count++) {
                        String NomeCliente = Tela("Qual nome do Cliente ? ");
                        Clientes ClienteBanco = new Clientes();
                        ClienteBanco.setnome(NomeCliente);

                        try {
                            String ValorDepositoString = Tela("Qual valor deseja depositar ? ");
                            Double ValorDepositoDoble = Double.parseDouble(ValorDepositoString);

                            Conta cc = new ContaCorrente(ClienteBanco);
                            cc.depositar(ValorDepositoDoble);

                            String ValorTransferenciaString = Tela("Qual valor deseja Transferir para Poupança ? ");
                            Double ValorTransferenciaDoble = Double.parseDouble(ValorTransferenciaString);

                            Conta cp = new ContaPoupanca(ClienteBanco);
                            cc.transferir(ValorTransferenciaDoble, cp);

                            cc.imprimirExtrato();
                            cp.imprimirExtrato();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "ERRO: Digite um valor numérico");
                            validaEntrada = false;
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "ERRO: Digite um número inteiro");
                    validaEntrada = false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "ERRO: Entrada Inválida");
                validaEntrada = false;
            }

        }

        // *** Criar um Arquivo de texto ***
        Path path = Path.of("C:ProjetoBancoDigital");
        if (Files.notExists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        String texto = ("Este Registro pode conter certas declarações prospectivas" +
                " e informações relativas ao BlueBankS.A.");

        try {
            Files.writeString(path, texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (validaEntrada == true) {
            // *** Ler o Arquivo de texto ***
            List<String> stringss = null;
            try {
                stringss = Files.readAllLines(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (String textoo : stringss) {
                System.out.println(texto);
            }

            JOptionPane.showMessageDialog(null, texto);
        }

    }

    private static String Tela(String display) {
        return JOptionPane.showInputDialog(display);
    }

}




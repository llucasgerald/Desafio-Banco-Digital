import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Conta implements IConta {

private static final int agenciapadrao = 0001 ;
private static int sequencial = 1 ;

    protected int agencia;
    protected int numeroConta;
    protected double saldo;
    protected Clientes cliente;

    public Conta (Clientes cliente){
        this.agencia = Conta.agenciapadrao;
        this.numeroConta = sequencial ++;
        this.cliente = cliente;
    }


    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
       contaDestino.depositar(valor);

    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;

    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;

    }

    public int getagencia () {
        return agencia;
    }

    public int getnumeroConta () {
        return numeroConta;
    }

    public double getsaldo () {
        return saldo;
    }


    LocalDate Data = LocalDate.now();
    LocalTime Hora = LocalTime.now();

    protected void imprimirinfo1() {
       JOptionPane.showMessageDialog(null, "*** Extrato Conta Corrente *** " +
               "\n" + (String.format("Titular: %s",this.cliente.getnome())) +
               "\n" + (String.format("Agencia: %d",this.agencia)) +
               "\n" + (String.format("Conta: %d",this.numeroConta)) +
               "\n" + (String.format("Saldo: %.2f",this.saldo)) +
               "\n" + "Data: " + Data + "\n" + "Hora: " + Hora );

    }

    protected void imprimirinfo2() {
        JOptionPane.showMessageDialog(null, "*** Extrato Conta Poupanca ***" +
                "\n" + (String.format("Titular: %s",this.cliente.getnome())) +
                "\n" + (String.format("Agencia: %d",this.agencia)) +
                "\n" + (String.format("Conta: %d",this.numeroConta)) +
                "\n" + (String.format("Saldo: %.2f",this.saldo)) +
                "\n" + "Data: " + Data + "\n" + "Hora: " + Hora );

    }
}



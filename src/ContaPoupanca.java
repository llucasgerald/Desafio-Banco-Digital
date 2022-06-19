public class ContaPoupanca extends Conta {

    public ContaPoupanca( Clientes cliente){
        super(cliente);
    }

    public void imprimirExtrato() {
        System.out.println("*** Extrato Conta Poupanca ***");
        super.imprimirinfo();

    }
}
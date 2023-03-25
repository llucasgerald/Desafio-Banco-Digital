public class ContaPoupanca extends Conta {

    public ContaPoupanca( Clientes cliente){
        super(cliente);
    }

    public String imprimirExtrato() {
        super.imprimirinfo2();

        return null;
    }
}
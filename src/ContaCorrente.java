public class ContaCorrente extends Conta {

    public ContaCorrente( Clientes cliente){
        super(cliente);
    }

    public void imprimirExtrato (){
        System.out.println("*** Extrato Conta Corrente ***");
        super.imprimirinfo();
    }



}

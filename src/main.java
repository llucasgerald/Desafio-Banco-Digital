public class main {

    public static void main(String[] args) {

    Clientes Rita = new Clientes();
    Rita.setnome("Rita");
    Conta cc = new ContaCorrente(Rita);
    cc.depositar(100);

    Conta cp = new ContaPoupanca(Rita);
    cc.transferir(60 , cp);

    cc.imprimirExtrato();
    cp.imprimirExtrato();


    }

}


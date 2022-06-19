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



    protected void imprimirinfo() {
        System.out.println(String.format("Titular: %s",this.cliente.getnome()));
        System.out.println(String.format("Agencia: %d",this.agencia));
        System.out.println(String.format("Conta: %d",this.numeroConta));
        System.out.println(String.format("Saldo: %.2f",this.saldo));
    }
}


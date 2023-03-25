public interface IConta {

    void transferir(double valor , IConta contaDestino);
    void sacar (double valor);
    void depositar(double valor);

    String imprimirExtrato ();

    }


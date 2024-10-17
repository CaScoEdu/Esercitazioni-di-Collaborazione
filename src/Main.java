public class Main {

    public static void main(String[] args) throws Exception {

        final int DIMENSIONE_BUFFER = 3;
        final Buffer BUFFER = new Buffer(DIMENSIONE_BUFFER);

        final int NUMERO_CONSUMATORI = 2;
        for (int i = 1; i <= NUMERO_CONSUMATORI; i++)
            new Thread(new Consumatore("consumatore" + i, BUFFER)).start();

        final int NUMERO_PRODUTTORI = 3;
        for (int i = 1; i <= NUMERO_PRODUTTORI; i++)
            new Thread(new Produttore("produttore" + i, BUFFER)).start();
    }
}



public class Produttore implements Runnable {

    final private String NOME;
    final private Buffer BUFFER;

    // costruttore del produttore
    public Produttore(final String NOME, Buffer BUFFER) {
        this.NOME = NOME;
        this.BUFFER = BUFFER;
    }

    @Override
    public void run() {

        try {

            final int NUMERO_MESSAGGI = 3;

            for (int i = 1; i <= NUMERO_MESSAGGI; i++) {

                Messaggio MESSAGGIO = new Messaggio(NOME);

                BUFFER.deposita(MESSAGGIO);

                System.out.println(MESSAGGIO.toString());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

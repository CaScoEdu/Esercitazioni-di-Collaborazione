

public class Produttore implements Runnable {

    final private String NOME;
    final private Buffer BUFFER;

    // costruttore del produttore
    public Produttore(final String NOME, final Buffer BUFFER) {
        this.NOME = NOME;
        this.BUFFER = BUFFER;
    }

    @Override
    public void run() {

        try {

            final int NUMERO_MESSAGGI = 3;

            for (int i = 1; i <= NUMERO_MESSAGGI; i++) {

                Messaggio MESSAGGIO = new Messaggio(NOME);

                BUFFER.PRELEVATO.WAIT();

                MESSAGGIO.setStato("depositato");

                BUFFER.messaggio = MESSAGGIO;
                System.out.println(MESSAGGIO.toString());

                BUFFER.DEPOSITATO.SIGNAL();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

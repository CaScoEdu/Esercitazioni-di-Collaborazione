

public class Produttore implements Runnable {

    private String nome;
    private Buffer buffer;

    // costruttore del produttore
    public Produttore(String nome, Buffer buffer) {
        this.nome = nome;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {

            final int NUMERO_MESSAGGI = 3;

            for (int i = 1; i <= NUMERO_MESSAGGI; i++) {

                Messaggio MESSAGGIO = new Messaggio(nome);

                buffer.PRELEVATO.WAIT();

                MESSAGGIO.setStato("depositato");

                buffer.messaggio = MESSAGGIO;
                System.out.println(MESSAGGIO.toString());

                buffer.DEPOSITATO.SIGNAL();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

            final Random RANDOM = new Random();

            final int NUMERO_MESSAGGI = 3;

            for (int i = 1; i <= NUMERO_MESSAGGI; i++) {              

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

                Messaggio MESSAGGIO = new Messaggio(NOME);

                BUFFER.deposita(MESSAGGIO);

                System.out.println(MESSAGGIO.toString());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

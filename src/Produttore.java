import java.util.Random;
import java.util.concurrent.TimeUnit;

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

            final Random RANDOM = new Random();

            final int NUMERO_MESSAGGI = 3;

            for (int i = 1; i <= NUMERO_MESSAGGI; i++) {              

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

                Messaggio MESSAGGIO = new Messaggio(nome);

                buffer.deposita(MESSAGGIO);

                System.out.println(MESSAGGIO.toString());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumatore implements Runnable {

    final private String NOME;
    final private Buffer BUFFER;

    // costruttore del consumatore
    public Consumatore (final String NOME, final Buffer BUFFER) {
        this.NOME = NOME;
        this.BUFFER = BUFFER;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            while (true) {

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

                final Messaggio MESSAGGIO = BUFFER.preleva();

                MESSAGGIO.setConsumatore(NOME);
                System.out.println((MESSAGGIO.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

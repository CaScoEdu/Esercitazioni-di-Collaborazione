import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ragazzo implements Runnable {

    final private String NOME;
    final private Buffer BUFFER;

    // costruttore del consumatore
    public Ragazzo (final String NOME, final Buffer BUFFER) {
        this.NOME = NOME;
        this.BUFFER = BUFFER;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            while (true) {

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(10));

                final Panino PANINO = BUFFER.preleva();

                PANINO.setConsumatore(NOME);

                System.out.println((PANINO.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

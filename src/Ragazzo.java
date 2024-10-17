import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Ragazzo implements Runnable {

    private String nome;
    private Buffer buffer;

    // costruttore del consumatore
    public Ragazzo (String nome, Buffer buffer) {
        this.nome = nome;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            while (true) {

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(10));

                final Panino PANINO = buffer.preleva();

                PANINO.setConsumatore(nome);

                System.out.println((PANINO.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

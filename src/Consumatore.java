import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Consumatore implements Runnable {

    private String nome;
    private Buffer buffer;

    // costruttore del consumatore
    public Consumatore (String nome, Buffer buffer) {
        this.nome = nome;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            while (true) {

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

                final Messaggio MESSAGGIO = buffer.preleva();

                MESSAGGIO.setConsumatore(nome);
                System.out.println((MESSAGGIO.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

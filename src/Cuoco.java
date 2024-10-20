import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cuoco implements Runnable {

    final private String NOME;
    final private Buffer BUFFER;

    // costruttore del produttore
    public Cuoco(final String NOME, final Buffer BUFFER) {
        this.NOME = NOME;
        this.BUFFER = BUFFER;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            final int NUMERO_PANINI = 5;

            for (int i = 1; i <= NUMERO_PANINI; i++) {              

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

                Panino PANINO = new Panino(NOME);

                BUFFER.deposita(PANINO);

                System.out.println(PANINO.toString());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

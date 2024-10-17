import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cuoco implements Runnable {

    private String nome;
    private Buffer buffer;

    // costruttore del produttore
    public Cuoco(String nome, Buffer buffer) {
        this.nome = nome;
        this.buffer = buffer;
    }

    @Override
    public void run() {

        try {

            final Random RANDOM = new Random();

            final int NUMERO_PANINI = 5;

            for (int i = 1; i <= NUMERO_PANINI; i++) {              

                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));

                Panino PANINO = new Panino(nome);

                buffer.deposita(PANINO);

                System.out.println(PANINO.toString());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

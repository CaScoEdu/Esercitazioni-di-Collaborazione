
public class Consumatore implements Runnable {

    final private String NOME;
    final private Buffer BUFFER;

    // costruttore del consumatore
    public Consumatore (final String NOME, Buffer BUFFER) {
        this.NOME = NOME;
        this.BUFFER = BUFFER;
    }

    @Override
    public void run() {

        try {

            while (true) {

                final Messaggio MESSAGGIO = BUFFER.preleva();

                MESSAGGIO.setConsumatore(NOME);
                System.out.println((MESSAGGIO.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


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

            while (true) {

                BUFFER.DEPOSITATO.WAIT();

                Messaggio MESSAGGIO = BUFFER.messaggio;
                MESSAGGIO.setConsumatore(NOME);
                MESSAGGIO.setStato("prelevato ");
                System.out.println((MESSAGGIO.toString()));

                BUFFER.PRELEVATO.SIGNAL();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

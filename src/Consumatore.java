
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

            while (true) {

                buffer.DEPOSITATO.WAIT();

                Messaggio MESSAGGIO = buffer.messaggio;
                MESSAGGIO.setConsumatore(nome);
                MESSAGGIO.setStato("prelevato ");
                System.out.println((MESSAGGIO.toString()));

                buffer.PRELEVATO.SIGNAL();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

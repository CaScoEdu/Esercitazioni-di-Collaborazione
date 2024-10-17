
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

                final Messaggio MESSAGGIO = buffer.preleva();

                MESSAGGIO.setConsumatore(nome);
                System.out.println((MESSAGGIO.toString()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

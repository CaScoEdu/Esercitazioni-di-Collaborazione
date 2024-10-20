import java.util.ArrayList;

public class Buffer {

    final private int DIMENSIONE_BUFFER;

    public Buffer(final int DIMENSIONE_BUFFER) {
        this.DIMENSIONE_BUFFER = DIMENSIONE_BUFFER;
    }

    private ArrayList<Messaggio> MESSAGGI = new ArrayList<Messaggio>();

    public synchronized void deposita(Messaggio messaggio) throws InterruptedException{

        while (MESSAGGI.size() == DIMENSIONE_BUFFER)
            wait();

        MESSAGGI.add(messaggio);

        messaggio.setStato("depositato");

        notifyAll();
    }

    public synchronized Messaggio  preleva() throws InterruptedException{

        while (MESSAGGI.size() == 0)
            wait();

        final Messaggio MESSAGGIO = MESSAGGI.removeFirst();

        MESSAGGIO.setStato("prelevato");

        notifyAll();

        return MESSAGGIO;

    }
}

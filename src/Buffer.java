import java.util.ArrayList;

public class Buffer {

    private int dimensioneBuffer;

    public Buffer(int dimensioneBuffer) {
        this.dimensioneBuffer = dimensioneBuffer;
    }

    private ArrayList<Messaggio> MESSAGGI = new ArrayList<Messaggio>();

    public synchronized void deposita(Messaggio messaggio) throws InterruptedException{

        while (MESSAGGI.size() == dimensioneBuffer)
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

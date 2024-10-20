import java.util.ArrayList;

public class Buffer {

    final private int DIMENSIONE_BUFFER;

    public Buffer(final int DIMENSIONE_BUFFER) {
        this.DIMENSIONE_BUFFER = DIMENSIONE_BUFFER;
    }

    private ArrayList<Panino> PANINI = new ArrayList<Panino>();

    public synchronized void deposita(final Panino PANINO) throws InterruptedException{

        while (PANINI.size() == DIMENSIONE_BUFFER)
            wait();

        PANINI.add(PANINO);

        PANINO.setStato("depositato");

        notifyAll();
    }

    public synchronized Panino  preleva() throws InterruptedException{

        while (PANINI.size() == 0)
            wait();

        final Panino PANINO = PANINI.removeFirst();

        PANINO.setStato("prelevato ");

        notifyAll();

        return PANINO;

    }
}

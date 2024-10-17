import java.util.ArrayList;

public class Buffer {

    private int dimensioneBuffer;

    public Buffer(int dimensioneBuffer) {
        this.dimensioneBuffer = dimensioneBuffer;
    }

    private ArrayList<Panino> PANINI = new ArrayList<Panino>();

    public synchronized void deposita(Panino panino) throws InterruptedException{

        while (PANINI.size() == dimensioneBuffer)
            wait();

        PANINI.add(panino);

        panino.setStato("depositato");

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

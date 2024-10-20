
public class SemaforoMutex { // realizzato con un Semaforo Mutex 
    //(caso particolare di semaforo di Dijkstra inizializzato a 1)
  
    private int s;   

    public SemaforoMutex(final int S) {
        this.s = S;
    }

    public synchronized void WAIT() throws InterruptedException{
        
        while (s == 0)
            wait();
        
        s--;
    }

    public synchronized void SIGNAL(){
        s++;
        notify();
    }

}

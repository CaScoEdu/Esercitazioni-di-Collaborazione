public class Buffer {

    public Messaggio messaggio;

    public final SemaforoMutex PRELEVATO = new SemaforoMutex(1); // via libera al produttore
    public final SemaforoMutex DEPOSITATO = new SemaforoMutex(0); // blocca il consumatore

}

public class Messaggio {

    private static int progressivo = 0;
    final private int ID;
    private String stato;
    final private String PRODUTTORE;
    private String consumatore = "null";
    
    public Messaggio(final String PRODUTTORE) {
        this.ID= ++progressivo;
        this.stato = "creato";
        this.PRODUTTORE = PRODUTTORE;
    }

    public void setConsumatore(final String CONSUMATORE) {
        this.consumatore = CONSUMATORE;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Messaggio [id=" + ID + ", stato=" + stato + ",  produttore=" + PRODUTTORE
                + ", consumatore=" + consumatore + "]";
    } 
    
}

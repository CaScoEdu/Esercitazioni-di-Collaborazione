public class Panino {

    private static int progressivo = 0;

    final private int ID;
    private String stato = "creato";
    final private String PRODUTTORE;
    private String consumatore = null;
    
    public Panino(final String PRODUTTORE) {
        this.ID= ++progressivo;
        this.PRODUTTORE = PRODUTTORE;
    }

    public void setConsumatore(final String CONSUMATORE) {
        this.consumatore = CONSUMATORE;
    }

    public void setStato(final String STATO) {
        this.stato = STATO;
    }

    @Override
    public String toString() {
        return "Panino [id=" + ID + ", stato=" + stato + ",  produttore=" + PRODUTTORE
                + ", consumatore=" + consumatore + "]";
    } 
    
}

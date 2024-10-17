public class Panino {

    private static int progressivo = 0;
    private int id;
    private String stato;
    private String produttore;
    private String consumatore;
    
    public Panino(String produttore) {
        this.id= ++progressivo;
        this.produttore = produttore;
    }

    public void setConsumatore(String consumatore) {
        this.consumatore = consumatore;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Panino [id=" + id + ", stato=" + stato + ",  produttore=" + produttore
                + ", consumatore=" + consumatore + "]";
    } 
    
}

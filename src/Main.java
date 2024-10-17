public class Main {

    public static void main(String[] args) throws Exception {

        final int DIMENSIONE_BUFFER = 5;
        final Buffer BUFFER = new Buffer(DIMENSIONE_BUFFER);

        final int NUMERO_RAGAZZI = 3;
        for (int i = 1; i <= NUMERO_RAGAZZI; i++)
            new Thread(new Ragazzo("ragazzo" + i, BUFFER)).start();

        final int NUMERO_CUOCHI = 2;
        for (int i = 1; i <= NUMERO_CUOCHI; i++)
            new Thread(new Cuoco("cuoco" + i, BUFFER)).start();
    }
}

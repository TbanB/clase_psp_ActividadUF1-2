import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable {

    private BufferExamenes buffer;
    private static int numeroExamen = 0;
    private Thread hilo;

    /**
     * En este método creamos el código con el que identificaremos cada uno de los examenes.
     * @param buffer
     */
    public ProductorExamenes(BufferExamenes buffer) {
        /**
         * añadimos +1 al contador cada vez que ejecutamos el método, y creamos un nuevo hilo con el nombre basado en el código del examen.
         */
        numeroExamen++;
        this.buffer = buffer;
        this.hilo = new Thread(this, "E" + numeroExamen);
        this.hilo.start();
    }

    /**
     * Este método contiene el código que se ejecutará cuando el hilo se inicie.
     */
    @Override
    public void run() {
        /**
         * generamos el código con el año actual y lo añadimos al buffer compartido.
         */
        int aa = LocalDateTime.now().getYear();
        String codigo = this.hilo.getName() + "-" +aa;

        buffer.fabricarNuevoExamen(codigo);
    }

}
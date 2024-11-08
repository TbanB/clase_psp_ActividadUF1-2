import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable {

    private BufferExamenes buffer;
    private static int numeroExamen = 0;
    private Thread hilo;

    public ProductorExamenes(BufferExamenes buffer) {
        // Incrementa el contador de exámenes (variable numeroExamen).

        // Construye el hilo. El nombre será la letra E seguida
        // del valor de la variable numeroExamen.

        // Establece el valor de la propiedad buffer
        // Inicia el hilo.
    }

    @Override
    public void run() {
        int aa = LocalDateTime.now().getYear();
        // Generación del código de examen.
        String codigo = this.hilo.getName() + "-" +aa;

        // Añade el nuevo código al buffer de exámenes.

        // Muestra un mensaje en consola informando sobre el
        // código del examen que se acaba de producir.
    }

}
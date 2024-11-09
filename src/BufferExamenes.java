import java.util.LinkedList;
import java.util.Queue;

/**
 * Esta clase creará el contenedor dónde almacenaremos los diferentes examenes que se vayan creando.
 */
public class BufferExamenes {

    /**
     * definimos colaExamenes con el interfaz de queue para declarar que el comportamiento de la cola será de tipo FIFO (First in, First out)
     */
    private Queue<String> colaExamenes;

    public BufferExamenes() {
        /**
         * Utilizamos LinkedList para crear la cola de examenes. A nota personal, LinkedList nos proporciona varios métodos que nos facilita gestionar la lista.
         * Lo declaramos de tipo string porque el código de examen es alphanumérico
         */
        colaExamenes = new LinkedList<String>();
    }

    /**
     * declaramos el método cómo public synchronized para asegurar que se ejecute un sólo hilo a la vez, y evitar problemas de acceso simultaneo en colaExamenes
     * @param codigo
     */
    public synchronized void fabricarNuevoExamen(String codigo) {

        /**
         * se añade el código del examen creado a la cola de examenes y notificamos a los hilos que están esperando que el proceso ha terminado.
         */
        colaExamenes.add(codigo);
        System.out.println("Produciendo examen: "+ codigo);
        notify();
    }

    /**
     * Volvemos a declarar el método con el synchronized para evitar que se ejecute más de uno a la vez.
     * @return
     */
    public synchronized String consumirExamen() {
        /**
         * declaramos un try catch por si el proceso falla y capturar la excepción.
         */
        try {
            /**
             * añadimos un while que contiene un wait() que obliga a esperar al proceso hasta que exista un código de examen dentro de la cola.
             */
            while (colaExamenes.isEmpty()) {
                wait();
            }
            /**
             * retornamos el primer elemento de la cola y lo eliminamos de esta con el método .poll() de la LinkedList
             */
            return colaExamenes.poll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

public class Principal {
    /**
     * clase principal dónde ejecutamos los diferentes procesos de la aplicación
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        /**
         * Creamos la instancia del "contenedor" que alacenará los examenes.
         */
        BufferExamenes generador = new BufferExamenes();

        new ProductorExamenes(generador);
        new Examinado("Rosa", generador);
        new ProductorExamenes(generador);
        new Examinado("Miguel", generador);
        new ProductorExamenes(generador);
        new Examinado("Carlos", generador);
    }
}

public class Examinado implements Runnable {

    private Thread hilo;
    BufferExamenes buffer;

    public Thread getHilo() {
        return hilo;
    }

    /**
     * Este método recibe el nombre del alumno y el buffer de examenes.
     * @param alumno
     * @param generador
     */
    public Examinado(String alumno, BufferExamenes generador) {
        /**
         * Creamos un nuevo hilo con el nombre del alumno.
         */
        this.buffer = generador;
        this.hilo = new Thread(this, alumno);
        hilo.start();
    }

    @Override
    public synchronized void run() {
        /**
         * recogemos el código del examen que vamos a consumir
         */
        String codigoExamen = this.buffer.consumirExamen();

        /**
         * en caso de que exista un código de examen generamos una simulación de 10 preguntas con respuestas aleatorias.
         */
        if (codigoExamen != null) {
            for (int i = 1; i <= 10; i++) {
                char[] respuestas = {'A', 'B', 'C', 'D', '-'};
                int index = (int) (Math.random() * respuestas.length);
                char respuesta = respuestas[index];  // Generar una respuesta aleatoria (A, B, C, D, -)
                System.out.println(codigoExamen + ";" + hilo.getName() + "; Pregunta " + i + ";" + respuesta);
            }
        } else {
            System.out.println("Agotado tiempo de espera y " + "no hay más exámenes");
        }

    }

}


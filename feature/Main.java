package feature;

class Contador {
    private int cuenta = 0;

    // Método sincronizado para incrementar el contador
    public synchronized void incrementar() {
        cuenta++;
    }

    // Obtener el valor actual del contador
    public int getCuenta() {
        return cuenta;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Crear una instancia de Contador
        Contador contador = new Contador();

        // Crear dos hilos que incrementan el contador
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        }); 

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                contador.incrementar();
            }
        });

        // Iniciar los hilos
        hilo1.start();
        hilo2.start();

        // Esperar a que los hilos terminen
        hilo1.join();
        hilo2.join();

        // Imprimir el valor final del contador
        System.out.println("Valor final del contador: " + contador.getCuenta());
    }
}
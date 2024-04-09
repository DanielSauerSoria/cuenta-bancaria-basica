import java.util.Scanner;

public class principal {
    private static final String nombre = "Daniel Sauer";
    private static final String tipoDeCuenta = "Corriente";
    public static double saldo = 1599.99;
    private static final int SALIR = 4;
    public static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        // Mostramos los datos del cliente al inicio del programa
        System.out.println("**************Datos del cliente***************");
        System.out.println("\tNombre del cliente: " + nombre); // Usamos el nombre de la variable especificado
        System.out.println("\tEl tipo de cuenta es: " + tipoDeCuenta); // Usamos el nombre de la variable especificado
        System.out.println("\tEl saldo disponible es: $" + saldo); // Usamos el nombre de la variable especificado
        System.out.println("**********************************************");

        // Ciclo principal para mostrar el menú y procesar las opciones del usuario
        while (opcion != SALIR) {
            mostrarMenu();
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirarDinero();
                    break;
                case 3:
                    depositarDinero();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. Gracias por utilizar este programa.");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        teclado.close(); // Cerramos el Scanner al salir del programa
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        String menu = """
                    \n*** Escriba el número de la opción deseada ***
                    1.- Consultar saldo
                    2.- Retirar
                    3.- Depositar
                    4.- Salir """;
        System.out.println(menu);
    }

    // Método para consultar el saldo actual
    private static void consultarSaldo() {
        System.out.println("El saldo es: $" + saldo);
    }

    // Método para retirar dinero de la cuenta
    private static void retirarDinero() {
        System.out.println("¿Cuánto desea retirar?");
        double retiro = teclado.nextDouble();
        if (retiro > saldo) {
            System.out.println("Saldo insuficiente");
        } else {
            saldo -= retiro;
            System.out.println("El saldo actualizado es: $" + saldo);
        }
    }

    // Método para depositar dinero en la cuenta
    private static void depositarDinero() {
        System.out.println("¿Cuánto desea depositar?");
        double deposito = teclado.nextDouble();
        saldo += deposito;
        System.out.println("El saldo actualizado es: $" + saldo);
    }
}

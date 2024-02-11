package taller2;


import java.util.Scanner;


class Clientes  {
String Nombres;
String Apellidos;
String Edad;
String TipoCuenta;

}

public class Problema3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----Bienvenido al BancoX----");
        System.out.println("Por favor seleccione la operación que desea realizar");
        System.out.println(" Menu: ");
        System.out.println("1 - Apertura de cuentas: Ahorro o corriente");
        System.out.println("2 - Transferencias");
        System.out.println("3 - Cajero automático");
        System.out.println("4 - Estado de cuenta");
        
        // Leer la opción del usuario
        int opcionSeleccionada = scanner.nextInt();
        
        switch (opcionSeleccionada) {
        case 1:
            seleccionarTipoCuenta();
            break;
        case 2:
            bancoaTransferir();
            break;
        case 3:
            retiro();
            break;
        case 4:
            cierre();
            
        default:
            System.out.println("Opción no válida. Por favor, seleccione opción valida");
        }
        private static void seleccionarTipoCuenta() {
            // Lógica para abrir una cuenta de ahorro
            System.out.println("Ha seleccionado la Apertura de cuentas de ahorro");
            System.out.println("Por favor indique el tipo de cuenta");
            System.out.println("Seleccione el tipo de cuenta:");
            System.out.println("1. Cuenta de Ahorro");
            System.out.println("2. Cuenta Corriente");

        Scanner scanner;
		// Obtener la elección del usuario
        int opcionSeleccionada = scanner.nextInt();

        // Procesar la elección del usuario
        switch (opcionSeleccionada) {
            case 1:
                abrirCuentaDeAhorro();
                break;
            case 2:
                abrirCuentaCorriente();
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione 1 o 2.");
        }

        // Cerrar el scanner al final del programa
        scanner.close();
        }

    private static void abrirCuentaDeAhorro() {
        // Lógica para abrir una cuenta de ahorro
        System.out.println("Se ha seleccionado la apertura de cuenta de ahorro. Procesando...");
    }

    private static void abrirCuentaCorriente() {
        // Lógica para abrir una cuenta corriente
        System.out.println("Se ha seleccionado la apertura de cuenta corriente. Procesando...");
    }
    }
    }


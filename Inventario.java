import java.util.Scanner;

public class Inventario {

    static String[] productos = { "Lapiz", "Cuaderno", "Calculadora" };
    static int[] stock = { 10, 15, 20 };
    static double[] precios = { 1500, 4500, 10000 };
    static int[] ventas = { 5, 3, 2 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción: ");
            System.out.println("1. Verificar disponibilidad de un producto");
            System.out.println("2. Calcular precio total de una compra");
            System.out.println("3. Generar informe de productos más vendidos");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    verificarDisponibilidad();
                    break;
                case 2:
                    PrecioTotal();
                    break;
                case 3:
                    generarInforme();
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        }
    }

    static void verificarDisponibilidad() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto: ");
        String productoBuscado = scanner.nextLine();

        int indice = -1;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i].equalsIgnoreCase(productoBuscado)) {
                indice = i;
                break;
            }
        }

        if (indice != -1 && stock[indice] > 0) {
            System.out.println("El producto está disponible.");
        } else {
            System.out.println("El producto no está disponible o no existe en el inventario.");
        }
    }

    static void PrecioTotal() {
        Scanner scanner = new Scanner(System.in);
        double total = 0;

        System.out.print("¿Cuantas compras quiere registrar?");
        int numProductos = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numProductos; i++) {
            System.out.print("Ingrese compra " + (i + 1) + ": ");
            String producto = scanner.nextLine();

            int indice = -1;
            for (int j = 0; j < productos.length; j++) {
                if (productos[j].equalsIgnoreCase(producto)) {
                    indice = j;
                    break;
                }
            }

            if (indice != -1 && stock[indice] > 0) {
                total += precios[indice];
                ventas[indice]++;
                stock[indice]--;
            } else {
                System.out.println("Producto no válido o no disponible. Inténtelo de nuevo.");
                i--;
            }
        }

        System.out.println("El precio total de la compra es: " + total);
    }

    static void generarInforme() {
        System.out.println("Informe de productos más vendidos:");

        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i] + ": " + ventas[i] + " unidades vendidas.");
        }
    }
}

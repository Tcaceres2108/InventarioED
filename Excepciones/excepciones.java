
package notas;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Notas {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        double avg = 0;// asigno variable avg = promedio
        System.out.print("Ingrese la cantidad de notas: ");
        int size = read.nextInt();// variable size
        double[] grade = new double[size]; // Array calificacion
        for (int i = 0; i < size; i++) {

            try {
                System.out.print("Ingrese la nota en la posicion " + (i + 1) + ": ");
                String input = read.next();

                if (input.contains(",")) {
                    throw new InputMismatchException();
                }

                grade[i] = Double.parseDouble(input); // Intentar convertir a double

            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido con punto decimal.");
                i--; // Retroceder el índice para reintentar la entrada
            } catch (InputMismatchException e) {
                System.out.println("Utilice punto en lugar de coma para el decimal. Inténtelo de nuevo.");
                read.nextLine(); // Limpiar el buffer de entrada
                i--; // Retroceder el índice para reintentar la entrada
            }
        }

        for (double g : grade) {
            avg += g;
        }
        System.out.println("El promedio del estudiante es: " + avg / size);

        read.close();
    }
}
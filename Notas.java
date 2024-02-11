import java.util.Scanner;
import java.util.InputMismatchException;

public class Notas {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double avg = 0; // Variable para el promedio

        // Solicitar la cantidad de notas, validando que sean minimo 2 maximo 20
        int size;

        do {
            System.out.print("Ingrese la cantidad de notas: ");
            size = read.nextInt();

            if (size <= 2 || size >= 20) {
                System.out.println("La cantidad de notas debe ser minimo 2 maximo 20.");
            }

        } while (size <= 2 || size >= 20);

        double[] grade = new double[size]; // Array calificacion

        for (int i = 0; i < size; i++) {
            // creacion de excepción personalizada para que arroje validacion de decima con
            // "." y no ","
            try {
                System.out.print("Ingrese la nota en la posición " + (i + 1) + ": ");
                String input = read.next();

                if (input.contains(",")) {
                    throw new InputMismatchException();
                }

                double nota = Double.parseDouble(input);

                if (nota < 0 || nota > 5) {
                    throw new IllegalArgumentException("La nota debe estar en el rango de 0 a 5.");
                }

                grade[i] = nota;

            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido con punto decimal.");
                i--; // Retroceder el índice para reintentar la entrada
            } catch (InputMismatchException e) {
                System.out.println("Utilice punto en lugar de coma para el decimal. Inténtelo de nuevo.");
                read.nextLine(); // Limpiar el buffer de entrada
                i--; // Retroceder el índice para reintentar la entrada
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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

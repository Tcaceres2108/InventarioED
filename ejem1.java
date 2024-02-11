package taller2;

import java.util.Scanner;


//Clase base para representar a un estudiante
class Persona  {
 String Nombres;
 String Apellidos;
 String Documento;
 String Direccion;
 String Telefono;

 // Constructor

public Persona (String Nombres, String Apellidos, String Documento, String Direccion, String Telefono) {
this.nombres = nombres;
this.apellidos = apellidos;
this.documento = documento;
this.direccion = direccion;
this.telefono = telefono;
 }

 // Método para obtener la información del estudiante
 public void obtenerInformacion() {
     System.out.println("Información del Estudiante:");
     System.out.println("Nombres: " + nombres);
     System.out.println("Apellidos: " + apellidos);
     System.out.println("Documento: " + documento);
     System.out.println("Dirección: " + direccion);
     System.out.println("Teléfono: " + telefono);
 }

 // Método para calcular el monto de la matrícula
 public double calcularMatricula(int semestre, boolean enLinea, boolean aplazaMaterias) {
     double montoBase = 1500.0;

     if (enLinea && !aplazaMaterias && semestre >= 5) {
         return montoBase * 1.05; // Aumento del 5% a partir del quinto semestre
     } else if (!enLinea && aplazaMaterias) {
         // Calcula el total del semestre y las materias perdidas
         double totalSemestre = calcularTotalSemestre(semestre);
         double costoMateriasPerdidas = calcularCostoMateriasPerdidas(semestre);
         return totalSemestre + costoMateriasPerdidas;
     } else {
         return montoBase;
     }
 }

 // Método para calcular el total del semestre
 private double calcularTotalSemestre(int semestre) {
     if (semestre <= 3) {
         return semestre * 20.0; // Cada crédito cuesta 20 dólares para primero, segundo y tercer semestre
     } else if (semestre <= 6) {
         return semestre * 25.0; // Cada crédito cuesta 25 dólares para cuarto, quinto y sexto semestre
     } else {
         return semestre * 30.0; // Cada crédito cuesta 30 dólares para el resto de los semestres
     }
 }

 // Método para calcular el costo de las materias perdidas
 private double calcularCostoMateriasPerdidas(int semestre) {
     // Simplemente un ejemplo, puedes personalizar esta lógica según tus necesidades
     int materiasPerdidas = 2; // Número de materias perdidas
     double costoPorCredito = (semestre <= 3) ? 20.0 : (semestre <= 6) ? 25.0 : 30.0;
     return materiasPerdidas * costoPorCredito;
 }

 // Método para imprimir el recibo de inscripción
 public void imprimirRecibo(double monto) {
     System.out.println("Recibo de Inscripción:");
     obtenerInformacion();
     System.out.println("Monto de la matrícula: $" + monto);
 }
}

//Clase hija que representa a un estudiante de una carrera específica
	class EstudianteCarrera extends Persona {
		private String carrera;

 // Constructor
 public EstudianteCarrera(String nombres, String apellidos, String documento, String direccion, String telefono) {
     super(nombres, apellidos, documento, direccion, telefono);
     this.carrera = carrera;
 }

 // Método para obtener la información del estudiante de la carrera
 @Override
 public void obtenerInformacion() {
     super.obtenerInformacion();
     System.out.println("Carrera: " + carrera);
 }
}

public class Problema4 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.println("Bienvenido a la Facultad de Ingeniería");
     System.out.println("Por favor seleccione el programa a consultar:");
     System.out.println("1 - Ingeniería de sistemas");
     System.out.println("2 - Ingeniería Industrial");
     System.out.println("3 - Ingeniería mecánica");

     // Leer la opción del usuario
     int opcion = scanner.nextInt();
     scanner.nextLine(); // Consumir el salto de línea después del número

     // Pedir información del estudiante
     System.out.println("Ingrese nombres del estudiante:");
     String nombres = scanner.nextLine();
     System.out.println("Ingrese apellidos del estudiante:");
     String apellidos = scanner.nextLine();
     System.out.println("Ingrese documento del estudiante:");
     String documento = scanner.nextLine();
     System.out.println("Ingrese dirección del estudiante:");
     String direccion = scanner.nextLine();
     System.out.println("Ingrese teléfono del estudiante:");
     String telefono = scanner.nextLine();

   
     EstudianteCarrera estudiante = new EstudianteCarrera(nombres, apellidos, documento, direccion, telefono);

     // Pedir información adicional para el cálculo de la matrícula
     System.out.println("¿El estudiante realiza su curso en línea? (true/false):");
     boolean enLinea = scanner.nextBoolean();
     System.out.println("¿El estudiante aplaza materias? (true/false):");
     boolean aplazaMaterias = scanner.nextBoolean();
     System.out.println("Ingrese el semestre actual del estudiante:");
     int semestre = scanner.nextInt();

     // Calcular y mostrar el recibo de inscripción
     double montoMatricula = estudiante.calcularMatricula(semestre, enLinea, aplazaMaterias);
     estudiante.imprimirRecibo(montoMatricula);

     scanner.close();
 }
}

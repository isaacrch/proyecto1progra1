package proyecto1_progra1;

import java.util.Scanner;

public class estudiantes {

    static String[] nombre = new String[10];
    static long[] cedula = new long[10];
    static float[] nota = new float[10];
    static int indice = 0;
    static String[] condicion = new String[10];
    private static Scanner leer = new Scanner(System.in);

    public estudiantes() {
    }

    public static void inicializar() {

        for (int i = 0; i < nombre.length; i++) {

            nombre[i] = "";
            cedula[i] = 0;
            nota[i] = 0;
            condicion[i] = "";

        }
        System.out.println("*** arreglos han sido inicializados ***");
    }

    public static void submenu() {
        byte opcion = 0;
        do {
            System.out.println("1-reporte estudiantes por condicion");
            System.out.println("2-reporte todos los datos");
            System.out.println("3-regresar al menu principal");
            opcion = leer.nextByte();
            switch (opcion) {
                case 1:
                    reporteestudientesporcondicion();
                    break;
                case 2:
                    reportetodosestudiantes();
                    break;
                case 3:
                    System.out.println("Regresando al menu principal...");
                    return;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
        } while (true);
    }

    public static void reporteestudientesporcondicion() {

        System.out.println("Ingrese la condicion que desea buscar: ");
        String condicionBuscada = leer.next().toUpperCase();
        boolean existeEstudiante = false;
        for (int i = 0; i < indice; i++) {
            if (condicion[i].equalsIgnoreCase(condicionBuscada)) {
                System.out.println("Cedula: " + cedula[i] + ", Nombre: " + nombre[i] + ", Nota: " + nota[i] + ", Condicion: " + condicion[i]);
                existeEstudiante = true;
            }
        }
        if (!existeEstudiante) {
            System.out.println("No se encontraron estudiantes con la condicion buscada.");
        }
    }

    public static void reportetodosestudiantes() {

        float sumaNotas = 0;
        int cantidadEstudiantes = 0;

        for (int i = 0; i < nota.length; i++) {
            if (nota[i] != 0) {
                sumaNotas += nota[i];
                cantidadEstudiantes++;
            } else {
                indice = 0;
            }
        }

        float promedio = 0;
        if (cantidadEstudiantes > 0) {
            promedio = sumaNotas / cantidadEstudiantes;
        }

        System.out.println("Cantidad de estudiantes: " + cantidadEstudiantes);
        System.out.println("Promedio de notas: " + promedio);

        for (int i = 0; i < nombre.length; i++) {
            if (nota[i] != 0) {
                System.out.println("Estudiante: " + nombre[i] + " Cedula: " + cedula[i] + " Nota: " + nota[i] + " Condicion: " + condicion[i]);

                if (nota[i] > promedio) {
                    System.out.println("Esta nota es mayor al promedio");
                } else if (nota[i] < promedio) {
                    System.out.println("Esta nota es menor al promedio");
                } else {
                    System.out.println("Esta nota es igual al promedio");
                }
            }
        }
    }

    public static void buscarestudiantes() {

        System.out.println("ingrese el numero de cedula del estudiante ");
        float ced = leer.nextFloat();

        boolean existe = false;

        for (int i = 0; i < nombre.length; i++) {
            if (ced == cedula[i]) {
                System.out.println(" cedula: " + cedula[i] + " nombre: " + nombre[i] + " nota: " + nota[i] + " condicion: " + condicion[i]);
                existe = true;
                break;
            }
        }
        if (existe == false) {
            System.out.println("el estudiante no existe");
        }
    }

    public static void modificarestudiantes() {
        System.out.println("ingrese el numero de cedula del estudiante");
        long ced = leer.nextLong();
        Scanner leer = new Scanner(System.in);
        boolean existe = false;

        for (int i = 0; i < nombre.length; i++) {
            if (ced == cedula[i]) {
                System.out.println("digite otro nombre");
                nombre[i] = leer.next();
                System.out.println("digite otra nota ");
                nota[i] = leer.nextFloat();
                System.out.println("digite otra cedula");
                cedula[i] = leer.nextLong();
                System.out.println("estudiante modificado");
                existe = true;
                break;
            }
        }
        if (existe == false) {
            System.out.println("el estudiante no existe");
        }
    }

    public static void borrarestudiante() {
        System.out.println("ingrese el numero de cedula del estudiante");
        long ced = leer.nextLong();

        boolean existe = false;

        for (int i = 0; i < cedula.length; i++) {
            if (ced == cedula[i]) {
                nombre[i] = "";
                nota[i] = 0;
                cedula[i] = 0;
                System.out.println("estudiante borrado");
                existe = true;
                break;
            }
        }
        if (existe == false) {
            System.out.println("el estudiante no existe");
        }
    }

    public static void agregarestudiantes() {

        char continuar = 'n';
        Scanner leer = new Scanner(System.in);
        do {
            if (indice > 9) {
                System.out.println("arreglo lleno");
                continuar = 'n';
            } else {
                System.out.println("digite el nombre del estudiante: ");
                nombre[indice] = leer.next();
                System.out.println("digite el numero de cedula: ");
                cedula[indice] = leer.nextLong();
                System.out.println("digite la nota: ");
                nota[indice] = leer.nextFloat();

                if (nota[indice] >= 70) {
                    condicion[indice] = "APROBADO";
                } else if (nota[indice] >= 60) {
                    condicion[indice] = "APLAZADO";
                } else {
                    condicion[indice] = "REPROBADO";
                }

                indice++;

                
                System.out.println("desea ingresar otro estudiante: ");
                continuar = leer.next().toLowerCase().charAt(0);

            }
        } while (continuar != 'n');

    }

}

package proyecto1_progra1;
import java.util.Scanner;

public class menu {

    private byte opcion;
    public Scanner leer = new Scanner(System.in);

    public menu() {

        opcion = 0;
    }

    public void mostrar() {

        do {
            System.out.println("1-inicializar arreglos");
            System.out.println("2-incluir estudiantes");
            System.out.println("3-consultar estudiantes");
            System.out.println("4-desea modificar algun estudiante");
            System.out.println("5-eliminar estudiantes");
            System.out.println("6-submenu reportes");
            System.out.println("7-salir");
            System.out.println("digite una opcion");
            opcion = leer.nextByte();
            switch (opcion) {
                case 1:estudiantes.inicializar();

                    break;

                case 2:estudiantes.agregarestudiantes();

                    break;
                case 3:estudiantes.buscarestudiantes();

                    break;
                case 4:estudiantes.modificarestudiantes();

                    break;
                case 5:estudiantes.borrarestudiante();

                    break;
                    case 6:estudiantes.submenu();
                    break;
                default:
                    throw new AssertionError();
            }

        } while (opcion != 7);

    }

}

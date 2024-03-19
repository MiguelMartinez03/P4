import java.util.Scanner;

public class SimpleAgenda {
    private String[] contactos = new String[10];
    private int numContactos = 0;
    private Scanner scanner = new Scanner(System.in);

    public void agregarContacto() {
        System.out.println("Ingrese un contacto a agregar:");
        String nuevoContacto = scanner.nextLine();

        if (buscarContacto(nuevoContacto) != -1) {
            System.out.println("Ya se ha agregado anteriormente.");
        } else {
            if (numContactos < contactos.length) {
                contactos[numContactos] = nuevoContacto;
                numContactos++;
                System.out.println("Agregado satisfactoriamente.");
            } else {
                System.out.println("La agenda está llena. No se puede agregar más contactos.");
            }
        }
    }

    public void removerContacto() {
        System.out.println("Ingrese el contacto a remover:");
        String contactoRemover = scanner.nextLine();

        int indice = buscarContacto(contactoRemover);
        if (indice != -1) {
            System.out.println("El contacto \"" + contactos[indice] + "\" fue removido exitosamente!");
            contactos[indice] = null;
            numContactos--;
        } else {
            System.out.println("No existe tal contacto.");
        }
    }

    public void mostrarContacto() {
        System.out.println("Ingrese el contacto a mostrar:");
        String contactoMostrar = scanner.nextLine();

        int indice = buscarContacto(contactoMostrar);
        if (indice != -1) {
            System.out.println("El contacto \"" + contactos[indice] + "\".");
        } else {
            System.out.println("No existen registros de este contacto.");
        }
    }

    public void mostrarContactos() {
        System.out.println("Mostrando contactos...");
        for (String contacto : contactos) {
            if (contacto != null) {
                System.out.println(contacto);
            }
        }
    }

    private int buscarContacto(String contacto) {
        for (int i = 0; i < numContactos; i++) {
            if (contactos[i] != null && contactos[i].equals(contacto)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SimpleAgenda agenda = new SimpleAgenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Remover contacto");
            System.out.println("3. Mostrar contacto");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agenda.agregarContacto();
                    break;
                case 2:
                    agenda.removerContacto();
                    break;
                case 3:
                    agenda.mostrarContacto();
                    break;
                case 4:
                    agenda.mostrarContactos();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}

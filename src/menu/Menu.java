package menu;

public class Menu {
    protected int capacidad_agenda = 10;
    private Persona[] agenda;
    protected int cantidadPersonas;

    public Menu() {
        agenda = new Persona[capacidad_agenda];
        cantidadPersonas = 0;
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("------ Menu ------");
            System.out.println("1. Leer los datos de una persona y guardarla en la agenda");
            System.out.println("2. Buscar una persona por su documento");
            System.out.println("3. Listar todas las personas");
            System.out.println("4. Terminar el programa");
            System.out.print("Ingrese la opción deseada: ");
            opcion = Consola.leerEntero();

            switch (opcion) {
                case 1:
                    leerDatosPersona();
                    break;
                case 2:
                    buscarPersonaPorDocumento();
                    break;
                case 3:
                    listarPersonas();
                    break;
                case 4:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 4);
    }

    private void leerDatosPersona() {
        if (cantidadPersonas >= capacidad_agenda) {
            System.out.println("La agenda está llena. No se pueden agregar más personas.\n");
            return;
        }

        System.out.println("\n--- Ingrese los datos de la persona ---");

        System.out.print("Nombre: ");
        String nombre = Consola.leerCadena();

        System.out.print("Apellido: ");
        String apellido = Consola.leerCadena();

        System.out.print("Documento: ");
        String documento = Consola.leerCadena();

        System.out.print("Fecha de nacimiento: ");
        String fechaNacimiento = Consola.leerCadena();

        agenda[cantidadPersonas] = new Persona(nombre, apellido, documento, fechaNacimiento);
        cantidadPersonas++;

        System.out.println("¡Persona agregada a la agenda!\n");
    }

    private void buscarPersonaPorDocumento() {
        System.out.println("\n--- Buscar persona por documento ---");

        System.out.print("Ingrese el número de documento: ");
        String documento = Consola.leerCadena();

        for (int i = 0; i < cantidadPersonas; i++) {
            if (agenda[i].getDocumento().equals(documento)) {
                System.out.println("Persona encontrada:");
                System.out.println(agenda[i]);
                return;
            }
        }

        System.out.println("No se encontró ninguna persona con ese documento.\n");
    }

    private void listarPersonas() {
        System.out.println("\n--- Lista de personas ---");

        if (cantidadPersonas == 0) {
            System.out.println("No hay personas en la agenda.\n");
            return;
        }

        for (int i = 0; i < cantidadPersonas; i++) {
            System.out.println(agenda[i]);
        }

        System.out.println();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Matías");
        Usuario usuario2 = new Usuario("Lautaro");
        Usuario usuario3 = new Usuario("Alejandro");

        Tarea tarea1 = new Tarea("Diseñar base de datos", usuario3);
        Subtarea subtarea1 = new Subtarea("Crear tablas", usuario1);
        Subtarea subtarea2 = new Subtarea("Definir relaciones", usuario2);
        tarea1.agregarSubtarea(subtarea1);
        tarea1.agregarSubtarea(subtarea2);

        Tarea tarea2 = new Tarea("Desarrollar API", usuario2);

        Proyecto proyecto = new Proyecto("Desarrollo de un Sistema");
        proyecto.agregarTarea(tarea1);
        proyecto.agregarTarea(tarea2);

            tarea1.setEstado(new EnProgreso());
            subtarea1.setEstado(new Completada());
            subtarea2.setEstado(new EnProgreso());
            tarea2.setEstado(new Pendiente());

        proyecto.mostrarProyecto();

        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Cambiar estado de una tarea");
            System.out.println("2. Cambiar estado de una subtarea");
            System.out.println("3. Mostrar proyecto");
            System.out.println("4. Salir");

            int seleccion = scanner.nextInt();

            switch (seleccion) {
                case 1:
                    cambiarEstadoTarea(proyecto, scanner);
                    break;
                case 2:
                    cambiarEstadoSubtarea(proyecto, scanner);
                    break;
                case 3:
                    proyecto.mostrarProyecto();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }
    private static void cambiarEstadoSubtarea(Proyecto proyecto, Scanner scanner) {
        System.out.println("\nSeleccione una tarea para ver sus subtareas:");
        for (int i = 0; i < proyecto.getTareas().size(); i++) {
            System.out.println((i + 1) + ". " + proyecto.getTareas().get(i).getDescripcion());
        }

        int seleccionTarea = scanner.nextInt();
        if (seleccionTarea > 0 && seleccionTarea <= proyecto.getTareas().size()) {
            Tarea tarea = proyecto.getTareas().get(seleccionTarea - 1);
            System.out.println("Seleccione una subtarea para cambiar su estado:");
            for (int i = 0; i < tarea.getSubtareas().size(); i++) {
                System.out.println((i + 1) + ". " + tarea.getSubtareas().get(i).getDescripcion());
            }

            int seleccionSubtarea = scanner.nextInt();
            if (seleccionSubtarea > 0 && seleccionSubtarea <= tarea.getSubtareas().size()) {
                Subtarea subtarea = tarea.getSubtareas().get(seleccionSubtarea - 1);
                cambiarEstado(subtarea, scanner);
            } else {
                System.out.println("Selección no válida.");
            }
        } else {
            System.out.println("Selección no válida.");
        }
    }

    private static void cambiarEstado(Tarea tarea, Scanner scanner) {
        System.out.println("Seleccione el nuevo estado:");
        System.out.println("1. Pendiente");
        System.out.println("2. En Progreso");
        System.out.println("3. Completada");

        int estadoSeleccionado = scanner.nextInt();
        switch (estadoSeleccionado) {
            case 1:
                tarea.setEstado(new Pendiente());
                break;
            case 2:
                tarea.setEstado(new EnProgreso());
                break;
            case 3:
                tarea.setEstado(new Completada());
                break;
            default:
                System.out.println("Selección no válida.");
        }
    }
    private static void cambiarEstadoTarea(Proyecto proyecto, Scanner scanner) {
        System.out.println("\nSeleccione una tarea para cambiar su estado:");
        for (int i = 0; i < proyecto.getTareas().size(); i++) {
            System.out.println((i + 1) + ". " + proyecto.getTareas().get(i).getDescripcion());
        }

        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= proyecto.getTareas().size()) {
            Tarea tarea = proyecto.getTareas().get(seleccion - 1);
            cambiarEstado(tarea, scanner);
        } else {
            System.out.println("Selección no válida.");
        }
    }

}

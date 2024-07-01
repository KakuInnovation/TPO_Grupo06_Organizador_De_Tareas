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
        Subtarea subtarea3 = new Subtarea("Conectar middleware", usuario2);
        Subtarea subtarea4 = new Subtarea("Definir protocolo", usuario3);
        Subtarea subtarea5 = new Subtarea("Permisos de accesos", usuario3);
        tarea2.agregarSubtarea(subtarea3);
        tarea2.agregarSubtarea(subtarea4);
        tarea2.agregarSubtarea(subtarea5);

        Proyecto proyecto = new Proyecto("Desarrollo de un Sistema");
        proyecto.agregarTarea(tarea1);
        proyecto.agregarTarea(tarea2);

        tarea1.setEstado(new EnProgreso());
        subtarea1.setEstado(new Completada());
        subtarea2.setEstado(new EnProgreso());

        subtarea3.setEstado(new EnProgreso());
        subtarea4.setEstado(new Pendiente());
        subtarea5.setEstado(new Completada());
        tarea2.setEstado(new EnProgreso());

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
}

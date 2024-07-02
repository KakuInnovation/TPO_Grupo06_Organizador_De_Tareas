import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Proyecto proyecto = null;
        int opcion = 1;
        int menu1;
        boolean salir = false;
/*        Usuario usuario1 = new Usuario("Matías");
        Usuario usuario2 = new Usuario("Lautaro");
        Usuario usuario3 = new Usuario("Alejandro");

        Tarea tarea1 = new Tarea("Diseñar base de datos", usuario3);
        Subtarea subtarea1 = new Subtarea("Crear tablas", usuario1);
        Subtarea subtarea2 = new Subtarea("Definir relaciones", usuario2);
        tarea1.agregarSubtarea(subtarea1);
        tarea1.agregarSubtarea(subtarea2);

        Tarea tarea2 = new Tarea("Desarrollar API", usuario2);

        // Instancia Singleton
        Proyecto proyecto = Proyecto.getProyecto("Desarrollo de un Sistema");
        proyecto.agregarTarea(tarea1);
        proyecto.agregarTarea(tarea2);

        tarea1.setEstado(new EnProgreso());
        subtarea1.setEstado(new Completada());
        subtarea2.setEstado(new EnProgreso());
        tarea2.setEstado(new Pendiente());

        proyecto.mostrarProyecto();*/
// Recupero txt ingresado por Usuario
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
// Muestra Menu
        while (!salir) {
            System.out.println("\n---------------------------------");
            System.out.println("--------- MENÚ PRINCIPAL --------");
            System.out.println("---------------------------------");
            System.out.println("Seleccione una opción: ");
            System.out.println("    1. Gestión de Proyecto");
            System.out.println("    2. Gestión de Tareas");
            System.out.println("    3. Gestión de Responsables");
            System.out.println("    4. Salir");
            System.out.println("---------------------------------");

            try {
                menu1 = scanner.nextInt();

                switch (menu1) {
                    case 1: //1) GESTION DE PROYECTO
                        System.out.println("\n---------------------------------");
                        System.out.println("------ GESTIÓN DE PROYECTO ------");
                        System.out.println("---------------------------------");
                        System.out.println("Seleccione una opción: ");
                        System.out.println("    1. Crear Proyecto");
                        System.out.println("    2. Modificar Nombre del Proyecto");
                        System.out.println("    3. Eliminar Proyecto");
                        System.out.println("    4. Visualizar Proyecto");
                        System.out.println("    5. Volver");
                        System.out.println("---------------------------------");

                        try {
                            menu1 = scanner.nextInt();

                            switch (menu1) {
                                case 1:
                                    System.out.println("\nIngrese el Nombre del Proyecto a crear: ");
                                    String nombreProyecto = scanner.next();
                                    // Instancia Singleton
                                    proyecto = Proyecto.getProyecto(nombreProyecto);
                                    break;
                                case 2:
                                    System.out.println("\nIngrese el nuevo Nombre del Proyecto: ");
                                    String newNombreProyecto = scanner.next();
                                    proyecto.setNombre(newNombreProyecto);
                                    break;
                                case 3:
                                    System.out.println("\n¿SEGURO QUIERE ELIMINAR EL PROYECTO?");
                                    System.out.println("Presione 1 para eliminar.");
                                    menu1 = scanner.nextInt();
                                    if (menu1 == 1) {
                                        proyecto = null;
                                        System.out.println("\nEl Proyecto fue Eliminado.");
                                    }
                                    break;
                                case 4:
                                    try {
                                        proyecto.mostrarProyecto();
                                    } catch (NullPointerException e) {
                                        System.out.println("No existe un Proyecto creado");
                                    }
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Opción no válida, intente nuevamente.");
                            }
                            break;
                        } catch (InputMismatchException e){
                            System.out.println("Debes insertar un número");
                            scanner.next();
                        }
                    case 2: //2) GESTIÓN DE TAREA
                        System.out.println("\n---------------------------------");
                        System.out.println("------- GESTIÓN DE TAREAS -------");
                        System.out.println("---------------------------------");
                        System.out.println("Seleccione una opción: ");
                        System.out.println(" 1. Crear Tarea");
                        System.out.println(" 2. Modificar Tarea");
                        System.out.println(" 3. Eliminar Tarea");
                        System.out.println(" 4. Volver");
                        System.out.println("---------------------------------");

                        menu1 = scanner.nextInt();

                        switch (menu1) {
                            case 1: //1. Crear Tarea
                                //Validamos que exista el Proyecto
                                try {
                                    proyecto.getNombre();
                                } catch (NullPointerException e) {
                                    System.out.println("No existe un Proyecto creado.");
                                    break;
                                }
                                while (opcion == 1) {
                                    // Creación de Tareas
                                    System.out.println("\nIngrese el Nombre de la Tarea a crear: ");
                                    String nombreTarea = scanner.next();
                                    System.out.println("\nIngrese el nombre del Responsable de la Tarea: ");
                                    String nombreResponsable = scanner.next();
                                    Usuario usuario = new Usuario(nombreResponsable);
                                    Tarea tarea = new Tarea(nombreTarea, usuario);
                                    proyecto.agregarTarea(tarea);
                                    tarea.setEstado(new Pendiente());
                                    while (opcion == 1) {
                                        // Creación de Subtareas
                                        System.out.println("\nIngrese el Nombre de la SubTarea a crear: ");
                                        String nombreSubTarea = scanner.next();
                                        System.out.println("\nIngrese el nombre del Responsable de la Subtarea: ");
                                        String nombreRespSubtarea = scanner.next();
                                        Usuario usuarioSubtarea = new Usuario(nombreRespSubtarea);
                                        Subtarea subtarea = new Subtarea(nombreSubTarea, usuarioSubtarea);
                                        tarea.agregarSubtarea(subtarea);
                                        subtarea.setEstado(new Pendiente());
                                        System.out.println("\n¿Quiere agregar otra Subtarea?");
                                        System.out.println("1 - SI | 2 - NO");
                                        opcion = scanner.nextInt();
                                    }
                                    System.out.println("\n¿Quiere agregar otra Tarea?");
                                    System.out.println("1 - SI | 2 - NO");
                                    opcion = scanner.nextInt();
                                }
                                proyecto.mostrarProyecto();
                                System.out.println("\nEl Proyecto fue actualizado satisfactoriamente.");
                                break;
                            case 2: //2. Modificar Tarea
                                proyecto.mostrarProyecto();
                                System.out.println("\nIngrese el nombre de la tarea a editar: ");
                                String newNombreProyecto = scanner.next();
                                proyecto.setNombre(newNombreProyecto);
                                break;
                            case 3: //3. Eliminar Tarea
                                System.out.println("\n¿SEGURO QUIERE ELIMINAR EL PROYECTO?");
                                System.out.println("Ingrese 1 para eliminar.");
                                menu1 = scanner.nextInt();
                                if (menu1 == 1) {
                                    proyecto = null;
                                    System.out.println("\nEl Proyecto fue Eliminado.");
                                }
                                break;
                            case 4: //4. Volver
                                try {
                                    proyecto.mostrarProyecto();
                                } catch (NullPointerException e) {
                                    System.out.println("No existe un Proyecto creado");
                                }
                                break;
                            default:
                                System.out.println("Opción no válida, intente nuevamente.");
                        }
                        break;
                    case 3: //3) GESTIÓN DE RESPONSABLES
                        System.out.println("\n---------------------------------");
                        System.out.println("---- GESTIÓN DE RESPONSABLES ----");
                        System.out.println("---------------------------------");
                        System.out.println("\nSeleccione una opción: ");
                        System.out.println("    1. Crear Responsable");
                        System.out.println("    2. Modificar Nombre del Responsable");
                        System.out.println("    3. Eliminar Responsable");
                        System.out.println("    4. Volver");
                        System.out.println("---------------------------------");

                        menu1 = scanner.nextInt();

                        switch (menu1) {
                            case 1: //1. Crear Responsable
                                //Validamos que exista el Proyecto
                                try {
                                    proyecto.getNombre();
                                } catch (NullPointerException e) {
                                    System.out.println("No existe un Proyecto creado.");
                                    break;
                                }
                                System.out.println("\nIngrese el Nombre de la Tarea a crear: ");
                                String nombreTarea = scanner.next();
                                System.out.println("\nIngrese el nombre del Responsable de la Tarea: ");
                                String nombreResponsable = scanner.next();
                                Usuario usuario = new Usuario(nombreResponsable);
                                Tarea tarea = new Tarea(nombreTarea, usuario);
                                tarea.setEstado(new Pendiente());
                                proyecto.agregarTarea(tarea);
                                break;
                            case 2: //2. Modificar Tarea
                                System.out.println("\nIngrese el nuevo Nombre del Proyecto: ");
                                String newNombreProyecto = scanner.next();
                                proyecto.setNombre(newNombreProyecto);
                                break;
                            case 3: //3. Eliminar Tarea
                                System.out.println("\n¿SEGURO QUIERE ELIMINAR EL PROYECTO?");
                                System.out.println("Ingrese 1 para eliminar.");
                                menu1 = scanner.nextInt();
                                if (menu1 == 1) {
                                    proyecto = null;
                                    System.out.println("\nEl Proyecto fue Eliminado.");
                                }
                                break;
                            case 4: //4. Volver
                                try {
                                    proyecto.mostrarProyecto();
                                } catch (NullPointerException e) {
                                    System.out.println("No existe un Proyecto creado");
                                }
                                break;
                            default:
                                System.out.println("Opción no válida, intente nuevamente.");
                        }
                        break;
                    case 4:
                        System.out.println("Saliendo...");
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida, intente nuevamente.");
                }
            } catch (InputMismatchException e){
                System.out.println("Debes insertar un número");
                scanner.next();
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

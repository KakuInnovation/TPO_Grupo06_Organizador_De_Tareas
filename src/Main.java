import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Proyecto proyecto = null;
        int opcion = 1;
        int menu1;
        boolean salir = false;

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
            System.out.println("    3. Gestión de Subtareas");
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
                                    if (nombreProyecto.isEmpty()) {
                                        System.out.println("El nombre del Proyecto no puede estar vacio");
                                        break;
                                    }
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
                        System.out.println(" 4. Editar Responsable");
                        System.out.println(" 5. Volver");
                        System.out.println("---------------------------------");

                        try {
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
                                    opcion = 1;
                                    while (opcion == 1) {
                                        // Creación de Tareas
                                        System.out.println("\nIngrese el Nombre de la Tarea a crear: ");
                                        String nombreTarea = scanner.next();
                                        while (nombreTarea.isEmpty()) {
                                            System.out.println("\nIngrese el Nombre de la Tarea a crear: ");
                                            nombreTarea = scanner.next();
                                            }
                                        System.out.println("\nIngrese el nombre del Responsable de la Tarea: ");
                                        String nombreResponsable = scanner.next();
                                        while (nombreResponsable.isEmpty()) {
                                            System.out.println("\nIngrese el nombre del Responsable de la Tarea: ");
                                            nombreResponsable = scanner.next();
                                        }
                                        Usuario usuario = new Usuario(nombreResponsable);
                                        Tarea tarea = new Tarea(nombreTarea, usuario);
                                        proyecto.agregarTarea(tarea);
                                        tarea.setEstado(new Pendiente());
                                        while (opcion == 1) {
                                            // Creación de Subtareas
                                            System.out.println("\nIngrese el Nombre de la SubTarea a crear: ");
                                            String nombreSubTarea = scanner.next();
                                            while (nombreSubTarea.isEmpty()) {
                                                System.out.println("\nIngrese el Nombre de la SubTarea a crear: ");
                                                nombreSubTarea = scanner.next();
                                            }
                                            System.out.println("\nIngrese el nombre del Responsable de la Subtarea: ");
                                            String nombreRespSubtarea = scanner.next();
                                            while (nombreRespSubtarea.isEmpty()) {
                                                System.out.println("\nIngrese el nombre del Responsable de la Subtarea: ");
                                                nombreRespSubtarea = scanner.next();
                                            }
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
                                    String nombreTarea = scanner.next();
                                    Tarea tarea = proyecto.getTarea(nombreTarea);
                                    if (tarea != null) {
                                        System.out.println("\n---------------------------------");
                                        System.out.println("-------- MODIFICAR TAREA --------");
                                        System.out.println("---------------------------------");
                                        System.out.println("Seleccione una opción: ");
                                        System.out.println(" 1. Modificar Nombre");
                                        System.out.println(" 2. Modificar Responsable");
                                        System.out.println(" 3. Volver");
                                        System.out.println("---------------------------------");

                                        try {
                                            menu1 = scanner.nextInt();

                                            switch (menu1){
                                                case 1: //1. Modificar Nombre
                                                    System.out.print("Ingrese el nombre de la Tarea a editar: ");
                                                    String newNombreTarea = scanner.next();
                                                    tarea.setDescripcion(newNombreTarea);
                                                    proyecto.mostrarProyecto();
                                                    break;
                                                case 2:
                                                    System.out.print("Ingrese el nombre del Responsable a editar: ");
                                                    String newNombreResp = scanner.next();
                                                    Usuario usuario = new Usuario(newNombreResp);
                                                    tarea.setAsignadoA(usuario);
                                                    proyecto.mostrarProyecto();
                                                    break;
                                                case 3:
                                                    break;
                                                default:
                                                    System.out.println("Opción no válida, intente nuevamente.");
                                            }
                                        }catch (InputMismatchException e) {
                                            System.out.println("Debes insertar un número");
                                            scanner.next();
                                        }
                                    }else {
                                        System.out.println("Tarea no encontrada.");
                                    }
                                    break;
                                case 3: //3. Eliminar Tarea
                                    System.out.print("Ingrese el nombre de la tarea a eliminar: ");
                                    nombreTarea = scanner.next();
                                    proyecto.eliminarTarea(nombreTarea);
                                    System.out.println("Tarea eliminada exitosamente.");

                                    break;
                                case 4: //4. Editar responsable
                                    proyecto.mostrarProyecto();
                                    System.out.println("\nIngrese el nombre de la tarea a editar: ");
                                    nombreTarea = scanner.next();
                                    Tarea tarea2 = proyecto.getTarea(nombreTarea);
                                    if (tarea2 != null) {
                                        System.out.println("Ingrese el nombre del nuevo Responsable: ");
                                        String nuevoResponsable = scanner.next();
                                        Usuario usuario = new Usuario(nuevoResponsable);
                                        tarea2.setAsignadoA(usuario);
                                    }
                                    proyecto.mostrarProyecto();
                                    break;
                                case 5: //5. Volver
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
                        } catch (InputMismatchException e){
                            System.out.println("Debes insertar un número");
                            scanner.next();
                        }
                    case 3: //3) GESTIÓN DE SUBTAREAS
                        System.out.println("\n---------------------------------");
                        System.out.println("----- GESTIÓN DE SUBTAREAS ------");
                        System.out.println("---------------------------------");
                        System.out.println("Seleccione una opción: ");
                        System.out.println(" 1. Crear Subtarea");
                        System.out.println(" 2. Modificar Subtarea");
                        System.out.println(" 3. Eliminar Subtarea");
                        System.out.println(" 4. Volver");
                        System.out.println("---------------------------------");

                        try {
                            menu1 = scanner.nextInt();

                            switch (menu1) {
                                case 1: //1. Crear Subtarea
                                    //Validamos que exista el Proyecto
                                    try {
                                        proyecto.getNombre();
                                    } catch (NullPointerException e) {
                                        System.out.println("No existe un Proyecto creado.");
                                        break;
                                    }
                                    proyecto.mostrarProyecto();

                                    System.out.println("\nIngrese el Nombre de la Tarea a la que se le agregará la nueva Subtarea: ");
                                    String nombreTarea = scanner.next();
                                    while (nombreTarea.isEmpty()) {
                                        System.out.println("\nIngrese el Nombre de la Tarea a la que se le agregará la nueva Subtarea: ");
                                        nombreTarea = scanner.next();
                                    }
                                    Tarea tarea = proyecto.getTarea(nombreTarea);
                                    opcion = 1;
                                    while (opcion == 1) {
                                        // Creación de Subtareas
                                        System.out.println("\nIngrese el Nombre de la SubTarea a crear: ");
                                        String nombreSubTarea = scanner.next();
                                        while (nombreSubTarea.isEmpty()) {
                                            System.out.println("\nIngrese el Nombre de la SubTarea a crear: ");
                                            nombreSubTarea = scanner.next();
                                        }
                                        System.out.println("\nIngrese el nombre del Responsable de la Subtarea: ");
                                        String nombreRespSubtarea = scanner.next();
                                        while (nombreRespSubtarea.isEmpty()) {
                                            System.out.println("\nIngrese el nombre del Responsable de la Subtarea: ");
                                            nombreRespSubtarea = scanner.next();
                                        }
                                        Usuario usuarioSubtarea = new Usuario(nombreRespSubtarea);
                                        Subtarea subtarea = new Subtarea(nombreSubTarea, usuarioSubtarea);
                                        tarea.agregarSubtarea(subtarea);
                                        subtarea.setEstado(new Pendiente());
                                        if (!tarea.subtareasCompletadas()) {
                                            tarea.setEstado(new Pendiente());
                                        }
                                        System.out.println("\n¿Quiere agregar otra Subtarea?");
                                        System.out.println("1 - SI | 2 - NO");
                                        opcion = scanner.nextInt();
                                    }

                                    proyecto.mostrarProyecto();
                                    System.out.println("\nEl Proyecto fue actualizado satisfactoriamente.");
                                    break;
                                case 2: //2. Modificar Subtarea
                                    proyecto.mostrarProyecto();

                                    System.out.println("\nIngrese el Nombre de la Tarea que contiene la subtarea a modificar: ");
                                    String nomTarea = scanner.next();
                                    while (nomTarea.isEmpty()) {
                                        System.out.println("\nIngrese el Nombre de la Tarea que contiene la subtarea a modificar: ");
                                        nomTarea = scanner.next();
                                    }
                                    try {
                                        Tarea task = proyecto.getTarea(nomTarea);

                                        System.out.println("\nIngrese el nombre de la Subtarea a editar: ");
                                        String nombreSubtarea = scanner.next();
                                        Subtarea subtarea = task.getSubtarea(nombreSubtarea);

                                        if (subtarea != null) {
                                            System.out.println("\n---------------------------------");
                                            System.out.println("------ MODIFICAR SUBTAREA -------");
                                            System.out.println("---------------------------------");
                                            System.out.println("Seleccione una opción: ");
                                            System.out.println(" 1. Modificar Nombre");
                                            System.out.println(" 2. Modificar Responsable");
                                            System.out.println(" 3. Modificar Estado");
                                            System.out.println(" 4. Volver");
                                            System.out.println("---------------------------------");

                                            try {
                                                menu1 = scanner.nextInt();

                                                switch (menu1) {
                                                    case 1: //1. Modificar Nombre
                                                        System.out.print("Ingrese el nombre de la Subtarea a editar: ");
                                                        String newNombreSubTarea = scanner.next();
                                                        subtarea.setDescripcion(newNombreSubTarea);
                                                        proyecto.mostrarProyecto();
                                                        break;
                                                    case 2:
                                                        System.out.print("Ingrese el nuevo nombre del Responsable: ");
                                                        String newNombreResp = scanner.next();
                                                        Usuario usuario = new Usuario(newNombreResp);
                                                        subtarea.setAsignadoA(usuario);
                                                        proyecto.mostrarProyecto();
                                                        break;
                                                    case 3:
                                                        System.out.println("\n---------------------------------");
                                                        System.out.println("----- MODIFICAR ESTADO SUBTAREA ------");
                                                        System.out.println("---------------------------------");
                                                        System.out.println("Seleccione una opción: ");
                                                        System.out.println(" 1. Pendiente");
                                                        System.out.println(" 2. Completada");
                                                        System.out.println(" 3. Volver");
                                                        System.out.println("---------------------------------");
                                                        try {
                                                            menu1 = scanner.nextInt();
                                                            switch (menu1) {
                                                                case 1: //1. Modificar Estado Subtarea
                                                                    subtarea.setCompletada(false);
                                                                    task.setEstado(new Pendiente());
                                                                    subtarea.setEstado(new Pendiente());
                                                                    proyecto.mostrarProyecto();
                                                                    break;
                                                                case 2:
                                                                    subtarea.setCompletada(true);
                                                                    subtarea.setEstado(new Completada());
                                                                    if (task.subtareasCompletadas()) {
                                                                        task.setEstado(new Completada());
                                                                    }
                                                                    proyecto.mostrarProyecto();
                                                                    break;
                                                                case 3:
                                                                    break;
                                                                default:
                                                                    System.out.println("Opción no válida, intente nuevamente.");
                                                            }
                                                        } catch (InputMismatchException e) {
                                                            System.out.println("Debes insertar un número");
                                                            scanner.next();
                                                        }
                                                        break;
                                                    case 4:
                                                        break;
                                                    default:
                                                        System.out.println("Opción no válida, intente nuevamente.");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("Debes insertar un número");
                                                scanner.next();
                                            }
                                        } else {
                                            System.out.println("Tarea no encontrada.");
                                        }
                                        break;
                                    }
                                    catch (NullPointerException e){
                                        System.out.println("Tarea no encontrada.");
                                        proyecto.mostrarProyecto();
                                    }
                                case 3: //3. Eliminar Subtarea
                                    proyecto.mostrarProyecto();
                                    System.out.print("Ingrese el nombre de la Tarea donde se encuentra la Subtarea: ");
                                    nombreTarea = scanner.next();
                                    tarea = proyecto.getTarea(nombreTarea);
                                    System.out.print("Ingrese el nombre de la subtarea a eliminar: ");
                                    String nombreSubtarea = scanner.next();
                                    tarea.eliminarSubTarea(nombreSubtarea);
                                    System.out.println("Tarea eliminada exitosamente.");
                                    if (tarea.subtareasCompletadas()) {
                                        tarea.setEstado(new Completada());
                                    }
                                    else
                                        tarea.setEstado(new Pendiente());
                                    proyecto.mostrarProyecto();
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
                        } catch (InputMismatchException e){
                            System.out.println("Debes insertar un número");
                            scanner.next();
                        }
                        break;
                    case 4: //4. SALIR
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

}

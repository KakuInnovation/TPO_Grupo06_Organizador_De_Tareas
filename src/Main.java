public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Alejandro");
        Usuario usuario2 = new Usuario("Matias");

        Tarea tarea1 = new Tarea("Diseñar base de datos", usuario1);
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
    }
}

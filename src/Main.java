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
    }
}

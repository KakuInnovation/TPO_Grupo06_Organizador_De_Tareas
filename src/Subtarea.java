public class Subtarea extends Tarea {

    public Subtarea(String descripcion, Usuario asignadoA) {
        super(descripcion, asignadoA);
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Estado de la subtarea: " + getDescripcion() + " || " + getEstado().getClass().getSimpleName());
    }
}

public class Subtarea extends Tarea {

    public Subtarea(String descripcion, Usuario asignadoA) {
        super(descripcion, asignadoA);
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Nombre Subtarea: " + getDescripcion() + " || " + getEstado().getClass().getSimpleName() + " || " + "Responsable: " + super.getAsignadoA());
    }


}

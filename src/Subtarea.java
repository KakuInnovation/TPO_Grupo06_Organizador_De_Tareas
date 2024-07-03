public class Subtarea extends Tarea {
    private boolean completada;

    private void Subtarea(){
        this.completada = false;
    }

    public Subtarea(String descripcion, Usuario asignadoA) {
        super(descripcion, asignadoA);
        this.completada = false;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Nombre Subtarea: " + getDescripcion() + " || " + getEstado().getClass().getSimpleName() + " || " + "Responsable: " + super.getAsignadoA());
    }

    public String getDescripcion() {
        return super.getDescripcion();
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}

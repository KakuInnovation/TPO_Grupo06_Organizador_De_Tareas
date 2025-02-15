import java.util.ArrayList;
import java.util.List;

public class Tarea implements Estado {
    private String descripcion;
    private Estado estado;
    private Usuario asignadoA;
    private List<Subtarea> subtareas;

    public Tarea(String descripcion, Usuario asignadoA) {
        this.descripcion = descripcion;
        this.asignadoA = asignadoA;
        this.estado = new Pendiente();  // Estado inicial
        this.subtareas = new ArrayList<>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void agregarSubtarea(Subtarea subtarea) {
        subtareas.add(subtarea);
    }

    public List<Subtarea> getSubtareas() {
        return subtareas;
    }

    public String getAsignadoA() {
        return asignadoA.getNombre();
    }

    public void setAsignadoA(Usuario asignadoA) {
        this.asignadoA = asignadoA;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Nombre Tarea: " + descripcion + " | " + "Estado: " + estado.getClass().getSimpleName() + " | " + "Responsable: " + asignadoA.getNombre());
        for (Subtarea subtarea : subtareas) {
            subtarea.mostrarEstado();
        }
    }

    public Subtarea getSubtarea(String nombre) {
        return subtareas.stream()
                .filter(subtarea -> subtarea.getDescripcion().equals(nombre))
                .findFirst()
                .orElse(null);
    }
    public boolean subtareasCompletadas(){
        return subtareas.stream().allMatch(subtarea -> subtarea.isCompletada());
    }
    public void eliminarSubTarea(String nombre) {
        subtareas.removeIf(subtarea-> subtarea.getDescripcion().equals(nombre));
    }
}

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

    @Override
    public void mostrarEstado() {
        System.out.println("Estado de la tarea: " + descripcion + " | " + estado.getClass().getSimpleName());
        for (Subtarea subtarea : subtareas) {
            subtarea.mostrarEstado();
        }
    }
}

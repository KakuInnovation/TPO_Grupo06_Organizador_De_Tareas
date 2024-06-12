import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private List<Tarea> tareas;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void mostrarProyecto() {
        System.out.println("Proyecto: " + nombre);
        for (Tarea tarea : tareas) {
            tarea.mostrarEstado();
        }
    }
}

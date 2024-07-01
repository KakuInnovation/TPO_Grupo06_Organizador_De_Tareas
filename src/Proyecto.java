import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombre;
    private List<Tarea> tareas;
    private static Proyecto miProyecto;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Proyecto getProyecto(String nombre) {
        if (miProyecto == null) {
            miProyecto = new Proyecto(nombre);
        }
        else{
            System.out.println("No se permite la gestión de más de un Proyecto.");
        }
        return miProyecto;
    }

    private Proyecto(String nombre) {
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

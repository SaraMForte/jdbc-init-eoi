package jdbcinit.c02.model;

public class EmpleadoBuilder {
    private int codigoEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String extension;
    private String email;
    private String codigoOficina;
    private Integer codigoJefe; // Puede ser null si no tiene jefe
    private String puesto;

    public Empleado build() {
        Empleado empleado = new Empleado();
        empleado.codigoEmpleado = this.codigoEmpleado;
        empleado.nombre = this.nombre;
        empleado.apellido1 = this.apellido1;
        empleado.apellido2 = this.apellido2;
        empleado.extension = this.extension;
        empleado.email = this.email;
        empleado.codigoOficina = this.codigoOficina;
        empleado.codigoJefe = this.codigoJefe;
        empleado.puesto = this.puesto;

        return empleado;
    }

    public EmpleadoBuilder withCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
        return this;
    }

    public EmpleadoBuilder withNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EmpleadoBuilder withApellido1(String apellido1) {
        this.apellido1 = apellido1;
        return this;
    }

    public EmpleadoBuilder withApellido2(String apellido2) {
        this.apellido2 = apellido2;
        return this;
    }

    public EmpleadoBuilder withExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public EmpleadoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public EmpleadoBuilder withCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
        return this;
    }

    public EmpleadoBuilder withCodigoJefe(int codigoJefe) {
        this.codigoJefe = codigoJefe;
        return this;
    }

    public EmpleadoBuilder withPuesto(String puesto) {
        this.puesto = puesto;
        return this;
    }
}

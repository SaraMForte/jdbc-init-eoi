package jdbcinit.c02.model;

public class Empleado {
    int codigoEmpleado;
    String nombre;
    String apellido1;
    String apellido2;
    String extension;
    String email;
    String codigoOficina;
    Integer codigoJefe; // Puede ser null si no tiene jefe
    String puesto;

    public Empleado() {
    }

    public int codigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String nombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String apellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String apellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String extension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String codigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public Integer codigoJefe() {
        return codigoJefe;
    }

    public void setCodigoJefe(Integer codigoJefe) {
        this.codigoJefe = codigoJefe;
    }

    public String puesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Empleado{" +
               "codigoEmpleado=" + codigoEmpleado +
               ", nombre='" + nombre + '\'' +
               ", apellido1='" + apellido1 + '\'' +
               ", apellido2='" + apellido2 + '\'' +
               ", extension='" + extension + '\'' +
               ", email='" + email + '\'' +
               ", codigoOficina='" + codigoOficina + '\'' +
               ", codigoJefe=" + codigoJefe +
               ", puesto='" + puesto + '\'' +
               '}';
    }
}

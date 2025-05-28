package jdbcinit.e01.persistence.model;

public class Oficina {
    private String codigoOficina;
    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    private String lineaDireccion1;
    private String lineaDireccion2;

    public String codigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String ciudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String pais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String region() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String codigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String telefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String lineaDireccion1() {
        return lineaDireccion1;
    }

    public void setLineaDireccion1(String lineaDireccion1) {
        this.lineaDireccion1 = lineaDireccion1;
    }

    public String lineaDireccion2() {
        return lineaDireccion2;
    }

    public void setLineaDireccion2(String lineaDireccion2) {
        this.lineaDireccion2 = lineaDireccion2;
    }

    @Override
    public String toString() {
        return "Oficina{" + "codigoOficina='" + codigoOficina + '\'' + ", ciudad='" + ciudad + '\'' + ", pais='" + pais + '\'' + ", region='" + region + '\'' + ", codigoPostal='" + codigoPostal + '\'' + ", telefono='" + telefono + '\'' + ", lineaDireccion1='" + lineaDireccion1 + '\'' + ", lineaDireccion2='" + lineaDireccion2 + '\'' + '}';
    }
}

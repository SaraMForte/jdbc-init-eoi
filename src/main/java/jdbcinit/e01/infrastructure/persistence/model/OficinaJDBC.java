package jdbcinit.e01.infrastructure.persistence.model;

import jdbcinit.e01.domain.Office;

public record OficinaJDBC(
        String codigoOficina,
        String ciudad,
        String pais,
        String region,
        String codigoPostal,
        String telefono,
        String lineaDireccion1,
        String lineaDireccion2
) {

    @Override
    public String toString() {
        return "OficinaJDBC{" +
               "codigoOficina='" + codigoOficina + '\'' +
               ", ciudad='" + ciudad + '\'' +
               ", pais='" + pais + '\'' +
               ", region='" + region + '\'' +
               ", codigoPostal='" + codigoPostal + '\'' +
               ", telefono='" + telefono + '\'' +
               ", lineaDireccion1='" + lineaDireccion1 + '\'' +
               ", lineaDireccion2='" + lineaDireccion2 + '\'' +
               '}';
    }

    public Office toOffice() {
        Office office = new Office();
        office.setOfficeCode(codigoOficina);
        office.setCity(ciudad);
        office.setCountry(pais);
        office.setRegion(region);
        office.setPostalCode(codigoPostal);
        office.setPhone(telefono);
        office.setAddressLine1(lineaDireccion1);
        office.setAddressLine2(lineaDireccion2);
        return office;
    }

    public static OficinaJDBC toOficina(Office office) {
        return new OficinaJDBC(
                office.officeCode(),
                office.city(),
                office.country(),
                office.region(),
                office.postalCode(),
                office.phone(),
                office.addressLine1(),
                office.addressLine2()
        );
    }
}



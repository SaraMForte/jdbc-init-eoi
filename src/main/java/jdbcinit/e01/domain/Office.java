package jdbcinit.e01.domain;

public class Office {
    private String officeCode;
    private String city;
    private String country;
    private String region;
    private String postalCode;
    private String phone;
    private String addressLine1;
    private String addressLine2;

    public String officeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String city() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String country() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String region() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String postalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String phone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String addressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String addressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Override
    public String toString() {
        return "Office{" +
               "officeCode='" + officeCode + '\'' +
               ", city='" + city + '\'' +
               ", country='" + country + '\'' +
               ", region='" + region + '\'' +
               ", postalCode='" + postalCode + '\'' +
               ", phone='" + phone + '\'' +
               ", addressLine1='" + addressLine1 + '\'' +
               ", addressLine2='" + addressLine2 + '\'' +
               '}';
    }
}
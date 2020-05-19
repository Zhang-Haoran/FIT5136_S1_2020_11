public class Country {
    private String countryOrigin;
    private String countryAllowed;

    public Country(String countryOrigin, String countryAllowed) {
        this.countryOrigin = countryOrigin;
        this.countryAllowed = countryAllowed;
    }

    public Country() {
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getCountryAllowed() {
        return countryAllowed;
    }

    public void setCountryAllowed(String countryAllowed) {
        this.countryAllowed = countryAllowed;
    }
}

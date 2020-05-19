public class Cargo {
    private String CargoFor;
    private String CargoRequired;
    private int quantityRequired;

    public Cargo(String cargoFor, String cargoRequired, int quantityRequired) {
        CargoFor = cargoFor;
        CargoRequired = cargoRequired;
        this.quantityRequired = quantityRequired;
    }

    public Cargo() {
    }

    public String getCargoFor() {
        return CargoFor;
    }

    public void setCargoFor(String cargoFor) {
        CargoFor = cargoFor;
    }

    public String getCargoRequired() {
        return CargoRequired;
    }

    public void setCargoRequired(String cargoRequired) {
        CargoRequired = cargoRequired;
    }

    public int getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(int quantityRequired) {
        this.quantityRequired = quantityRequired;
    }
}

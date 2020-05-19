public class Shuttle {
    private String name;
    private String manufacturingYear;
    private int fuelCapacity;
    private int cargoCapacity;
    private int travelSpeed;

    public Shuttle(String name, String manufacturingYear, int fuelCapacity, int cargoCapacity, int travelSpeed) {
        this.name = name;
        this.manufacturingYear = manufacturingYear;
        this.fuelCapacity = fuelCapacity;
        this.cargoCapacity = cargoCapacity;
        this.travelSpeed = travelSpeed;
    }

    public Shuttle() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public void setTravelSpeed(int travelSpeed) {
        this.travelSpeed = travelSpeed;
    }
}

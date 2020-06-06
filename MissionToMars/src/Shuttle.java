public class Shuttle {
    private String name;
    private String manufacturingYear;
    private int fuelCapacity;
    private int passengerCapacity;
    private int cargoCapacity;
    private int travelSpeed;

    public Shuttle(String name, String manufacturingYear, int fuelCapacity, int passengerCapacity, int cargoCapacity, int travelSpeed) {
        this.name = name;
        this.manufacturingYear = manufacturingYear;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
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

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getRecord(){
        return this.getName()+ ","+this.getManufacturingYear()+","+ this.getFuelCapacity()+ ","+ this.getCargoCapacity()+","+this.getTravelSpeed()+","+this.getPassengerCapacity();

    }

    //display shuttle details
    public void getPerfectRecord(Shuttle shuttle){
        System.out.println("Shuttle details: ");
        System.out.println("1.Shuttle name: "+ shuttle.getName());
        System.out.println("2.Manufacturing year "+ shuttle.getManufacturingYear());
        System.out.println("3.Fuel capacity: "+ shuttle.getFuelCapacity());
        System.out.println("3.Passenger capacity: "+ shuttle.getPassengerCapacity());
        System.out.println("4.Cargo capacity: "+ shuttle.getCargoCapacity());
        System.out.println("5.Travel speed: "+ shuttle.getTravelSpeed());
    }
}

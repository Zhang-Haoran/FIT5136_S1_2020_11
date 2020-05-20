import java.util.ArrayList;

public class MissionRequest {
    private String name;
    private String description;
    private Country country;
    private Job job;
    private MissionCoordinator missionCoordinator;
    private ArrayList<Employment> listOfEmployment;
    private ArrayList<Cargo> listOfCargo;
    private String launchDate;
    private String destination;
    private String duration;
    private String status;

    public MissionRequest() {
    }

    public MissionRequest(String name, String description, Country country, Job job, MissionCoordinator missionCoordinator, ArrayList<Employment> listOfEmployment, ArrayList<Cargo> listOfCargo, String launchDate, String destination, String duration, String status) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.job = job;
        this.missionCoordinator = missionCoordinator;
        this.listOfEmployment = listOfEmployment;
        this.listOfCargo = listOfCargo;
        this.launchDate = launchDate;
        this.destination = destination;
        this.duration = duration;
        this.status = status;
    }

    public MissionRequest(MissionRequest missionRequest) {
        this.name = missionRequest.name;
        this.description = missionRequest.description;
        this.country = missionRequest.country;
        this.job = missionRequest.job;
        this.missionCoordinator = missionRequest.missionCoordinator;
        this.listOfEmployment = missionRequest.listOfEmployment;
        this.listOfCargo = missionRequest.listOfCargo;
        this.launchDate = missionRequest.launchDate;
        this.destination = missionRequest.destination;
        this.duration = missionRequest.duration;
        this.status = missionRequest.status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public MissionCoordinator getMissionCoordinator() {
        return missionCoordinator;
    }

    public void setMissionCoordinator(MissionCoordinator missionCoordinator) {
        this.missionCoordinator = missionCoordinator;
    }

    public ArrayList<Employment> getListOfEmployment() {
        return listOfEmployment;
    }

    public void setListOfEmployment(ArrayList<Employment> listOfEmployment) {
        this.listOfEmployment = listOfEmployment;
    }

    public ArrayList<Cargo> getListOfCargo() {
        return listOfCargo;
    }

    public void setListOfCargo(ArrayList<Cargo> listOfCargo) {
        this.listOfCargo = listOfCargo;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getRecord(){
        return this.getName()+
                ","+this.getDescription()+
                ","+this.getCountry().getCountryOrigin()+
                ","+this.getCountry().getCountryAllowed()+
                ","+this.getMissionCoordinator().getName()+
                ","+this.getMissionCoordinator().getContactInfo()+
                ","+this.getJob().getName()+
                ","+this.getJob().getDescription()+
                ","+this.getListOfEmployment().get(0).getTitle()+
                ","+this.getListOfEmployment().get(0).getNumberRequired()+
                ","+this.getListOfCargo().get(0).getCargoFor()+
                ","+this.getListOfCargo().get(0).getCargoRequired()+
                ","+this.getListOfCargo().get(0).getQuantityRequired()+
                ","+this.getLaunchDate()+
                ","+this.getDestination()+
                ","+this.getDuration()+
                ","+this.getStatus();
    }
}

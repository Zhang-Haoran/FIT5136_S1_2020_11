import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
        while (!name.matches("^[a-zA-Z ]+$")){

            System.out.println("mission name must be string");
            MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
            name = missionToMarsSystem.userStringInput();
        }
        this.name = name;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        while (!(description.length() >=10)){

            System.out.println("description must at least 10 words long");
            MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
            description = missionToMarsSystem.userStringInput();
        }
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
        Calendar calendar = Calendar.getInstance();// get a calendar using the current time zone and locale of the system. For example today is 10/05/2020, it will get 10,4, 2020
        int calendarYear = calendar.get(Calendar.YEAR);
        int calendarMonth = calendar.get(Calendar.MONTH)+1;
        int caldendarDay = calendar.get(Calendar.DAY_OF_MONTH);
        String currentDate = caldendarDay + "/" + calendarMonth + '/' + calendarYear;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        Date currentDateFormated = new Date();
        while (true){
            try {
                if (
                        (launchDate.matches("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$"))
                        && simpleDateFormat.parse(launchDate).after(currentDateFormated = simpleDateFormat.parse(currentDate))
                )
                    break;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println("launch date must be in the future and format like 01/06/2020. Please try again");
            MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
            launchDate = missionToMarsSystem.userStringInput();
        }

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
        while (!duration.matches("^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{1,2})?$")){

            System.out.println("duration should be in years and two decimal points allowed");
            MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
            duration = missionToMarsSystem.userStringInput();
        }
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

    public void statusDropDownList(){
        ArrayList<String> missionStatusList = new ArrayList<>();
        System.out.println("---Please select from: ");
        missionStatusList.add("Planning phase");
        missionStatusList.add("Departed Earth");
        missionStatusList.add("Landed on Mars");
        missionStatusList.add("Mission in progress");
        missionStatusList.add("Returned to Earth");
        missionStatusList.add("Mission completed");

        for (int i = 0; i< missionStatusList.size();i++){
            System.out.println(i+1+". "+missionStatusList.get(i));;
        }

        MissionToMarsSystem missionToMarsSystem =  new MissionToMarsSystem();
        switch (missionToMarsSystem.userIntegerInput()){
            case 1:
                this.setStatus( missionStatusList.get(0));
                break;
            case 2:
                this.setStatus( missionStatusList.get(1));
                break;
            case 3:
                this.setStatus( missionStatusList.get(2));
                break;
            case 4:
                this.setStatus( missionStatusList.get(3));
                break;
            case 5:
                this.setStatus( missionStatusList.get(4));
                break;
            case 6:
                this.setStatus( missionStatusList.get(5));
                break;
            default:
                System.out.println("Please enter a valid option");
                statusDropDownList();
                break;
        }
    }

}

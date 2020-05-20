import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    public void displayWelcomeMessage(){
        System.out.println("\n");
        System.out.println("******* Welcome to Mission to Mars System! *******");
        System.out.println("--- Please enter the number below to select your option ");
        System.out.println("--- 1. Sign up for new candidates ");
        System.out.println("--- 2. Login to your account");
        System.out.println("--- Enter your option: ");
    }

    public void displayLoginScreen(){
        System.out.println("\n");
        System.out.println("******* Welcome to Mission to Mars System! *******");
        System.out.println("--- Please enter your login credentials");
    }

    public void displayAdministratorScreen(Account account){
        System.out.println("\n");
        System.out.println("******* Welcome "+ account.getUserName() +" to Mission to Mars System! *******");
        System.out.println("Account type: Administrator");
        System.out.println("--- Please enter the number below to select your option ");
        System.out.println("--- 1.View existing missions");
        System.out.println("--- 2.Edit mission");
        System.out.println("--- 3.Select a shuttle");
        System.out.println("--- 4.Create selection criteria");
        System.out.println("--- 5.Edit the criteria");
        System.out.println("--- 6.Find and select best candidates");
        System.out.println("--- 7.Log out");
        System.out.println("--- Enter your option: ");


    }
    public void displayMissionCoordinatorScreen(Account account){
        System.out.println("\n");
        System.out.println("******* Welcome "+ account.getUserName() +" to Mission to Mars System! *******");
        System.out.println("Account type: Mission Coordinator");
        System.out.println("--- Please enter the number below to select your option ");
        System.out.println("--- 1.Create new mission");
        System.out.println("--- 2.View existing missions");
        System.out.println("--- 3.Edit mission");
        System.out.println("--- 4.Log out");
        System.out.println("--- Enter your option: ");
    }


    public void displayCreateMissionMenu() throws ParseException {
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        MissionRequest missionRequest = new MissionRequest();
        System.out.println("\n");
        System.out.println("******* Create new mission *******");
        System.out.println("--- 1. Please enter mission name (Press enter to save)" );
        missionRequest.setName(missionToMarsSystem.userStringInput());
        System.out.println("--- 2. Please enter mission description (Press enter to save)" );
        missionRequest.setDescription(missionToMarsSystem.userStringInput());
        System.out.println("--- 3. Please enter country of origin (Press enter to save)" );
        Country country = new Country();
        country.setCountryOrigin(missionToMarsSystem.userStringInput());
        System.out.println("--- 4. Please enter country allowed (Press enter to save)" );
        country.setCountryAllowed(missionToMarsSystem.userStringInput());
        missionRequest.setCountry(country);
        System.out.println("--- 5. Please enter coordinator's name (Press enter to save)" );
        MissionCoordinator missionCoordinator = new MissionCoordinator();
        missionCoordinator.setName(missionToMarsSystem.userStringInput());
        System.out.println("--- 6. Please enter coordinator's contact information (Press enter to save)" );
        missionCoordinator.setContactInfo(missionToMarsSystem.userStringInput());
        missionRequest.setMissionCoordinator(missionCoordinator);
        System.out.println("--- 7. Please enter job name (Press enter to save)" );
        Job job = new Job();
        job.setName(missionToMarsSystem.userStringInput());
        System.out.println("--- 8. Please enter job description (Press enter to save)" );
        job.setDescription(missionToMarsSystem.userStringInput());
        missionRequest.setJob(job);
        System.out.println("--- 9. Please enter title of employment required (Press enter to save)" );
        ArrayList<Employment> listOfEmployment = new ArrayList<>();
        Employment employment = new Employment();
        employment.setTitle(missionToMarsSystem.userStringInput());
        System.out.println("--- 10. Please enter number of employment required (Press enter to save)" );
        employment.setNumberRequired(missionToMarsSystem.userIntegerInput());
        listOfEmployment.add(employment);
        missionRequest.setListOfEmployment(listOfEmployment);
        System.out.println("--- 11. Please enter cargo for what kind of mission (Press enter to save)" );
        ArrayList<Cargo> listOfCargo = new ArrayList<>();
        Cargo cargo = new Cargo();
        cargo.setCargoFor(missionToMarsSystem.userStringInput());
        System.out.println("--- 12. Please enter cargo required for (Press enter to save)" );
        cargo.setCargoRequired(missionToMarsSystem.userStringInput());
        System.out.println("--- 13. Please enter cargo quantity for (Press enter to save)" );
        cargo.setQuantityRequired(missionToMarsSystem.userIntegerInput());
        listOfCargo.add(cargo);
        missionRequest.setListOfCargo(listOfCargo);
        System.out.println("--- 14. Please enter launch date (date format example: 20/05/2020) " );
        missionRequest.setLaunchDate(missionToMarsSystem.userStringInput());
        System.out.println("--- 15. Please enter location of destination (Press enter to save)" );
        missionRequest.setDestination(missionToMarsSystem.userStringInput());
        System.out.println("--- 16. Please enter duration of mission (Press enter to save)" );
        missionRequest.setDuration(missionToMarsSystem.userStringInput());
        System.out.println("--- 17. Please enter status of mission (Press enter to save)" );
        missionRequest.setStatus(missionToMarsSystem.userStringInput());
        missionToMarsSystem.writeMissionRequestFile(missionRequest);


    }
    public void displayMisssionConfirmation(){
        System.out.println("the mission has successfully been created");
    }
    public void displayMissionSuccessMessage(){}

    public void displayAllMissionNameList(Account account){
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        ArrayList<MissionRequest> listOfMissionRequest = missionToMarsSystem.readMissionRequestFile();
        System.out.println("******* Mission Request List *******");
        System.out.println("Which mission you want to choose?");

        for (int i =0; i< listOfMissionRequest.size();i++){
            System.out.println(i+1+". "+listOfMissionRequest.get(i).getName());
        }
        String userInput = missionToMarsSystem.userStringInput();
        if (userInput.equals("b")){
            missionToMarsSystem.missionCoordinatorMenuControl(account);
        }
        else {
            displayMissionDetails(listOfMissionRequest.get(Integer.parseInt(userInput)));
        }


    }

    public void displayMissionDetails(MissionRequest missionRequest){
        System.out.println("******* "+ missionRequest.getName()+" *******");
        System.out.println("1.Mission name: "+ missionRequest.getName());
        System.out.println("2.Mission description: "+ missionRequest.getDescription());
        System.out.println("3.Country of origin: "+ missionRequest.getCountry().getCountryOrigin());
        System.out.println("4.Country allowed: "+ missionRequest.getCountry().getCountryAllowed());
        System.out.println("5.Coordinator name: "+ missionRequest.getMissionCoordinator().getName());
        System.out.println("6.Coordinator contact information: "+ missionRequest.getMissionCoordinator().getContactInfo());
        System.out.println("7.Job name: "+ missionRequest.getJob().getName());
        System.out.println("8.Job Description: "+ missionRequest.getJob().getDescription());
        System.out.println("9.Title of employment required: "+ missionRequest.getListOfEmployment().get(0).getTitle());
        System.out.println("10.Number of employment required: "+ missionRequest.getListOfEmployment().get(0).getTitle());
        System.out.println("11.Cargo for what kind of mission: "+ missionRequest.getListOfCargo().get(0).getCargoFor());
        System.out.println("13.Cargo required for: "+ missionRequest.getListOfCargo().get(0).getCargoRequired());
        System.out.println("14.Cargo quantity: "+ missionRequest.getListOfCargo().get(0).getQuantityRequired());
        System.out.println("15.Location of destination: "+ missionRequest.getDestination());
        System.out.println("16.Duration: "+ missionRequest.getDuration());
        System.out.println("17.Status of mission: "+ missionRequest.getStatus());
        Scanner scan = new Scanner(System.in);
        System.out.print("Press any key to continue . . . ");
        scan.nextLine();
    }

    public void displayMissionModified(MissionPlan missionPlan){

    }

    public void displayCreateShuttleMenu(Shuttle shuttle){

    }

    public void displayShuttleConfirmation(){

    }

    public void displayCreateCriteriaMenu(Criteria criteria){}
    public void displayCriteriaConfirmation(){}
    public void displayCriteriaDetails(Criteria criteria){}
    public void displayCriteriaModified(){}




}

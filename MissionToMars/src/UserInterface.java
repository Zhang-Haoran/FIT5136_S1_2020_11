import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    //welcome screen
    public void displayWelcomeMessage(){
        System.out.println("\n");
        System.out.println("******* Welcome to Mission to Mars System! *******");
        System.out.println("--- Please enter the number below to select your option ");
        System.out.println("--- 1. Sign up for new candidates ");
        System.out.println("--- 2. Login to your account");
        System.out.println("--- 3. Quit system");
        System.out.println("--- Enter your option (Press Enter to commit your input): ");
    }

    //login screen
    public void displayLoginScreen(){
        System.out.println("\n");
        System.out.println("******* Welcome to Mission to Mars System! *******");
        System.out.println("--- Please enter your login credentials (Press Enter to commit your input):");
    }

    //admin main menu screen
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
        System.out.println("--- Enter your option (Press Enter to commit your input): ");


    }
    //coordinator main menu screen
    public void displayMissionCoordinatorScreen(Account account){
        System.out.println("\n");
        System.out.println("******* Welcome "+ account.getUserName() +" to Mission to Mars System! *******");
        System.out.println("Account type: Mission Coordinator");
        System.out.println("--- Please enter the number below to select your option ");
        System.out.println("--- 1.Create new mission");
        System.out.println("--- 2.View existing missions");
        System.out.println("--- 3.Edit mission");
        System.out.println("--- 4.Log out");
        System.out.println("--- Enter your option (Press Enter to commit your input): ");
    }


    //create mission screen
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
        ArrayList<Employment> listOfEmployment = new ArrayList<>();//can store many employment
        Employment employment = new Employment();//potential problem: only create an employment. should create many and store them in list
        employment.setTitle(missionToMarsSystem.userStringInput());
        System.out.println("--- 10. Please enter number of employment required (Press enter to save)" );
        employment.setNumberRequired(missionToMarsSystem.userIntegerInput());
        listOfEmployment.add(employment); // add new employment into list
        missionRequest.setListOfEmployment(listOfEmployment);
        System.out.println("--- 11. Please enter what the cargo used for (Press enter to save)" );
        ArrayList<Cargo> listOfCargo = new ArrayList<>();//can store many cargo
        Cargo cargo = new Cargo();//potential problem: only create an cargo. should create many and store them in list
        cargo = missionRequest.cargoForDropDownList(cargo);
        System.out.println("--- 12. Please enter what cargo required for (example:concrete, desserts, water)" );
        cargo.setCargoRequired(missionToMarsSystem.userStringInput());
        System.out.println("--- 13. Please enter cargo quantity (Press enter to save)" );
        cargo.setQuantityRequired(missionToMarsSystem.userIntegerInput());
        listOfCargo.add(cargo);//add new cargo into list
        missionRequest.setListOfCargo(listOfCargo);
        System.out.println("--- 14. Please enter launch date (date format example: 28/06/2020) " );
        missionRequest.setLaunchDate(missionToMarsSystem.userStringInput());
        System.out.println("--- 15. Please enter location of destination (Press enter to save)" );
        missionRequest.setDestination(missionToMarsSystem.userStringInput());
        System.out.println("--- 16. Please enter duration of mission in years (input example: 2.15)" );
        missionRequest.setDuration(missionToMarsSystem.userStringInput());
        System.out.println("--- 17. Please enter status of mission (Press enter to save)" );
        missionRequest.statusDropDownList();
        missionToMarsSystem.writeMissionRequestFile(missionRequest);


    }
    //if mission added, give user a feedback
    public void displayMisssionConfirmation(){
        System.out.println("the mission has successfully been created");
    }

    //display all the mission request from database to let user select
    public void displayAllMissionNameList(Account account,String action){
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        ArrayList<MissionRequest> listOfMissionRequest = missionToMarsSystem.readMissionRequestFile();//get all the mission request by reading file
        System.out.println("******* Mission Request List *******");
        System.out.println("Which mission you want to choose?");

        //display each mission request as list
        for (int i =0; i< listOfMissionRequest.size();i++){
            System.out.println(i+1+". "+listOfMissionRequest.get(i).getName());
        }
        System.out.println("Input 0 to go back to previous screen");
        System.out.println("Please input your option (Press Enter to commit your input):");

        int userInput = missionToMarsSystem.userIntegerInput();

        //data validation. let user enter the number with the range
        while (userInput >listOfMissionRequest.size() || userInput <0){
            System.out.println("Please enter a valid number");
            userInput = missionToMarsSystem.userIntegerInput();
        }
        //press b to go back
        if (userInput == 0){
            if (account.getRole().equals("Mission Coordinator")) // check role if it's coordinator to go to coordinator's menu screen
            missionToMarsSystem.missionCoordinatorMenuControl(account);
            else {
                missionToMarsSystem.administratorMenuControl(account);// otherwise go to admin menu screen
            }
        }


        if(action.equals("view")) {//if the incoming parameter is view, display mission detail
            displayMissionDetails(listOfMissionRequest.get(userInput-1)); // -1 to make list index being correct to be select. list start form 0
        }
        else if (action.equals("edit")){//if it is edit to go to mission modify screen
            displayMissionModified(listOfMissionRequest.get(userInput-1),account);
        }



    }

    //display all the mission plan from database to let user select
    public MissionPlan displayMissionPlanNameList(Account account,String action,MissionPlan missionPlan){
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        ArrayList<MissionRequest> listOfMissionRequest = missionToMarsSystem.readMissionRequestFile();// read missin plan file
        System.out.println("******* Mission Request List *******");
        System.out.println("Which mission you want to choose?");

        //display mission plan as list
        for (int i =0; i< listOfMissionRequest.size();i++){
            System.out.println(i+1+". "+listOfMissionRequest.get(i).getName());
        }
        System.out.println("Press 0 to go back to previous screen");
        System.out.println("Please input you option (Press enter to save)");

        int userInput = missionToMarsSystem.userIntegerInput();

        //data validation. let user enter the number with the range
        while (userInput >listOfMissionRequest.size() || userInput <0){
            System.out.println("Please enter a valid number");
            userInput = missionToMarsSystem.userIntegerInput();
        }
        //check role to go back
        if (userInput == 0){
            if (account.getRole().equals("Mission Coordinator"))
                missionToMarsSystem.missionCoordinatorMenuControl(account);
            else {
                missionToMarsSystem.administratorMenuControl(account);
            }
        }
       if (action.equals("shuttle")){//if action parameter is shuttle, let admin select shuttle
            missionPlan = displaySelectShuttleMenu(listOfMissionRequest.get(userInput-1),account,missionPlan);
        }
        else if (action.equals("criteria")){//if action parameter is criteria, let admin create criteria
            missionPlan = displayCreateCriteriaMenu(listOfMissionRequest.get(userInput-1),account,missionPlan);
        }
        else if (action.equals("editCriteria")){ // if action parameter is edit criteria, let admin do it
            missionPlan = displayCriteriaModified(listOfMissionRequest.get(userInput-1),account,missionPlan);
       }

        return missionPlan;
    }

    //display all the mission detail
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
        System.out.println("9.Title of employment required: "+ missionRequest.getListOfEmployment().get(0).getTitle());//To fix: potential problem: only get first one
        System.out.println("10.Number of employment required: "+ missionRequest.getListOfEmployment().get(0).getNumberRequired());
        System.out.println("11.Cargo for what kind of mission: "+ missionRequest.getListOfCargo().get(0).getCargoFor());//To fix: potential problem: only get first one
        System.out.println("12.Cargo required for: "+ missionRequest.getListOfCargo().get(0).getCargoRequired());
        System.out.println("13.Cargo quantity: "+ missionRequest.getListOfCargo().get(0).getQuantityRequired());
        System.out.println("14.Launch date:"+ missionRequest.getLaunchDate());
        System.out.println("15.Location of destination: "+ missionRequest.getDestination());
        System.out.println("16.Duration: "+ missionRequest.getDuration());
        System.out.println("17.Status of mission: "+ missionRequest.getStatus());
        Scanner scan = new Scanner(System.in);
        System.out.print("Press Enter to continue . . . ");
        scan.nextLine();
    }

    //let user edit mission attribute
    public void displayMissionModified(MissionRequest missionRequest,Account account){
        MissionRequest oldMissionRequest = new MissionRequest(missionRequest);
        String oldRecord = oldMissionRequest.getRecord();//get old record of mission
        System.out.println("1.Mission name: "+ missionRequest.getName());
        System.out.println("2.Mission description: "+ missionRequest.getDescription());
        System.out.println("3.Country of origin: "+ missionRequest.getCountry().getCountryOrigin());
        System.out.println("4.Country allowed: "+ missionRequest.getCountry().getCountryAllowed());
        System.out.println("5.Coordinator name: "+ missionRequest.getMissionCoordinator().getName());
        System.out.println("6.Coordinator contact information: "+ missionRequest.getMissionCoordinator().getContactInfo());
        System.out.println("7.Job name: "+ missionRequest.getJob().getName());
        System.out.println("8.Job Description: "+ missionRequest.getJob().getDescription());
        System.out.println("9.Title of employment required: "+ missionRequest.getListOfEmployment().get(0).getTitle());//To fix: potential problem: only get first one
        System.out.println("10.Number of employment required: "+ missionRequest.getListOfEmployment().get(0).getNumberRequired());
        System.out.println("11.Cargo for what kind of mission: "+ missionRequest.getListOfCargo().get(0).getCargoFor());//To fix: potential problem: only get first one
        System.out.println("12.Cargo required for: "+ missionRequest.getListOfCargo().get(0).getCargoRequired());
        System.out.println("13.Cargo quantity: "+ missionRequest.getListOfCargo().get(0).getQuantityRequired());
        System.out.println("14.Launch date:"+ missionRequest.getLaunchDate());
        System.out.println("15.Location of destination: "+ missionRequest.getDestination());
        System.out.println("16.Duration: "+ missionRequest.getDuration());
        System.out.println("17.Status of mission: "+ missionRequest.getStatus());
        System.out.println("Input 0 to go back to previous screen");
        System.out.println("Input -1 to go back to home screen");
        System.out.println("Which attributes you want to modify? (Press enter to commit your selection)");
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        String userInput = missionToMarsSystem.userStringInput();
        //let user select which attribute they want to change
        switch (userInput){
            case "1":
                System.out.println("--- 1. Please input mission name (Press enter to save)" );
                missionRequest.setName(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "2":
                System.out.println("--- 2. Please input mission description (Press enter to save)" );
                missionRequest.setDescription(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "3":
                System.out.println("--- 3. Please input country of origin (Press enter to save)" );
                missionRequest.getCountry().setCountryOrigin(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "4":
                System.out.println("--- 4. Please input country allowed (Press enter to save)" );
                missionRequest.getCountry().setCountryAllowed(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "5":
                System.out.println("--- 5. Please input coordinator's name (Press enter to save)" );
                missionRequest.getMissionCoordinator().setName(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "6":
                System.out.println("--- 6. Please input coordinator's contact information (Press enter to save)" );
                missionRequest.getMissionCoordinator().setContactInfo(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "7":
                System.out.println("--- 7. Please input job name (Press enter to save)" );
                missionRequest.getJob().setName(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "8":
                System.out.println("--- 8. Please input job description (Press enter to save)" );
                missionRequest.getJob().setDescription(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "9":
                System.out.println("--- 9. Please input title of employment required (Press enter to save)" );
                missionRequest.getListOfEmployment().get(0).setTitle(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "10":
                System.out.println("--- 10. Please input number of employment required (Press enter to save)" );
                missionRequest.getListOfEmployment().get(0).setNumberRequired(missionToMarsSystem.userIntegerInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "11":
                System.out.println("--- 11. Please input what the cargo used for (Press enter to save)" );
                Cargo cargo = missionRequest.cargoForDropDownList( missionRequest.getListOfCargo().get(0));
                missionRequest.getListOfCargo().get(0).setCargoFor(cargo.getCargoFor());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "12":
                System.out.println("--- 12. Please input what cargo required for (example:concrete, desserts, water)" );
                missionRequest.getListOfCargo().get(0).setCargoRequired(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "13":
                System.out.println("--- 13. Please input cargo quantity (Press enter to save)" );
                missionRequest.getListOfCargo().get(0).setQuantityRequired(missionToMarsSystem.userIntegerInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "14":
                System.out.println("--- 14. Please input launch date (date format example: 28/06/2020) " );
                missionRequest.setLaunchDate(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "15":
                System.out.println("--- 15. Please input location of destination (Press enter to save)" );
                missionRequest.setDestination(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "16":
                System.out.println("--- 16. Please input duration of mission (Press enter to save)" );
                missionRequest.setDuration(missionToMarsSystem.userStringInput());
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "17":
                System.out.println("--- 17. Please input status of mission (Press enter to save)" );
                missionRequest.statusDropDownList();
                missionToMarsSystem.modifyFile("MissionRequestData.txt",oldRecord,missionRequest.getRecord());
                displayMissionModified(missionRequest,account);
                break;
            case "0":
                displayAllMissionNameList(account,"edit");
                break;
            case "-1":
                if(account.getRole().equals("Mission Coordinator")){
                missionToMarsSystem.missionCoordinatorMenuControl(account);}
                else {missionToMarsSystem.administratorMenuControl(account);}
                break;
            default:
                System.out.println("--- Please input a valid option");
                displayMissionModified(missionRequest,account);
                break;


        }

    }

    //read shuttle file to let user select shuttle
    public MissionPlan displaySelectShuttleMenu(MissionRequest missionRequest,Account account,MissionPlan missionPlan){
        System.out.println("******* Select a shuttle for "+missionRequest.getName()+" *******");
        System.out.println("The number of space shuttles: ");
        missionPlan.setMissionRequest(missionRequest);
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        ArrayList<Shuttle> listOfShuttle =  missionToMarsSystem.readShuttleFile();//read shuttle file
        //display as list
        for (int i = 0; i< listOfShuttle.size();i++){
            System.out.println(i+1+". "+listOfShuttle.get(i).getName());;
        }
        System.out.println("Input 0 to go back to previous screen");
        System.out.println("Please input your option (Press enter to save):");

        int userInput = missionToMarsSystem.userIntegerInput();
        //data validation. let user enter the number with the range
        while (userInput >listOfShuttle.size() || userInput <0){
            System.out.println("Please enter a valid number");
            userInput = missionToMarsSystem.userIntegerInput();
        }

        if (userInput == 0){//go back to let user select mission again
            displayMissionPlanNameList(account,"Shuttle",missionPlan);
        }
        //after user select, display shuttle detail, let user confirm
        missionPlan = displayShuttleConfirmation(listOfShuttle.get(userInput-1),account,missionPlan);
        return missionPlan;
    }

    //display selected shuttle detail to let user confirm
    public MissionPlan displayShuttleConfirmation(Shuttle shuttle,Account account,MissionPlan missionPlan){
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        System.out.println("******* The information of space shuttle "+shuttle.getName()+ " *******");
        System.out.println("1.Shuttle name: "+ shuttle.getName());
        System.out.println("2.Manufacturing year "+ shuttle.getManufacturingYear());
        System.out.println("3.Fuel capacity: "+ shuttle.getFuelCapacity());
        System.out.println("3.Passenger capacity: "+ shuttle.getPassengerCapacity());
        System.out.println("4.Cargo capacity: "+ shuttle.getCargoCapacity());
        System.out.println("5.Travel speed: "+ shuttle.getTravelSpeed());
        System.out.println("Input 0 to go back to previous screen");
        System.out.println("Input -1 to confirm selection");
        int userInput = missionToMarsSystem.userIntegerInput();
        if (userInput == 0 ){
            displaySelectShuttleMenu(missionPlan.getMissionRequest(),account,missionPlan);
        }
        else if (userInput== -1)
        {
            //set the new shuttle into mission plan object first, after user select the criteria and candidate for this mission plan, then write it into database
            missionPlan.setShuttle(shuttle);
            System.out.println("Shuttle select successfully");
        }else {
            System.out.println("--- Please enter a valid option");
            displayShuttleConfirmation(shuttle, account, missionPlan);
        }
        return missionPlan;
    }

    //display the job title to let user select to create criteria for it
    public MissionPlan displayCreateCriteriaMenu(MissionRequest missionRequest,Account account,MissionPlan missionPlan){
        System.out.println("******* Create specific criteria *******");
        System.out.println("select a job title ");
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        //for the specified mission that user selected before, display all its job titles.
        //To fix: current list only has one employment because in the creating step, i only create one employment object for convenience !!! otherwise using loop to create more employment
        for (int i =0; i< missionRequest.getListOfEmployment().size();i++){
            System.out.println(i+1+". "+missionRequest.getListOfEmployment().get(i).getTitle());
        }
        System.out.println("Input 0 to go back to previous screen");
        System.out.println("Press enter you option (Press enter to save)");

        int userInput = missionToMarsSystem.userIntegerInput();
        //data validation. let user enter the number with the range
        while (userInput >missionRequest.getListOfEmployment().size() || userInput <0){
            System.out.println("Please enter a valid number");
            userInput = missionToMarsSystem.userIntegerInput();
        }
        if (userInput == 0){// go back to display all mission plan
            displayMissionPlanNameList(account,"criteria",missionPlan);
        }
        //let user add attribute for a new criteria
        missionPlan = displayCriteriaConfirmation(missionRequest.getListOfEmployment().get(userInput-1),missionPlan);
        return missionPlan;
    }
    //user create new criteria by adding each attribute
    public MissionPlan displayCriteriaConfirmation(Employment employment,MissionPlan missionPlan){
        Criteria criteria = new Criteria();
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        System.out.println("******* Create specific policy for"+ employment.getTitle() +" *******");
        System.out.println("--- Number of employees required: "+ employment.getNumberRequired());
        System.out.println("--- 1. Please enter maximum of age for this job (Press enter to save)");
        criteria.setMaxAge(missionToMarsSystem.userIntegerInput());
        System.out.println("--- 2. Please enter minimum of age for this job (Press enter to save)");
        criteria.setMinAge(missionToMarsSystem.userIntegerInput());
        System.out.println("--- 3. Please enter requirement of health record(Press enter to save)");
        criteria.setHealthRecord(missionToMarsSystem.userStringInput());//To fix: potential problem: the heath record should get from third party
        System.out.println("--- 4. Please enter requirement of criminal record(Press enter to save)");
        criteria.setCriminalRecord(missionToMarsSystem.userStringInput());//To fix: potential problem: the heath record should get from third party
        missionPlan.setCriteria(criteria);
        return missionPlan;
    }

    //let user modify existing criteria, let them choose the job title first
    public MissionPlan displayCriteriaModified(MissionRequest missionRequest,Account account,MissionPlan missionPlan){
        System.out.println("******* Edit existing criteria for "+ missionRequest.getName()+" *******");
        System.out.println("select a job title ");
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        //for the specified mission that user selected before, display all its job titles.
        //To fix: current list only has one employment because in the creating step, i only create one employment object for convenience !!! otherwise using loop to create more employment
        for (int i =0; i< missionRequest.getListOfEmployment().size();i++){
            System.out.println(i+1+". "+missionRequest.getListOfEmployment().get(i).getTitle());
        }
        System.out.println("Input 0 to go back to previous screen");
        System.out.println("Press enter you option (Press enter to save)");

        int userInput = missionToMarsSystem.userIntegerInput();
        //data validation. let user enter the number with the range
        while (userInput >missionRequest.getListOfEmployment().size() || userInput <0){
            System.out.println("Please enter a valid number");
            userInput = missionToMarsSystem.userIntegerInput();
        }
        if (userInput == 0){// press b to go back to mission plan selection screen
            displayMissionPlanNameList(account,"editCriteria",missionPlan);
        }
        //let user edit existing criteria attribute
        missionPlan = displayEditCriteria(missionRequest,account,missionRequest.getListOfEmployment().get(userInput-1),missionPlan);
        return missionPlan;
    }

    //user edit existing criteria
    public MissionPlan displayEditCriteria(MissionRequest missionRequest,Account account,Employment employment,MissionPlan missionPlan){
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        System.out.println("******* Edit specific policy for"+ employment.getTitle() +" *******");
        System.out.println("Please enter your option: ");
        System.out.println("1. maximum age: " + missionPlan.getCriteria().getMaxAge());
        System.out.println("2. minimum age: "+ missionPlan.getCriteria().getMinAge());
        System.out.println("3. health record: " + missionPlan.getCriteria().getHealthRecord());
        System.out.println("4. criminal record: "+ missionPlan.getCriteria().getCriminalRecord());
        System.out.println("Input 0 to go back to previous screen");
        System.out.println("Input -1 to go back to home screen");
        String userInput = missionToMarsSystem.userStringInput();
        //let user select an attribute to edit
        switch (userInput){
            case "1":
                System.out.println("--- 1. Please enter maximum of age for this job (Press enter to save)");
                userInput = missionToMarsSystem.userStringInput();
                if (missionPlan.getCriteria() == null){
                    System.out.println("Please create criteria for a mission first");
                    missionToMarsSystem.administratorMenuControl(account);
                }
                missionPlan.getCriteria().setMaxAge(Integer.parseInt(userInput));
                displayEditCriteria(missionRequest,account,employment,missionPlan);
                break;
            case "2":
                System.out.println("--- 2. Please enter minimum of age for this job (Press enter to save)");
                userInput = missionToMarsSystem.userStringInput();
                if (missionPlan.getCriteria()  == null){
                    System.out.println("Please create criteria for a mission first");
                    missionToMarsSystem.administratorMenuControl(account);
                }
                missionPlan.getCriteria().setMinAge(Integer.parseInt(userInput));
                displayEditCriteria(missionRequest,account,employment,missionPlan);
                break;
            case "3":
                System.out.println("--- 3. Please enter requirement of health record (Press enter to save)");
                userInput = missionToMarsSystem.userStringInput();
                if (missionPlan.getCriteria()  == null){
                    System.out.println("Please create criteria for a mission first");
                    missionToMarsSystem.administratorMenuControl(account);
                }
                missionPlan.getCriteria().setHealthRecord(userInput);
                displayEditCriteria(missionRequest,account,employment,missionPlan);
                break;
            case "4":
                System.out.println("--- 4. Please enter requirement of criminal record (Press enter to save)");
                userInput = missionToMarsSystem.userStringInput();
                if (missionPlan.getCriteria()  == null){
                    System.out.println("Please create criteria for a mission first");
                    missionToMarsSystem.administratorMenuControl(account);
                }
                missionPlan.getCriteria().setCriminalRecord(userInput);
                displayEditCriteria(missionRequest,account,employment,missionPlan);
                break;
            default:
                System.out.println("Please enter a valid option:");
                displayEditCriteria(missionRequest,account,employment,missionPlan);
                break;
            case "0":
                displayCriteriaModified(missionRequest,account,missionPlan);
                break;
            case "-1":
                missionToMarsSystem.missionPlan = missionPlan;
                missionToMarsSystem.administratorMenuControl(account);
                break;
        }
        return missionPlan;
    }



}

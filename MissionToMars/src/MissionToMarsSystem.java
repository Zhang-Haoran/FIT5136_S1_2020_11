import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MissionToMarsSystem {

    //initialize
    ArrayList<Account> listOfAccount = new ArrayList<>();
    ArrayList<MissionRequest> listOfMissionRequest = new ArrayList<>();
    ArrayList<Shuttle> listOfShuttle = new ArrayList<>();
    ArrayList<Candidate> listOfCandidate = new ArrayList<>();
    Account currentAccount = new Account();
    MissionPlan missionPlan = new MissionPlan();
    public static void main(String[] args) {
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        UserInterface userInterface = new UserInterface();
        //display welcome screen
        userInterface.displayWelcomeMessage();
        switch (missionToMarsSystem.userIntegerInput()){
            case 1:
                System.out.println("Sign up candidate is not the requirement. Please login");//registering is not part of requirement
                missionToMarsSystem.login();
                break;
            case 2:
                missionToMarsSystem.login();
                break;
            default:
                System.out.println("invalid input. Please login");
                missionToMarsSystem.login();
                break;
        }


    }
    //user string input control
    public String userStringInput(){
        String userInput = "";
        boolean flag = true;
        while (flag){
            try{
                Scanner scanner = new Scanner(System.in);
                userInput = scanner.nextLine();
                //check if user enter empty string
                if (!userInput.isBlank()){
                    flag = false;
                }else {
                    System.out.println("Input cannot be empty");
                }

            }
            catch (InputMismatchException e){
                System.out.println("invalid input. Please try again");
            }
        }

        return userInput;
    }

    //check user integer input
    public int userIntegerInput(){
        int userInput = 0;
        boolean flag = true;
        while (flag)
        {
            try
            {
                Scanner scanner = new Scanner(System.in);
                userInput = scanner.nextInt();
                flag = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("invalid input. please enter a number.");
            }
        }

        return userInput;
    }

    public void login() {
        UserInterface userInterface = new UserInterface();
        readAccountFile();//at the beginning of login, read account data from database
        String username = "";
        String password = "";

        boolean isUserValid = false;
        userInterface.displayLoginScreen();
        System.out.println("--- Please enter your username:");
        username = userStringInput();
        System.out.println("--- Please enter your password:");
        password = userStringInput();
        //check if there is an account that match user's input username and password
        for (Account account: listOfAccount){
            if (account.getUserName().equals(username) && account.getPassword().equals(password)){
                //find an account
                isUserValid = true;
                currentAccount = account;
                }
            }
        if (isUserValid){
            System.out.println("You are successfully log in");
            //once user is valid, check their role to direct them to correct home screen
            if  (currentAccount.getRole().equals("Mission Coordinator")){
                missionCoordinatorMenuControl(currentAccount);
            }
            else if(currentAccount.getRole().equals("Administrator")){
                    administratorMenuControl(currentAccount);
                }
            }
                //system cannot find any account. display an error message
        else {
            System.out.println("Your username or password is incorrect. Please try again");
            login();
        }
    }

//coordinator's first action in the home screen
    public void createMissionRequest() {
        UserInterface userInterface = new UserInterface();
        try {
            userInterface.displayCreateMissionMenu();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userInterface.displayMisssionConfirmation();
    }

    //coordinator's second action in the home screen
    public void viewExistingMission(Account account) {
        UserInterface userInterface = new UserInterface();
        userInterface.displayAllMissionNameList(account,"view"); // the second parameter to check their action type

    }
    //coordinator's third action in the home screen
    public void editMissionRequest(Account account) {
        UserInterface userInterface = new UserInterface();
        userInterface.displayAllMissionNameList(account,"edit");
    }
    //user can logout to exit the system
    public void logout() {
        System.out.println("Quitting the system");
        System.exit(0);
    }

    //different to coordinator, admin can select shuttle
    public MissionPlan selectShuttle(Account account,MissionPlan missionPlan) {
        UserInterface userInterface = new UserInterface();
        missionPlan= userInterface.displayMissionPlanNameList(account,"shuttle",missionPlan);// the second parameter to check admin's current action
        return missionPlan;
    }

    //admin can create selection critera
    public MissionPlan createSelectionCriteria(Account account,MissionPlan missionPlan){
        UserInterface userInterface = new UserInterface();
        missionPlan = userInterface.displayMissionPlanNameList(account,"criteria",missionPlan);
        return missionPlan;
    }
    //admin edit selection criteria
    public MissionPlan editSelectionCriteria(Account account,MissionPlan missionPlan) {
        UserInterface userInterface = new UserInterface();
        missionPlan = userInterface.displayMissionPlanNameList(account,"editCriteria",missionPlan);
        return missionPlan;
    }

    //admin can find best candidate
    public void findBestCandidate(MissionPlan missionPlan){
        System.out.println("How many candidates do you want to find");
        int numberOfCandidate = userIntegerInput();
        int count =0;
        ArrayList<Candidate> selectedCandidate = new ArrayList<>();
        listOfCandidate = readCandidateFile();
        System.out.println("Collecting candidate's criminal and health record from third party......downloading");
        for (int i = 0; i<listOfCandidate.size();i++){
            if (Integer.parseInt(listOfCandidate.get(i).getAge())
                    <= missionPlan.getCriteria().getMaxAge()
                    && Integer.parseInt(listOfCandidate.get(i).getAge()) >= missionPlan.getCriteria().getMinAge()
                    && listOfCandidate.get(i).getHealthRecord().equals(missionPlan.getCriteria().getHealthRecord())
                    && listOfCandidate.get(i).getCriminalRecord().equals(missionPlan.getCriteria().getCriminalRecord())
            ){
                selectedCandidate.add(listOfCandidate.get(i));
                count++;
                if (count == numberOfCandidate) break;
            }

        }

        System.out.println("Search result:");
        for(int i = 0; i<selectedCandidate.size();i++){
            System.out.println("Candidate Name: "+ selectedCandidate.get(i).getName());
        }

    }

    //fetch the account data from the database
    public void readAccountFile() {

        try {
            FileReader inputFile = new FileReader("AccountData.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {//if the file still has content to read, read until file ends
                String[] userData = parser.nextLine().split(","); //get each line, split by comma, get each attribute
                listOfAccount.add(new Account(userData[0],userData[1],userData[2],userData[3]));//make these attributes into Account object, add Account into list
                //do the step until file ends
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //fetch the candidate data from database
    public ArrayList<Candidate> readCandidateFile() {

        try {
            FileReader inputFile = new FileReader("CandidateData.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {//if the file still has content to read, read until file ends
                String[] userData = parser.nextLine().split(","); //get each line, split by comma, get each attribute
                listOfCandidate.add(new Candidate(userData[0],userData[1],userData[2],userData[3]));//make these attributes into Candidate object, add Candidate into list

            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfCandidate;

    }

    //fetch the shuttle data from database
    public ArrayList<Shuttle> readShuttleFile(){
        try{
            FileReader inputFile = new FileReader("ShuttleData.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {//if the file still has content to read, read until file ends
                String[] userData = parser.nextLine().split(",");//get each line, split by comma, get each attribute
                //make these attributes into Shuttle object, add Shuttle into list
                listOfShuttle.add(new Shuttle(userData[0],userData[1],Integer.parseInt(userData[2]),Integer.parseInt(userData[3]),Integer.parseInt(userData[4]),Integer.parseInt(userData[5])));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfShuttle;
    }

    //fetch the mission request data from database
    public ArrayList<MissionRequest> readMissionRequestFile() {

        ArrayList<MissionRequest> missionRequests = new ArrayList<>();
        try {
            FileReader inputFile = new FileReader("MissionRequestData.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {//if the file still has content to read, read until file ends
                String line = parser.nextLine();
                if (line.length() == 0){    //next line is empty do nothing

                }
                else {
                    String[] userData =line.split(",");//get each line, split by comma, get each attribute
                    //make these attributes into MissionRequest object, Mission request has many other class as its component
                    Country country = new Country(userData[2], userData[3]);
                    MissionCoordinator missionCoordinator = new MissionCoordinator(userData[4], userData[5], listOfMissionRequest);
                    Job job = new Job(userData[6], userData[7]);
                    Employment employment = new Employment(userData[8], Integer.parseInt(userData[9]));
                    ArrayList<Employment> listOfEmployment = new ArrayList<>();
                    listOfEmployment.add(employment);
                    Cargo cargo = new Cargo(userData[10], userData[11], Integer.parseInt(userData[12]));
                    ArrayList<Cargo> listOfCargo = new ArrayList<>();
                    listOfCargo.add(cargo);
                    //add Mission request object into list
                    listOfMissionRequest.add(new MissionRequest
                            (userData[0], userData[1], country, job, missionCoordinator, listOfEmployment, listOfCargo,
                                    userData[13], userData[14], userData[15], userData[16]));
                }
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        missionRequests = listOfMissionRequest;
        return missionRequests;
    }

    //add mission request into the database
    public void writeMissionRequestFile(MissionRequest missionRequest){
        try {
            FileWriter fileWriter = new FileWriter("MissionRequestData.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();//make a new line
            //write each attribute into this line, split by comma
            bufferedWriter.write(missionRequest.getName()+
                    ","+missionRequest.getDescription()+
                    ","+missionRequest.getCountry().getCountryOrigin()+
                    ","+missionRequest.getCountry().getCountryAllowed()+
                    ","+missionRequest.getMissionCoordinator().getName()+
                    ","+missionRequest.getMissionCoordinator().getContactInfo()+
                    ","+missionRequest.getJob().getName()+
                    ","+missionRequest.getJob().getDescription()+
                    ","+missionRequest.getListOfEmployment().get(0).getTitle()+ // potential problem: only can add first employment
                    ","+missionRequest.getListOfEmployment().get(0).getNumberRequired()+
                    ","+missionRequest.getListOfCargo().get(0).getCargoFor()+ //potential problem: only can add first cargo
                    ","+missionRequest.getListOfCargo().get(0).getCargoRequired()+
                    ","+missionRequest.getListOfCargo().get(0).getQuantityRequired()+
                    ","+missionRequest.getLaunchDate()+
                    ","+missionRequest.getDestination()+
                    ","+missionRequest.getDuration()+
                    ","+missionRequest.getStatus()
            );
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add mission plan into the database
    public void writeMissionPlan(MissionPlan missionPlan,Shuttle shuttle){
        try {
            FileWriter fileWriter = new FileWriter("MissionPlanData.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();//make a new line
            //write each attribute into this line, split by comma
            bufferedWriter.write(missionPlan.getMissionRequest().getName()+
                    ","+missionPlan.getMissionRequest().getDescription()+
                    ","+missionPlan.getMissionRequest().getCountry().getCountryOrigin()+
                    ","+missionPlan.getMissionRequest().getCountry().getCountryAllowed()+
                    ","+missionPlan.getMissionRequest().getMissionCoordinator().getName()+
                    ","+missionPlan.getMissionRequest().getMissionCoordinator().getContactInfo()+
                    ","+missionPlan.getMissionRequest().getJob().getName()+
                    ","+missionPlan.getMissionRequest().getJob().getDescription()+
                    ","+missionPlan.getMissionRequest().getListOfEmployment().get(0).getTitle()+ // potential problem: only can add first employment
                    ","+missionPlan.getMissionRequest().getListOfEmployment().get(0).getNumberRequired()+
                    ","+missionPlan.getMissionRequest().getListOfCargo().get(0).getCargoFor()+ //potential problem: only can add first cargo
                    ","+missionPlan.getMissionRequest().getListOfCargo().get(0).getCargoRequired()+
                    ","+missionPlan.getMissionRequest().getListOfCargo().get(0).getQuantityRequired()+
                    ","+missionPlan.getMissionRequest().getLaunchDate()+
                    ","+missionPlan.getMissionRequest().getDestination()+
                    ","+missionPlan.getMissionRequest().getDuration()+
                    ","+missionPlan.getMissionRequest().getStatus()+
                    ","+shuttle.getName()+
                    ","+shuttle.getManufacturingYear()+
                    ","+shuttle.getFuelCapacity()+
                    ","+shuttle.getPassengerCapacity()+
                    ","+shuttle.getCargoCapacity()+
                    ","+shuttle.getTravelSpeed()
            );
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //coordinator 's main menu screen, they can select their action in this screen
    public void missionCoordinatorMenuControl(Account account){
        UserInterface userInterface = new UserInterface();
        userInterface.displayMissionCoordinatorScreen(account);
        //infinite loop in the menu screen until, coordinator select logout
        switch (userIntegerInput()){
            case 1:
                createMissionRequest();
                break;
            case 2:
                viewExistingMission(account);
                break;
            case 3:
                editMissionRequest(account);
                break;
            case 4:
                logout();
                break;
            default:
                System.out.println("Please enter the valid number");

                break;
    }
        missionCoordinatorMenuControl(account);
    }

    //admin 's main menu screen, they can select their action in this screen
    public void administratorMenuControl(Account account){
        UserInterface userInterface = new UserInterface();
        userInterface.displayAdministratorScreen(account);
        //infinite loop in the menu screen until, admin select logout
        switch (userIntegerInput()){
            case 1:
                viewExistingMission(account);
                break;
            case 2:
                editMissionRequest(account);
                break;
            case 3:
                missionPlan = selectShuttle(account,missionPlan);
                missionPlan.getRecordAfterShuttle();
                break;
            case 4:
                if (missionPlan.getShuttle() == null){
                    System.out.println("Please select shuttle for a mission first");
                }else {
                    missionPlan = createSelectionCriteria(account,missionPlan);
                     missionPlan.getRecordAfterCriteria();
                }

                break;
            case 5:
                if (missionPlan.getCriteria() == null){
                    System.out.println("Please create criteria for a mission first");
                }
                else {
                    missionPlan = editSelectionCriteria(account,missionPlan);
                    missionPlan.getRecordAfterCriteria();
                }

                break;
            case 6:
                if (missionPlan.getShuttle() == null || missionPlan.getCriteria() == null){
                    System.out.println("Please select shuttle and create criteria for a mission first");
                }
                else {
                    findBestCandidate(missionPlan);
                }
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Please enter the valid number");
                break;
    }
        administratorMenuControl(account);

}

    //update existing file used to edit database
    public void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);

        String oldContent = "";

        BufferedReader reader = null;

        FileWriter writer = null;

        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources

                reader.close();

                writer.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}

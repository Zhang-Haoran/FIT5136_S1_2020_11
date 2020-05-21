import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MissionToMarsSystem {

    ArrayList<Account> listOfAccount = new ArrayList<>();
    ArrayList<MissionRequest> listOfMissionRequest = new ArrayList<>();
    ArrayList<Shuttle> listOfShuttle = new ArrayList<>();
    ArrayList<MissionPlan> listOfMissionPlan = new ArrayList<>();
    Account currentAccount = new Account();
    MissionPlan missionPlan = new MissionPlan();
    public static void main(String[] args) {
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        UserInterface userInterface = new UserInterface();
        userInterface.displayWelcomeMessage();
        switch (missionToMarsSystem.userIntegerInput()){
            case 1:
                System.out.println("Sign up candidate is not the requirement. Please login");
                break;
            case 2:
                missionToMarsSystem.login();
                break;
        }


    }

    public String userStringInput(){
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        return userInput;
    }

    public int userIntegerInput(){
        int userInput = 0;
        Scanner scanner = new Scanner(System.in);
        try
        {
            userInput = scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please input integer\n");
        }

        return userInput;
    }

    public void login() {
        UserInterface userInterface = new UserInterface();
        readAccountFile();
        String username;
        String password;

        boolean isUserValid = false;
        userInterface.displayLoginScreen();
        System.out.println("--- Please enter your username:");
        username = userStringInput();
        System.out.println("--- Please enter your password:");
        password = userStringInput();
        for (Account account: listOfAccount){
            if (account.getUserName().equals(username) && account.getPassword().equals(password)){
                isUserValid = true;
                currentAccount = account;
                System.out.println("You are successfully log in");
                }
            }
        if (isUserValid){
            if  (currentAccount.getRole().equals("Mission Coordinator")){
                missionCoordinatorMenuControl(currentAccount);
            }
            else if(currentAccount.getRole().equals("Administrator")){
                    administratorMenuControl(currentAccount);
                }
            }

        else {
            System.out.println("Your username or password is incorrect. Please try again");
            login();
        }
    }


    public void createMissionRequest() {
        UserInterface userInterface = new UserInterface();
        try {
            userInterface.displayCreateMissionMenu();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        userInterface.displayMisssionConfirmation();
    }
    public void viewExistingMission(Account account) {
        UserInterface userInterface = new UserInterface();
        userInterface.displayAllMissionNameList(account,"view");

    }
    public void editMissionRequest(Account account) {
        UserInterface userInterface = new UserInterface();
        userInterface.displayAllMissionNameList(account,"edit");
    }
    public void logout() {
        System.out.println("Quitting the system");
        System.exit(0);
    }
    public MissionPlan selectShuttle(Account account,MissionPlan missionPlan) {
        UserInterface userInterface = new UserInterface();
        missionPlan= userInterface.displayMissionPlanNameList(account,"shuttle",missionPlan);
        return missionPlan;
    }
    public void createSelectionCriteria(Account account,MissionPlan missionPlan){
        UserInterface userInterface = new UserInterface();
        userInterface.displayMissionPlanNameList(account,"criteria",missionPlan);
    }
    public void editSelectionCriteria() {
    }

    public void findBestCandidate(){

    }

    public void readAccountFile() {

        try {
            FileReader inputFile = new FileReader("AccountData.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String[] userData = parser.nextLine().split(",");
                listOfAccount.add(new Account(userData[0],userData[1],userData[2],userData[3]));

            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Shuttle> readShuttleFile(){
        try{
            FileReader inputFile = new FileReader("ShuttleData.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String[] userData = parser.nextLine().split(",");
                listOfShuttle.add(new Shuttle(userData[0],userData[1],Integer.parseInt(userData[2]),Integer.parseInt(userData[3]),Integer.parseInt(userData[4]),Integer.parseInt(userData[5])));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listOfShuttle;
    }

    public ArrayList<MissionRequest> readMissionRequestFile() {

        ArrayList<MissionRequest> missionRequests = new ArrayList<>();
        try {
            FileReader inputFile = new FileReader("MissionRequestData.txt");
            Scanner parser = new Scanner(inputFile);
            while (parser.hasNextLine()) {
                String[] userData = parser.nextLine().split(",");
                Country country = new Country(userData[2],userData[3]);
                MissionCoordinator missionCoordinator = new MissionCoordinator(userData[4],userData[5],listOfMissionRequest);
                Job job = new Job(userData[6],userData[7]);
                Employment employment = new Employment(userData[8], Integer.parseInt(userData[9]));
                ArrayList<Employment> listOfEmployment = new ArrayList<>();
                listOfEmployment.add(employment);
                Cargo cargo = new Cargo(userData[10],userData[11],Integer.parseInt(userData[12]));
                ArrayList<Cargo> listOfCargo = new ArrayList<>();
                listOfCargo.add(cargo);

                listOfMissionRequest.add(new MissionRequest
                        (userData[0],userData[1],country, job, missionCoordinator,listOfEmployment,listOfCargo,
                        userData[13],userData[14],userData[15],userData[16]));
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

    public void writeMissionRequestFile(MissionRequest missionRequest){
        try {
            FileWriter fileWriter = new FileWriter("MissionRequestData.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(missionRequest.getName()+
                    ","+missionRequest.getDescription()+
                    ","+missionRequest.getCountry().getCountryOrigin()+
                    ","+missionRequest.getCountry().getCountryAllowed()+
                    ","+missionRequest.getMissionCoordinator().getName()+
                    ","+missionRequest.getMissionCoordinator().getContactInfo()+
                    ","+missionRequest.getJob().getName()+
                    ","+missionRequest.getJob().getDescription()+
                    ","+missionRequest.getListOfEmployment().get(0).getTitle()+
                    ","+missionRequest.getListOfEmployment().get(0).getNumberRequired()+
                    ","+missionRequest.getListOfCargo().get(0).getCargoFor()+
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

    public void writeMissionPlan(MissionPlan missionPlan,Shuttle shuttle){
        try {
            FileWriter fileWriter = new FileWriter("MissionPlanData.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(missionPlan.getMissionRequest().getName()+
                    ","+missionPlan.getMissionRequest().getDescription()+
                    ","+missionPlan.getMissionRequest().getCountry().getCountryOrigin()+
                    ","+missionPlan.getMissionRequest().getCountry().getCountryAllowed()+
                    ","+missionPlan.getMissionRequest().getMissionCoordinator().getName()+
                    ","+missionPlan.getMissionRequest().getMissionCoordinator().getContactInfo()+
                    ","+missionPlan.getMissionRequest().getJob().getName()+
                    ","+missionPlan.getMissionRequest().getJob().getDescription()+
                    ","+missionPlan.getMissionRequest().getListOfEmployment().get(0).getTitle()+
                    ","+missionPlan.getMissionRequest().getListOfEmployment().get(0).getNumberRequired()+
                    ","+missionPlan.getMissionRequest().getListOfCargo().get(0).getCargoFor()+
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



    public void missionCoordinatorMenuControl(Account account){
        UserInterface userInterface = new UserInterface();
        userInterface.displayMissionCoordinatorScreen(account);
        switch (userIntegerInput()){
            case 1:
                createMissionRequest();
                missionCoordinatorMenuControl(account);
                break;
            case 2:
                viewExistingMission(account);
                missionCoordinatorMenuControl(account);
                break;
            case 3:
                editMissionRequest(account);
                missionCoordinatorMenuControl(account);
                break;
            case 4:
                logout();
                break;
            default:
                System.out.println("Please enter the valid number");
                break;
    }
    }

    public void administratorMenuControl(Account account){
        UserInterface userInterface = new UserInterface();
        userInterface.displayAdministratorScreen(account);
        switch (userIntegerInput()){
            case 1:
                viewExistingMission(account);
                administratorMenuControl(account);
                break;
            case 2:
                editMissionRequest(account);
                administratorMenuControl(account);
                break;
            case 3:
                missionPlan = selectShuttle(account,missionPlan);
                administratorMenuControl(account);
                break;
            case 4:
                createSelectionCriteria(account,missionPlan);
                administratorMenuControl(account);
                break;
            case 5:
                editSelectionCriteria();
                administratorMenuControl(account);
                break;
            case 6:
                findBestCandidate();
                administratorMenuControl(account);
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Please enter the valid number");
                break;
    }

}

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

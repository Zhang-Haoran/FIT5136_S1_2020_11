import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MissionToMarsSystem {

    ArrayList<Account> listOfAccount = new ArrayList<Account>();
    Account currentAccount = new Account();
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
        userInput = scanner.nextInt();
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
                userInterface.displayMissionCoordinatorScreen(currentAccount);
                switch (userIntegerInput()){
                    case 1:
                        createMissionRequest();
                        break;
                    case 2:
                        viewExistingMission();
                        break;
                    case 3:
                        editMissionRequest();
                        break;
                    case 4:
                        logout();
                        break;
                    default:
                        System.out.println("Please enter the valid number");
                        break;
                }
            }
            else if(currentAccount.getRole().equals("Administrator")){
                userInterface.displayAdministratorScreen(currentAccount);
                switch (userIntegerInput()){
                    case 1:
                        viewExistingMission();
                        break;
                    case 2:
                        editMissionRequest();
                        break;
                    case 3:
                        selectShuttle();
                        break;
                    case 4:
                        createSelectionCriteria();
                        break;
                    case 5:
                        editSelectionCriteria();
                        break;
                    case 6:
                        findBestCandidate();
                        break;
                    case 7:
                       logout();
                        break;
                    default:
                        System.out.println("Please enter the valid number");
                        break;
                }
            }
        }
        else {
            System.out.println("Your username or password is incorrect. Please try again");
            login();
        }
        }

    public void createMissionRequest() {
    }
    public void viewExistingMission() {
    }
    public void editMissionRequest() {
    }
    public void logout() {
    }
    public void selectShuttle() {
    }
    public void createSelectionCriteria(){

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


}

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MissionToMarsSystem {

    ArrayList<Account> listOfAccount = new ArrayList<Account>();
    public static void main(String[] args) {
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        UserInterface userInterface = new UserInterface();
        userInterface.displayWelcomeMessage();
        while (true){
            switch (missionToMarsSystem.userIntegerInput()){
                case 1:
                    System.out.println("Sign up candidate is not the requirement. Please login");
                    break;
                case 2:
                    missionToMarsSystem.login();
                    break;
            }
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
        userInterface.displayLoginScreen();
        System.out.println("--- Please enter your username:");
        username = userStringInput();
        System.out.println("--- Please enter your password:");
        password = userStringInput();

        for (Account account: listOfAccount){
            if (account.getUserName().equals(username) && account.getPassword().equals(password)){
                System.out.println("You are successfully log in");
                switch (account.getRole()){
                    case "Administrator":
                        userInterface.displayAdministratorScreen(account);
                        break;
                    case "Mission Coordinator":
                        userInterface.displayMissionCoordinatorScreen(account);
                        break;
                }
            }
        }

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

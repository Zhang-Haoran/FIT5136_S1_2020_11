import java.util.Scanner;

public class MissionToMarsSystem {


    public static void main(String[] args) {
        MissionToMarsSystem missionToMarsSystem = new MissionToMarsSystem();
        UserInterface userInterface = new UserInterface();
        userInterface.displayWelcomeMessage();
        switch (missionToMarsSystem.userIntegerInput()){
            case 1:
                System.out.printf("Sign up candidate is not the requirement. Please login");
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
        String username;
        String password;
        userInterface.displayLoginScreen();
        System.out.println("--- Please enter your username:");
        username = userStringInput();
        System.out.println("--- Please enter your password:");
        password = userStringInput();
    }

}

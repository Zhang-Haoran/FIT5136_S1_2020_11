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
        System.out.println("Account type: Administrator");
        System.out.println("--- Please enter the number below to select your option ");
        System.out.println("--- 1.Create new mission");
        System.out.println("--- 2.View existing missions");
        System.out.println("--- 3.Edit mission");
        System.out.println("--- 4.Log out");
        System.out.println("--- Enter your option: ");
    }


    public void displayCreateMissiontMenu(MissionRequest missionRequest){

    }
    public void displayMisssionConfirmation(){}
    public void displayMissionSuccessMessage(){}

    public void displayAllMissionNameList(MissionPlan missionPlan){

    }

    public void displayMissionDetails(MissionPlan missionPlan){

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

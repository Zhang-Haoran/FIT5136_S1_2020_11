import java.util.ArrayList;

public class Administrator extends Account {
    ArrayList<MissionPlan> listOfMissionPlan;

    public Administrator(ArrayList<MissionPlan> listOfMissionPlan) {
        this.listOfMissionPlan = listOfMissionPlan;
    }

    public Administrator() {
    }

    public ArrayList<MissionPlan> getListOfMissionPlan() {
        return listOfMissionPlan;
    }

    public void setListOfMissionPlan(ArrayList<MissionPlan> listOfMissionPlan) {
        this.listOfMissionPlan = listOfMissionPlan;
    }
}

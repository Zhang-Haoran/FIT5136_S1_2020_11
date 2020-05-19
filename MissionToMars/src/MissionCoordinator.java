import java.util.ArrayList;

public class MissionCoordinator extends Account {
    private String name;
    private String contactInfo;
    private ArrayList<MissionRequest> listOfMissionRequest;

    public MissionCoordinator(String name, String contactInfo, ArrayList<MissionRequest> listOfMissionRequest) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.listOfMissionRequest = listOfMissionRequest;
    }

    public MissionCoordinator() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public ArrayList<MissionRequest> getListOfMissionRequest() {
        return listOfMissionRequest;
    }

    public void setListOfMissionRequest(ArrayList<MissionRequest> listOfMissionRequest) {
        this.listOfMissionRequest = listOfMissionRequest;
    }
}

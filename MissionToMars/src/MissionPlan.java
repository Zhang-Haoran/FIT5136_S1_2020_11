import java.util.ArrayList;

public class MissionPlan {
    ArrayList<MissionRequest> listOfMissionRequest;
    ArrayList<Candidate> listOfCandidate;
    ArrayList<Criteria> listOfCriteria;
    ArrayList<Shuttle> listOfShuttle;

    public MissionPlan(ArrayList<MissionRequest> listOfMissionRequest, ArrayList<Candidate> listOfCandidate, ArrayList<Criteria> listOfCriteria, ArrayList<Shuttle> listOfShuttle) {
        this.listOfMissionRequest = listOfMissionRequest;
        this.listOfCandidate = listOfCandidate;
        this.listOfCriteria = listOfCriteria;
        this.listOfShuttle = listOfShuttle;
    }

    public ArrayList<MissionRequest> getListOfMissionRequest() {
        return listOfMissionRequest;
    }

    public void setListOfMissionRequest(ArrayList<MissionRequest> listOfMissionRequest) {
        this.listOfMissionRequest = listOfMissionRequest;
    }

    public ArrayList<Candidate> getListOfCandidate() {
        return listOfCandidate;
    }

    public void setListOfCandidate(ArrayList<Candidate> listOfCandidate) {
        this.listOfCandidate = listOfCandidate;
    }

    public ArrayList<Criteria> getListOfCriteria() {
        return listOfCriteria;
    }

    public void setListOfCriteria(ArrayList<Criteria> listOfCriteria) {
        this.listOfCriteria = listOfCriteria;
    }

    public ArrayList<Shuttle> getListOfShuttle() {
        return listOfShuttle;
    }

    public void setListOfShuttle(ArrayList<Shuttle> listOfShuttle) {
        this.listOfShuttle = listOfShuttle;
    }

    public MissionPlan() {
    }
}

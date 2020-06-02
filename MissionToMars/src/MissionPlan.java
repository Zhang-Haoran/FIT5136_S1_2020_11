import java.util.ArrayList;

public class MissionPlan {
   private MissionRequest missionRequest;
   private Candidate candidate;
   private Criteria criteria;
   private Shuttle shuttle;

    public MissionPlan(MissionRequest missionRequest, Candidate candidate, Criteria criteria, Shuttle shuttle) {
        this.missionRequest = missionRequest;
        this.candidate = candidate;
        this.criteria = criteria;
        this.shuttle = shuttle;
    }

    public MissionPlan(MissionRequest missionRequest) {
        this.missionRequest = missionRequest;
    }

    public MissionPlan() {
    }

    public MissionPlan(MissionRequest missionRequest, Shuttle shuttle) {
        this.missionRequest = missionRequest;
        this.shuttle = shuttle;
    }

    public MissionRequest getMissionRequest() {
        return missionRequest;
    }

    public void setMissionRequest(MissionRequest missionRequest) {
        this.missionRequest = missionRequest;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public Shuttle getShuttle() {
        return shuttle;
    }

    public void setShuttle(Shuttle shuttle) {
        this.shuttle = shuttle;
    }

    public void getRecordAfterShuttle(){
        System.out.println("\nCurrent Mission Plan: ");
         this.getMissionRequest().getPerfectRecord(getMissionRequest());
        System.out.println("\n");
         this.getShuttle().getPerfectRecord(getShuttle());

    }
    public void getRecordAfterCriteria(){
        System.out.println("\nCurrent Mission Plan: ");
        this.getMissionRequest().getPerfectRecord(getMissionRequest());
        System.out.println("\n");
        this.getShuttle().getPerfectRecord(getShuttle());
        System.out.println("\n");
        this.getCriteria().getPrefectRecord(getCriteria());
    }
}

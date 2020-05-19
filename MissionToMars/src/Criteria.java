import java.util.ArrayList;

public class Criteria {
    private int maxAge;
    private int minAge;
    private ArrayList<String> qualification;
    private int workExperience;
    private ArrayList<String> occupation;
    private ArrayList<String> healthRecord;
    private ArrayList<String> criminalRecord;
    private String computerSkill;
    private ArrayList<String> languageSpoken;

    public Criteria() {
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public ArrayList<String> getQualification() {
        return qualification;
    }

    public void setQualification(ArrayList<String> qualification) {
        this.qualification = qualification;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public ArrayList<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(ArrayList<String> occupation) {
        this.occupation = occupation;
    }

    public ArrayList<String> getHealthRecord() {
        return healthRecord;
    }

    public void setHealthRecord(ArrayList<String> healthRecord) {
        this.healthRecord = healthRecord;
    }

    public ArrayList<String> getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(ArrayList<String> criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public String getComputerSkill() {
        return computerSkill;
    }

    public void setComputerSkill(String computerSkill) {
        this.computerSkill = computerSkill;
    }

    public ArrayList<String> getLanguageSpoken() {
        return languageSpoken;
    }

    public void setLanguageSpoken(ArrayList<String> languageSpoken) {
        this.languageSpoken = languageSpoken;
    }

    public Criteria(int maxAge, int minAge, ArrayList<String> qualification, int workExperience, ArrayList<String> occupation, ArrayList<String> healthRecord, ArrayList<String> criminalRecord, String computerSkill, ArrayList<String> languageSpoken) {
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.qualification = qualification;
        this.workExperience = workExperience;
        this.occupation = occupation;
        this.healthRecord = healthRecord;
        this.criminalRecord = criminalRecord;
        this.computerSkill = computerSkill;
        this.languageSpoken = languageSpoken;
    }
}

import java.util.ArrayList;

public class Candidate extends Account {
    private String name;
    private String dateOfBirth;
    private String address;
    private String nationality;
    private String id;
    private String gender;
    private ArrayList<String> allergy;
    private ArrayList<String> foodPreference;
    private ArrayList<String> qualification;
    private int workExperience;
    private ArrayList<String> occupation;
    private String computerSkill;
    private ArrayList<String> languageSpoken;

    public Candidate() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getAllergy() {
        return allergy;
    }

    public void setAllergy(ArrayList<String> allergy) {
        this.allergy = allergy;
    }

    public ArrayList<String> getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(ArrayList<String> foodPreference) {
        this.foodPreference = foodPreference;
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

    public Candidate(String name, String dateOfBirth, String address, String nationality, String id, String gender, ArrayList<String> allergy, ArrayList<String> foodPreference, ArrayList<String> qualification, int workExperience, ArrayList<String> occupation, String computerSkill, ArrayList<String> languageSpoken) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.nationality = nationality;
        this.id = id;
        this.gender = gender;
        this.allergy = allergy;
        this.foodPreference = foodPreference;
        this.qualification = qualification;
        this.workExperience = workExperience;
        this.occupation = occupation;
        this.computerSkill = computerSkill;
        this.languageSpoken = languageSpoken;
    }
}

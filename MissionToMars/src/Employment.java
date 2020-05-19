public class Employment {
    private String title;
    private int numberRequired;

    public Employment(String title, int numberRequired) {
        this.title = title;
        this.numberRequired = numberRequired;
    }

    public Employment() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberRequired() {
        return numberRequired;
    }

    public void setNumberRequired(int numberRequired) {
        this.numberRequired = numberRequired;
    }
}

public enum TypeOfTask {
    PERSONAl("личная задача"),
    WORK("рабочая задача");

    private final String title;

    TypeOfTask(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

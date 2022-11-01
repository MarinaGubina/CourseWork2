public enum Repeatable {

    SINGLE_Task("однократная"),
    DAILY_Task("ежедневная"),
    WEEKLY_Task("еженедельная"),
    MONTHLY_Task("ежемесячная"),
    YEARLY_TASK("ежегодная");

    private String str;

    Repeatable(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

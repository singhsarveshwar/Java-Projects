package school.subject;

public enum StartingYear {FOUR(4),FIVE(5),SIZ(6),SEVEN(7);
private int grade;
    private StartingYear(int grade){
        this.grade=grade;
    }

    public int getYear()
    {
        return grade;
    }

}
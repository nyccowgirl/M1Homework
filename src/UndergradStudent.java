public class UndergradStudent extends Student {
    private static final boolean DEFAULT_TUITION_PD = true;

    private boolean tuitionPd;

    public UndergradStudent(String firstName, String lastName, int studentID, boolean tuitionPd) {
        super(firstName, lastName, studentID);
        this.tuitionPd = tuitionPd;
    }

    public UndergradStudent(String firstName, String lastName, int studentID) {
        this(firstName, lastName, studentID, DEFAULT_TUITION_PD);
    }

    public boolean isTuitionPd() {
        return tuitionPd;
    }

    public void setTuitionPd(boolean tuitionPd) {
        this.tuitionPd = tuitionPd;
    }

    @Override
    public String toString() {
        return super.toString() + "\tTuition Paid: " + tuitionPd;
    }
}

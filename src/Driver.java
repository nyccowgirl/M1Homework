import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // For #17 - Computer Class
        Computer comp = new Computer("Apple", "MacBook", "256GB");

        System.out.println(comp);

        // For #20 - UndergradStudent, GradStudent, Student Classes
        Student stud = new Student("Oscar", "Meyer", 123456);
        UndergradStudent undergradStudent = new UndergradStudent("Aunt", "Jemima",98765, false);
        GradStudent gradStudent = new GradStudent("Brad", "Pitt", 2468);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(stud);
        studentArrayList.add(undergradStudent);
        studentArrayList.add(gradStudent);

        int countSInName = 0, countTuitionNotPd = 0;

        for (Student student : studentArrayList) {
            if (student.getFirstName().toLowerCase().contains("s") || student.getLastName().toLowerCase().contains("s")) {
                countSInName++;
            }

            if (student instanceof UndergradStudent) {
                UndergradStudent undergradStudent1 = (UndergradStudent) student;
                if (!(undergradStudent1.isTuitionPd())) {
                    countTuitionNotPd++;
                }
            }
        }

        System.out.println(countSInName + " student(s) have 's' in their names.");
        System.out.println(countTuitionNotPd + " undergraduate student(s) have not paid their tuition.");

    }

}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StudentServiceTest {

    private Student s(String name, int age, double gpa) {
        return new Student(name, age, gpa);
    }

    @Test
    void calculateAverageGpa_empty_returnsZero() {
        StudentService service = new StudentService();
        assertEquals(0.0, service.calculateAverageGpa(), 1e-9);
    }

    @Test
    void addStudent_thenAverageIsCorrect() {
        StudentService service = new StudentService();
        service.addStudent(s("A", 20, 4.0));
        service.addStudent(s("B", 21, 2.0));

        assertEquals(3.0, service.calculateAverageGpa(), 1e-9);
    }

    @Test
    void getTopStudent_empty_returnsNull() {
        StudentService service = new StudentService();
        assertNull(service.getTopStudent());
    }

    @Test
    void getTopStudent_returnsHighestGpaStudent() {
        StudentService service = new StudentService();
        service.addStudent(s("A", 20, 3.2));
        service.addStudent(s("B", 21, 3.9));
        service.addStudent(s("C", 22, 2.5));

        Student top = service.getTopStudent();
        assertNotNull(top);
        assertEquals("B", top.getName());
        assertEquals(3.9, top.getGpa(), 1e-9);
    }

    @Test
    void removeStudentByName_existingStudent_removedAndAffectsResults() {
        StudentService service = new StudentService();
        service.addStudent(s("A", 20, 4.0));
        service.addStudent(s("B", 21, 2.0));
        service.addStudent(s("C", 22, 3.0));

        service.removeStudentByName("A"); // remove top

        Student top = service.getTopStudent();
        assertNotNull(top);
        assertNotEquals("A", top.getName());

        assertEquals(2.5, service.calculateAverageGpa(), 1e-9); // (2+3)/2
    }

    @Test
    void removeStudentByName_nonExisting_doesNothing() {
        StudentService service = new StudentService();
        service.addStudent(s("A", 20, 3.0));
        service.addStudent(s("B", 21, 3.0));

        double before = service.calculateAverageGpa();
        service.removeStudentByName("Z");
        double after = service.calculateAverageGpa();

        assertEquals(before, after, 1e-9);
    }
}

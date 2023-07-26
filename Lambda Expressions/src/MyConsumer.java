import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumer {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("John"));
        studentList.add(new Student("Peter"));
        studentList.add(new Student("King"));

        studentList.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student + " anonymous class implementing Consumer<T>");
            }
        });

        studentList.forEach(new ConsumerFunctionClass());
        studentList.forEach(student -> System.out.println(student + " lambda"));

        studentList.get(0).printMyNamePlease(new ConsumerFunctionClass());
        studentList.get(1).printMyNamePlease(student -> System.out.println(student));


    }
}
class ConsumerFunctionClass implements Consumer<Student> {
    public void accept(Student student) {
        System.out.println(student + " ConsumerFunctionClass that implements Consumer<T>");
    }
}

class Student {
    String name;
    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void printMyNamePlease(Consumer<Student> functionToCall) {
        functionToCall.accept(this);
    }
}


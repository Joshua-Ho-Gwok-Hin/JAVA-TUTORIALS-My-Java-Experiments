import java.util.Objects;

public class ClassWithSameHashCodes {
    String name;
    String secondName;

    public ClassWithSameHashCodes(String name) {
        this.name = name;
        secondName = "john";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassWithSameHashCodes that = (ClassWithSameHashCodes) o;

        return secondName.equals(that.secondName);
    }

    @Override
    public int hashCode() {
        return secondName.hashCode();
    }
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
}

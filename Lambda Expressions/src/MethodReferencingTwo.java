public class MethodReferencingTwo {
    public static void main(String[] args) {
        String strin = "One";

        System.out.println(new LongByte() {
            @Override
            public long returnLongWithByte(byte b) {
                return MySpecialUser.staticIntShort(b);
            }
        }.returnLongWithByte((byte) 32));

        LongByte longByteInterfaceInLambda = p -> MySpecialUser.staticIntShort(p);
        System.out.println(longByteInterfaceInLambda.returnLongWithByte((byte) 24));

//        LongByte longByte = String::charAt;


        LongByte methodRef = MySpecialUser::staticIntShort;
        System.out.println(methodRef.returnLongWithByte((byte) 16));

        NumberShort nShort = MySpecialUser::staticLongInt;
        System.out.println(nShort.numberShort((short) 16));

        NumberString numberString = MySpecialUser::staticIntCharSeq;
        NumberString lambda = str -> MySpecialUser.staticIntCharSeq(str);

        NumberString one = String::length;
        NumberString onse = s -> s.length();

//        NumberString two = strin::length;

        IntString three = String::length;
        IntString thdree = s -> s.length();



    }
}

class MySpecialUser {
    static int staticIntShort(short s) {
        return s;
    }

    static long staticLongInt(int i) {
        return i;
    }

    static int staticIntCharSeq(CharSequence charSequence) {
        return 3;
    }

    int returnInt() {
        return 3;
    }
}
interface LongByte {
    long returnLongWithByte(byte b);
}

interface NumberShort {
    Number numberShort(short s);
}

interface NumberNumber {
    Number numberNumber(Number number);
}

interface NumberString {
    Number numberString(String s);
}

interface IntString {
    int intString(String s);
}

interface IntMySpecialUser {
    int intMySpecialUser(MySpecialUser user);
}
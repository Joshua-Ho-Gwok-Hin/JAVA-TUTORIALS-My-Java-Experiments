public class MethodReferencingTwo {
    public static void main(String[] args) {

        System.out.println(new LongByte() {
            @Override
            public long returnLongWithByte(byte b) {
                return MySpecialUser.staticIntShort(b);
            }
        }.returnLongWithByte((byte) 32));

        LongByte longByteInterfaceInLambda = p -> MySpecialUser.staticIntShort(p);
        System.out.println(longByteInterfaceInLambda.returnLongWithByte((byte) 24));

        LongByte methodRef = MySpecialUser::staticIntShort;
        System.out.println(methodRef.returnLongWithByte((byte) 16));

        NumberShort nShort = MySpecialUser::staticLongInt;
        System.out.println(nShort.numberShort((short) 16));

    }
}

class MySpecialUser {
    static int staticIntShort(short s) {
        return s;
    }

    static long staticLongInt(int i) {
        return i;
    }
}
interface LongByte {
    long returnLongWithByte(byte b);
}

interface NumberShort {
    Number numberShort(short s);
}
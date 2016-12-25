package org.hewei.jvm;

import sun.misc.Unsafe;

import java.lang.StringBuilder;
import java.lang.reflect.Field;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * @author hw
 */
public class RuntimeConstantPoolOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
//        List<String> list = new ArrayList<String>();
//
//        int i  = 0;
//        while(true) {
//            list.add(String.valueOf(i++).intern());
//        }
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}

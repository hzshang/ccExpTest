package com.Exp;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;

public class Exp {

    public static void main(String[] args) throws Exception {

        FileInputStream fi = new FileInputStream("exp.bin");
        ObjectInputStream ois = new ObjectInputStream(fi);
        Object d = (Object) ois
                .readObject();
        ois.close();
        System.out.println(d.getClass());
    }
}

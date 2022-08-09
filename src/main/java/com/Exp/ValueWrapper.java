package com.Exp;

import java.io.Serializable;

import org.apache.commons.collections.Transformer;

public class ValueWrapper implements Transformer, Serializable {
    public Object transform(Object input) {
        String a = (String) input;
        return (Object) ("value_" + a);
    }
}
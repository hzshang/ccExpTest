package com.Exp;

import java.io.Serializable;

import org.apache.commons.collections.Transformer;

class KeyWrapper implements Transformer, Serializable {
    public Object transform(Object input) {
        String a = (String) input;
        return (Object) ("key_" + a);
    }
}
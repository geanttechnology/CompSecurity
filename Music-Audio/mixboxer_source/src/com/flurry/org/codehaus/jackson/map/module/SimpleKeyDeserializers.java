// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.module;

import com.flurry.org.codehaus.jackson.map.BeanDescription;
import com.flurry.org.codehaus.jackson.map.BeanProperty;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.KeyDeserializer;
import com.flurry.org.codehaus.jackson.map.KeyDeserializers;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.util.HashMap;

public class SimpleKeyDeserializers
    implements KeyDeserializers
{

    protected HashMap _classMappings;

    public SimpleKeyDeserializers()
    {
        _classMappings = null;
    }

    public SimpleKeyDeserializers addDeserializer(Class class1, KeyDeserializer keydeserializer)
    {
        if (_classMappings == null)
        {
            _classMappings = new HashMap();
        }
        _classMappings.put(new ClassKey(class1), keydeserializer);
        return this;
    }

    public KeyDeserializer findKeyDeserializer(JavaType javatype, DeserializationConfig deserializationconfig, BeanDescription beandescription, BeanProperty beanproperty)
    {
        if (_classMappings == null)
        {
            return null;
        } else
        {
            return (KeyDeserializer)_classMappings.get(new ClassKey(javatype.getRawClass()));
        }
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.module;

import com.flurry.org.codehaus.jackson.map.BeanDescription;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import java.util.HashMap;

public class SimpleValueInstantiators extends com.flurry.org.codehaus.jackson.map.deser.ValueInstantiators.Base
{

    protected HashMap _classMappings;

    public SimpleValueInstantiators()
    {
        _classMappings = new HashMap();
    }

    public SimpleValueInstantiators addValueInstantiator(Class class1, ValueInstantiator valueinstantiator)
    {
        _classMappings.put(new ClassKey(class1), valueinstantiator);
        return this;
    }

    public ValueInstantiator findValueInstantiator(DeserializationConfig deserializationconfig, BeanDescription beandescription, ValueInstantiator valueinstantiator)
    {
        deserializationconfig = (ValueInstantiator)_classMappings.get(new ClassKey(beandescription.getBeanClass()));
        if (deserializationconfig == null)
        {
            return valueinstantiator;
        } else
        {
            return deserializationconfig;
        }
    }
}

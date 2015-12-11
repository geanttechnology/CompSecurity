// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;

public class SimpleValueInstantiators extends com.fasterxml.jackson.databind.deser.ValueInstantiators.Base
    implements Serializable
{

    protected HashMap _classMappings;

    public SimpleValueInstantiators()
    {
        _classMappings = new HashMap();
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

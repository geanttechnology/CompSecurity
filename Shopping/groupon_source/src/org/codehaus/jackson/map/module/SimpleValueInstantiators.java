// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.module;

import java.util.HashMap;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.deser.ValueInstantiator;
import org.codehaus.jackson.map.type.ClassKey;

public class SimpleValueInstantiators extends org.codehaus.jackson.map.deser.ValueInstantiators.Base
{

    protected HashMap _classMappings;

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

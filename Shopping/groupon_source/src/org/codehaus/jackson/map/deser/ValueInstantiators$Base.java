// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.DeserializationConfig;

// Referenced classes of package org.codehaus.jackson.map.deser:
//            ValueInstantiators, ValueInstantiator

public static class 
    implements ValueInstantiators
{

    public ValueInstantiator findValueInstantiator(DeserializationConfig deserializationconfig, BeanDescription beandescription, ValueInstantiator valueinstantiator)
    {
        return valueinstantiator;
    }
}

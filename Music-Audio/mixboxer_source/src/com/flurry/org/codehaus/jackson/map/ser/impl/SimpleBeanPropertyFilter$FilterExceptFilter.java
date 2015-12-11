// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.ser.BeanPropertyWriter;
import java.util.Set;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ser.impl:
//            SimpleBeanPropertyFilter

public static class _propertiesToInclude extends SimpleBeanPropertyFilter
{

    protected final Set _propertiesToInclude;

    public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, BeanPropertyWriter beanpropertywriter)
        throws Exception
    {
        if (_propertiesToInclude.contains(beanpropertywriter.getName()))
        {
            beanpropertywriter.serializeAsField(obj, jsongenerator, serializerprovider);
        }
    }

    public (Set set)
    {
        _propertiesToInclude = set;
    }
}

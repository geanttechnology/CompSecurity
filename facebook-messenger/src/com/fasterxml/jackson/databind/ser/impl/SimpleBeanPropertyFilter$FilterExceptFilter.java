// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import java.util.Set;

// Referenced classes of package com.fasterxml.jackson.databind.ser.impl:
//            SimpleBeanPropertyFilter

public class _propertiesToInclude extends SimpleBeanPropertyFilter
{

    protected final Set _propertiesToInclude;

    public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, BeanPropertyWriter beanpropertywriter)
    {
        if (_propertiesToInclude.contains(beanpropertywriter.getName()))
        {
            beanpropertywriter.serializeAsField(obj, jsongenerator, serializerprovider);
        }
    }

    public Y(Set set)
    {
        _propertiesToInclude = set;
    }
}

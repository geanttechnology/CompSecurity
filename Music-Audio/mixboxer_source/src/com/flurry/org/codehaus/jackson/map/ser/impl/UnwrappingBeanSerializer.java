// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.map.JsonSerializer;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.ser.std.BeanSerializerBase;
import java.io.IOException;

public class UnwrappingBeanSerializer extends BeanSerializerBase
{

    public UnwrappingBeanSerializer(BeanSerializerBase beanserializerbase)
    {
        super(beanserializerbase);
    }

    public boolean isUnwrappingSerializer()
    {
        return true;
    }

    public final void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (_propertyFilterId != null)
        {
            serializeFieldsFiltered(obj, jsongenerator, serializerprovider);
            return;
        } else
        {
            serializeFields(obj, jsongenerator, serializerprovider);
            return;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("UnwrappingBeanSerializer for ").append(handledType().getName()).toString();
    }

    public JsonSerializer unwrappingSerializer()
    {
        return this;
    }
}

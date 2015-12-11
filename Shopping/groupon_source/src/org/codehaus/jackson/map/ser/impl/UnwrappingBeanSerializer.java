// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.ser.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.BeanSerializerBase;

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

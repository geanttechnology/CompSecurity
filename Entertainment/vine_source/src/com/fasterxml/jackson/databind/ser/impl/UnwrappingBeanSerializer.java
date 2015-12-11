// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.ser.impl:
//            ObjectIdWriter

public class UnwrappingBeanSerializer extends BeanSerializerBase
{

    protected final NameTransformer _nameTransformer;

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingbeanserializer, ObjectIdWriter objectidwriter)
    {
        super(unwrappingbeanserializer, objectidwriter);
        _nameTransformer = unwrappingbeanserializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingbeanserializer, ObjectIdWriter objectidwriter, Object obj)
    {
        super(unwrappingbeanserializer, objectidwriter, obj);
        _nameTransformer = unwrappingbeanserializer._nameTransformer;
    }

    protected UnwrappingBeanSerializer(UnwrappingBeanSerializer unwrappingbeanserializer, String as[])
    {
        super(unwrappingbeanserializer, as);
        _nameTransformer = unwrappingbeanserializer._nameTransformer;
    }

    public UnwrappingBeanSerializer(BeanSerializerBase beanserializerbase, NameTransformer nametransformer)
    {
        super(beanserializerbase, nametransformer);
        _nameTransformer = nametransformer;
    }

    protected BeanSerializerBase asArraySerializer()
    {
        return this;
    }

    public boolean isUnwrappingSerializer()
    {
        return true;
    }

    public final void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (_objectIdWriter != null)
        {
            _serializeWithObjectId(obj, jsongenerator, serializerprovider, false);
            return;
        }
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

    public JsonSerializer unwrappingSerializer(NameTransformer nametransformer)
    {
        return new UnwrappingBeanSerializer(this, nametransformer);
    }

    protected BeanSerializerBase withFilterId(Object obj)
    {
        return new UnwrappingBeanSerializer(this, _objectIdWriter, obj);
    }

    protected BeanSerializerBase withIgnorals(String as[])
    {
        return new UnwrappingBeanSerializer(this, as);
    }

    public BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectidwriter)
    {
        return new UnwrappingBeanSerializer(this, objectidwriter);
    }
}

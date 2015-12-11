// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;

public class AnyGetterWriter
{

    protected final AnnotatedMember _accessor;
    protected final BeanProperty _property;
    protected MapSerializer _serializer;

    public AnyGetterWriter(BeanProperty beanproperty, AnnotatedMember annotatedmember, MapSerializer mapserializer)
    {
        _accessor = annotatedmember;
        _property = beanproperty;
        _serializer = mapserializer;
    }

    public void getAndSerialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws Exception
    {
        obj = _accessor.getValue(obj);
        if (obj == null)
        {
            return;
        }
        if (!(obj instanceof Map))
        {
            throw new JsonMappingException((new StringBuilder()).append("Value returned by 'any-getter' (").append(_accessor.getName()).append("()) not java.util.Map but ").append(obj.getClass().getName()).toString());
        } else
        {
            _serializer.serializeFields((Map)obj, jsongenerator, serializerprovider);
            return;
        }
    }

    public void resolve(SerializerProvider serializerprovider)
        throws JsonMappingException
    {
        _serializer = (MapSerializer)_serializer.createContextual(serializerprovider, _property);
    }
}

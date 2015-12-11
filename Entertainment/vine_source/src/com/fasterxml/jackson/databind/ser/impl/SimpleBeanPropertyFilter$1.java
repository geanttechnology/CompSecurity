// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;

// Referenced classes of package com.fasterxml.jackson.databind.ser.impl:
//            SimpleBeanPropertyFilter

static final class val.src
    implements PropertyFilter
{

    final BeanPropertyFilter val$src;

    public void depositSchemaProperty(PropertyWriter propertywriter, JsonObjectFormatVisitor jsonobjectformatvisitor, SerializerProvider serializerprovider)
        throws JsonMappingException
    {
        val$src.depositSchemaProperty((BeanPropertyWriter)propertywriter, jsonobjectformatvisitor, serializerprovider);
    }

    public void depositSchemaProperty(PropertyWriter propertywriter, ObjectNode objectnode, SerializerProvider serializerprovider)
        throws JsonMappingException
    {
        val$src.depositSchemaProperty((BeanPropertyWriter)propertywriter, objectnode, serializerprovider);
    }

    public void serializeAsElement(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, PropertyWriter propertywriter)
        throws Exception
    {
        throw new UnsupportedOperationException();
    }

    public void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, PropertyWriter propertywriter)
        throws Exception
    {
        val$src.serializeAsField(obj, jsongenerator, serializerprovider, (BeanPropertyWriter)propertywriter);
    }

    isitor(BeanPropertyFilter beanpropertyfilter)
    {
        val$src = beanpropertyfilter;
        super();
    }
}

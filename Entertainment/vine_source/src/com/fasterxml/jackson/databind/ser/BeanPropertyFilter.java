// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;

// Referenced classes of package com.fasterxml.jackson.databind.ser:
//            BeanPropertyWriter

public interface BeanPropertyFilter
{

    public abstract void depositSchemaProperty(BeanPropertyWriter beanpropertywriter, JsonObjectFormatVisitor jsonobjectformatvisitor, SerializerProvider serializerprovider)
        throws JsonMappingException;

    public abstract void depositSchemaProperty(BeanPropertyWriter beanpropertywriter, ObjectNode objectnode, SerializerProvider serializerprovider)
        throws JsonMappingException;

    public abstract void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, BeanPropertyWriter beanpropertywriter)
        throws Exception;
}

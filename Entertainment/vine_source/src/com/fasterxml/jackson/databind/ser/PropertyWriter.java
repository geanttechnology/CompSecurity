// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class PropertyWriter
{

    public PropertyWriter()
    {
    }

    public abstract void depositSchemaProperty(JsonObjectFormatVisitor jsonobjectformatvisitor)
        throws JsonMappingException;

    public abstract void depositSchemaProperty(ObjectNode objectnode, SerializerProvider serializerprovider)
        throws JsonMappingException;

    public abstract PropertyName getFullName();

    public abstract String getName();

    public abstract void serializeAsElement(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws Exception;

    public abstract void serializeAsField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws Exception;

    public abstract void serializeAsOmittedField(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws Exception;

    public abstract void serializeAsPlaceholder(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws Exception;
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class CoreXMLSerializers extends com.fasterxml.jackson.databind.ser.Serializers.Base
{
    public static class XMLGregorianCalendarSerializer extends StdSerializer
    {

        public static final XMLGregorianCalendarSerializer instance = new XMLGregorianCalendarSerializer();

        public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
            throws JsonMappingException
        {
            CalendarSerializer.instance.acceptJsonFormatVisitor(jsonformatvisitorwrapper, null);
        }

        public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
            throws JsonMappingException
        {
            return CalendarSerializer.instance.getSchema(serializerprovider, type);
        }

        public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            serialize((XMLGregorianCalendar)obj, jsongenerator, serializerprovider);
        }

        public void serialize(XMLGregorianCalendar xmlgregoriancalendar, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
            throws IOException, JsonGenerationException
        {
            CalendarSerializer.instance.serialize(xmlgregoriancalendar.toGregorianCalendar(), jsongenerator, serializerprovider);
        }


        public XMLGregorianCalendarSerializer()
        {
            super(javax/xml/datatype/XMLGregorianCalendar);
        }
    }


    public CoreXMLSerializers()
    {
    }

    public JsonSerializer findSerializer(SerializationConfig serializationconfig, JavaType javatype, BeanDescription beandescription)
    {
        serializationconfig = javatype.getRawClass();
        if (javax/xml/datatype/Duration.isAssignableFrom(serializationconfig) || javax/xml/namespace/QName.isAssignableFrom(serializationconfig))
        {
            return ToStringSerializer.instance;
        }
        if (javax/xml/datatype/XMLGregorianCalendar.isAssignableFrom(serializationconfig))
        {
            return XMLGregorianCalendarSerializer.instance;
        } else
        {
            return null;
        }
    }
}

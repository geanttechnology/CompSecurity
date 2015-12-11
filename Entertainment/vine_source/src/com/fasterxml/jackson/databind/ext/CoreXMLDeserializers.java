// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class CoreXMLDeserializers extends com.fasterxml.jackson.databind.deser.Deserializers.Base
{
    public static class DurationDeserializer extends FromStringDeserializer
    {

        public static final DurationDeserializer instance = new DurationDeserializer();
        private static final long serialVersionUID = 1L;

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }

        protected Duration _deserialize(String s, DeserializationContext deserializationcontext)
            throws IllegalArgumentException
        {
            return CoreXMLDeserializers._dataTypeFactory.newDuration(s);
        }


        public DurationDeserializer()
        {
            super(javax/xml/datatype/Duration);
        }
    }

    public static class GregorianCalendarDeserializer extends StdScalarDeserializer
    {

        public static final GregorianCalendarDeserializer instance = new GregorianCalendarDeserializer();
        private static final long serialVersionUID = 1L;

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public XMLGregorianCalendar deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            java.util.Date date = _parseDate(jsonparser, deserializationcontext);
            if (date == null)
            {
                return null;
            }
            jsonparser = new GregorianCalendar();
            jsonparser.setTime(date);
            deserializationcontext = deserializationcontext.getTimeZone();
            if (deserializationcontext != null)
            {
                jsonparser.setTimeZone(deserializationcontext);
            }
            return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(jsonparser);
        }


        public GregorianCalendarDeserializer()
        {
            super(javax/xml/datatype/XMLGregorianCalendar);
        }
    }

    public static class QNameDeserializer extends FromStringDeserializer
    {

        public static final QNameDeserializer instance = new QNameDeserializer();
        private static final long serialVersionUID = 1L;

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException
        {
            return _deserialize(s, deserializationcontext);
        }

        protected QName _deserialize(String s, DeserializationContext deserializationcontext)
            throws IllegalArgumentException
        {
            return QName.valueOf(s);
        }


        public QNameDeserializer()
        {
            super(javax/xml/namespace/QName);
        }
    }


    static final DatatypeFactory _dataTypeFactory;

    public CoreXMLDeserializers()
    {
    }

    public JsonDeserializer findBeanDeserializer(JavaType javatype, DeserializationConfig deserializationconfig, BeanDescription beandescription)
    {
        javatype = javatype.getRawClass();
        if (javatype == javax/xml/namespace/QName)
        {
            return QNameDeserializer.instance;
        }
        if (javatype == javax/xml/datatype/XMLGregorianCalendar)
        {
            return GregorianCalendarDeserializer.instance;
        }
        if (javatype == javax/xml/datatype/Duration)
        {
            return DurationDeserializer.instance;
        } else
        {
            return null;
        }
    }

    static 
    {
        try
        {
            _dataTypeFactory = DatatypeFactory.newInstance();
        }
        catch (DatatypeConfigurationException datatypeconfigurationexception)
        {
            throw new RuntimeException(datatypeconfigurationexception);
        }
    }
}

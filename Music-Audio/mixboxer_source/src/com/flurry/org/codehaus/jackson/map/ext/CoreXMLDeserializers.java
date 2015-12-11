// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.deser.std.FromStringDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdScalarDeserializer;
import com.flurry.org.codehaus.jackson.map.util.Provider;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

public class CoreXMLDeserializers
    implements Provider
{
    public static class DurationDeserializer extends FromStringDeserializer
    {

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
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

        public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            return deserialize(jsonparser, deserializationcontext);
        }

        public XMLGregorianCalendar deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
        {
            jsonparser = _parseDate(jsonparser, deserializationcontext);
            if (jsonparser == null)
            {
                return null;
            } else
            {
                deserializationcontext = new GregorianCalendar();
                deserializationcontext.setTime(jsonparser);
                return CoreXMLDeserializers._dataTypeFactory.newXMLGregorianCalendar(deserializationcontext);
            }
        }

        public GregorianCalendarDeserializer()
        {
            super(javax/xml/datatype/XMLGregorianCalendar);
        }
    }

    public static class QNameDeserializer extends FromStringDeserializer
    {

        protected volatile Object _deserialize(String s, DeserializationContext deserializationcontext)
            throws IOException, JsonProcessingException
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

    public Collection provide()
    {
        return Arrays.asList(new StdDeserializer[] {
            new DurationDeserializer(), new GregorianCalendarDeserializer(), new QNameDeserializer()
        });
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

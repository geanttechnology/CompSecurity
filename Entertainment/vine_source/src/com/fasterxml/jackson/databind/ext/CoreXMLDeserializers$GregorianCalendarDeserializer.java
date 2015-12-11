// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ext;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import java.io.IOException;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

// Referenced classes of package com.fasterxml.jackson.databind.ext:
//            CoreXMLDeserializers

public static class  extends StdScalarDeserializer
{

    public static final _parseDate instance = new <init>();
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


    public ()
    {
        super(javax/xml/datatype/XMLGregorianCalendar);
    }
}

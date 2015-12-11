// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;

public class JsonSerializer
{

    private final ObjectMapper mapper;

    public JsonSerializer(ObjectMapper objectmapper)
    {
        mapper = objectmapper;
    }

    public String serialize(Object obj)
    {
        try
        {
            StringWriter stringwriter = new StringWriter();
            com.fasterxml.jackson.core.JsonGenerator jsongenerator = (new MappingJsonFactory(mapper)).createJsonGenerator(stringwriter);
            mapper.writeValue(jsongenerator, obj);
            obj = stringwriter.toString();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new CimIOException(((IOException) (obj)));
        }
        return ((String) (obj));
    }
}

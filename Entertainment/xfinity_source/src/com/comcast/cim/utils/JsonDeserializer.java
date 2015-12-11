// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringReader;

public class JsonDeserializer
{

    private final ObjectMapper mapper;

    public JsonDeserializer(ObjectMapper objectmapper)
    {
        mapper = objectmapper;
    }

    public Object deserialize(String s, Class class1)
    {
        s = new StringReader(s);
        try
        {
            s = ((String) (mapper.readValue(s, class1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new CimIOException(s);
        }
        return s;
    }
}

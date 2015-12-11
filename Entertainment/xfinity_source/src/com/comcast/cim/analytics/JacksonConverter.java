// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.analytics;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;

public class JacksonConverter
    implements com.squareup.tape.FileObjectQueue.Converter
{

    private final ObjectMapper objectMapper;
    private final Class type;

    public JacksonConverter(ObjectMapper objectmapper, Class class1)
    {
        objectMapper = objectmapper;
        type = class1;
    }

    public Object from(byte abyte0[])
        throws IOException
    {
        return objectMapper.readValue(abyte0, type);
    }

    public void toStream(Object obj, OutputStream outputstream)
        throws IOException
    {
        objectMapper.writeValue(outputstream, obj);
    }
}

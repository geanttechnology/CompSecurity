// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.jackson;

import com.amazon.searchapp.retailsearch.client.web.ObjectParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.jackson:
//            EntityModule

public class StandardParser
    implements ObjectParser
{

    private static ObjectMapper mapper;

    public StandardParser()
    {
    }

    public static ObjectMapper getMapper()
    {
        com/amazon/searchapp/retailsearch/client/jackson/StandardParser;
        JVM INSTR monitorenter ;
        ObjectMapper objectmapper;
        if (mapper == null)
        {
            mapper = new ObjectMapper();
            mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.registerModule(EntityModule.getModule());
        }
        objectmapper = mapper;
        com/amazon/searchapp/retailsearch/client/jackson/StandardParser;
        JVM INSTR monitorexit ;
        return objectmapper;
        Exception exception;
        exception;
        throw exception;
    }

    public Object parse(InputStream inputstream, Class class1)
        throws IOException
    {
        return getMapper().readValue(inputstream, class1);
    }
}

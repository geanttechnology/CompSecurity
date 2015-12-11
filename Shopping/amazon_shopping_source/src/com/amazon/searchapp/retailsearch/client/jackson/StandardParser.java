// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.jackson;

import com.amazon.searchapp.retailsearch.client.web.ObjectParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.jackson:
//            EntityMap

public class StandardParser
    implements ObjectParser
{

    private static ObjectMapper mapper;

    public StandardParser()
    {
    }

    public static void addTypes(SimpleModule simplemodule)
    {
        EntityMap.mapTypes(simplemodule);
    }

    public static void configureMapper(ObjectMapper objectmapper)
    {
        objectmapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectmapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static ObjectMapper getMapper()
    {
        com/amazon/searchapp/retailsearch/client/jackson/StandardParser;
        JVM INSTR monitorenter ;
        ObjectMapper objectmapper;
        if (mapper == null)
        {
            mapper = new ObjectMapper();
            configureMapper(mapper);
            SimpleModule simplemodule = new SimpleModule(com/amazon/searchapp/retailsearch/client/jackson/StandardParser.getSimpleName(), Version.unknownVersion());
            addTypes(simplemodule);
            mapper.registerModule(simplemodule);
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

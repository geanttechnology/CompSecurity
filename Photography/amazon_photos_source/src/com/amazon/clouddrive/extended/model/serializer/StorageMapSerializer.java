// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.JsonGenerator;

public class StorageMapSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new StorageMapSerializer();

    private StorageMapSerializer()
    {
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((Map)obj, jsongenerator);
    }

    public void serialize(Map map, JsonGenerator jsongenerator)
        throws IOException
    {
        if (map == null)
        {
            jsongenerator.writeNull();
            return;
        }
        jsongenerator.writeStartObject();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); SimpleSerializers.serializeLong((Long)entry.getValue(), jsongenerator))
        {
            entry = (java.util.Map.Entry)map.next();
            jsongenerator.writeFieldName((String)entry.getKey());
        }

        jsongenerator.writeEndObject();
    }

}

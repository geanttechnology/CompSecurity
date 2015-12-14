// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer

public class ListSerializer
    implements JsonSerializer
{

    private final JsonSerializer mSerializer;

    public ListSerializer(JsonSerializer jsonserializer)
    {
        mSerializer = jsonserializer;
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((List)obj, jsongenerator);
    }

    public void serialize(List list, JsonGenerator jsongenerator)
        throws IOException
    {
        if (list == null)
        {
            jsongenerator.writeNull();
            return;
        }
        jsongenerator.writeStartArray();
        Object obj;
        for (list = list.iterator(); list.hasNext(); mSerializer.serialize(obj, jsongenerator))
        {
            obj = list.next();
        }

        jsongenerator.writeEndArray();
    }
}

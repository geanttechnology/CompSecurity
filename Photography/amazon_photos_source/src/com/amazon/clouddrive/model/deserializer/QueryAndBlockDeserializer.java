// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.QueryAndBlock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, QueryFilterDeserializer

public class QueryAndBlockDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new QueryAndBlockDeserializer();

    private QueryAndBlockDeserializer()
    {
    }

    public QueryAndBlock deserialize(JsonParser jsonparser)
        throws IOException
    {
        Object obj = jsonparser.getCurrentToken();
        if (obj == JsonToken.VALUE_NULL)
        {
            return null;
        }
        if (obj != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(obj).toString(), jsonparser.getTokenLocation());
        }
        obj = new QueryAndBlock();
        ArrayList arraylist = new ArrayList();
        for (; jsonparser.nextToken() != JsonToken.END_OBJECT; arraylist.add(QueryFilterDeserializer.INSTANCE.deserialize(jsonparser)))
        {
            if (jsonparser.isClosed())
            {
                throw new JsonParseException("Unexpected end of input", jsonparser.getTokenLocation());
            }
        }

        ((QueryAndBlock) (obj)).setFilters(arraylist);
        return ((QueryAndBlock) (obj));
    }

    public volatile Object deserialize(JsonParser jsonparser)
        throws IOException
    {
        return deserialize(jsonparser);
    }

}

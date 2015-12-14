// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.QueryFilter;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, SimpleListDeserializers

public class QueryFilterDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new QueryFilterDeserializer();

    private QueryFilterDeserializer()
    {
    }

    public QueryFilter deserialize(JsonParser jsonparser)
        throws IOException
    {
        Object obj = jsonparser.getCurrentToken();
        if (obj == JsonToken.VALUE_NULL)
        {
            return null;
        }
        if (jsonparser.getCurrentToken() != JsonToken.FIELD_NAME)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected field name, got ").append(obj).toString(), jsonparser.getTokenLocation());
        }
        obj = new QueryFilter(jsonparser.getCurrentName());
        jsonparser.nextToken();
        if (jsonparser.isClosed())
        {
            throw new JsonParseException("Unexpected end of input", jsonparser.getTokenLocation());
        } else
        {
            ((QueryFilter) (obj)).setValues((List)SimpleListDeserializers.STRING_LIST_DESERIALIZER.deserialize(jsonparser));
            return ((QueryFilter) (obj));
        }
    }

    public volatile Object deserialize(JsonParser jsonparser)
        throws IOException
    {
        return deserialize(jsonparser);
    }

}

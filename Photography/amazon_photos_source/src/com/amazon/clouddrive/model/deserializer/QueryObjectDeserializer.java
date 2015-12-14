// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.QueryObject;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, ObjectIdListDeserializer, QueryAndBlockListDeserializer

public class QueryObjectDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new QueryObjectDeserializer();

    private QueryObjectDeserializer()
    {
    }

    public QueryObject deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((QueryObject) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        QueryObject queryobject = new QueryObject();
        do
        {
            obj = queryobject;
            if (jsonparser.nextToken() == JsonToken.END_OBJECT)
            {
                continue;
            }
            if (jsonparser.getCurrentToken() != JsonToken.FIELD_NAME)
            {
                throw new JsonParseException((new StringBuilder()).append("Expected field name, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
            }
            obj = jsonparser.getCurrentName();
            if (jsonparser.nextToken() == null)
            {
                throw new JsonParseException("Unexpected end of input", jsonparser.getTokenLocation());
            }
            if ("excludedIds".equals(obj))
            {
                queryobject.setExcludedIds((List)ObjectIdListDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            if ("include".equals(obj))
            {
                queryobject.setInclude((List)QueryAndBlockListDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            {
                jsonparser.skipChildren();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object deserialize(JsonParser jsonparser)
        throws IOException
    {
        return deserialize(jsonparser);
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, SimpleDeserializers

public class NodeIdListDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new NodeIdListDeserializer();

    private NodeIdListDeserializer()
    {
    }

    public volatile Object deserialize(JsonParser jsonparser)
        throws IOException
    {
        return deserialize(jsonparser);
    }

    public List deserialize(JsonParser jsonparser)
        throws IOException
    {
        Object obj = jsonparser.getCurrentToken();
        if (obj != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((List) (obj));
_L2:
        if (obj != JsonToken.START_ARRAY)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of array, got ").append(obj).toString(), jsonparser.getTokenLocation());
        }
        ArrayList arraylist = new ArrayList();
        do
        {
            obj = arraylist;
            if (jsonparser.nextToken() == JsonToken.END_ARRAY)
            {
                continue;
            }
            if (jsonparser.isClosed())
            {
                throw new JsonParseException("Unexpected end of input", jsonparser.getTokenLocation());
            }
            arraylist.add(SimpleDeserializers.deserializeString(jsonparser));
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}

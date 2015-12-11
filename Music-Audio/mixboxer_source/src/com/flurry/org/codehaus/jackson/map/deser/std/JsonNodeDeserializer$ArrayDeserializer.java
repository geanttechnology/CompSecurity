// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.node.ArrayNode;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            BaseNodeDeserializer, JsonNodeDeserializer

static final class  extends BaseNodeDeserializer
{

    protected static final deserialize _instance = new <init>();

    public static  getInstance()
    {
        return _instance;
    }

    public ArrayNode deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (jsonparser.isExpectedStartArrayToken())
        {
            return deserializeArray(jsonparser, deserializationcontext, deserializationcontext.getNodeFactory());
        } else
        {
            throw deserializationcontext.mappingException(com/flurry/org/codehaus/jackson/node/ArrayNode);
        }
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }


    protected ()
    {
        super(com/flurry/org/codehaus/jackson/node/ArrayNode);
    }
}

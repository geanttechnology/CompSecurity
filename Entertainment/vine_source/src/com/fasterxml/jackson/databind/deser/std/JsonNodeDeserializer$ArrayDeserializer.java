// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            BaseNodeDeserializer, JsonNodeDeserializer

static final class  extends BaseNodeDeserializer
{

    protected static final deserialize _instance = new <init>();
    private static final long serialVersionUID = 1L;

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
            throw deserializationcontext.mappingException(com/fasterxml/jackson/databind/node/ArrayNode);
        }
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }


    protected ()
    {
        super(com/fasterxml/jackson/databind/node/ArrayNode);
    }
}

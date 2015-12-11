// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.node:
//            MissingNode, TreeTraversingParser

public abstract class BaseJsonNode extends JsonNode
    implements JsonSerializable
{

    protected BaseJsonNode()
    {
    }

    public abstract JsonToken asToken();

    public final JsonNode findPath(String s)
    {
        JsonNode jsonnode = findValue(s);
        s = jsonnode;
        if (jsonnode == null)
        {
            s = MissingNode.getInstance();
        }
        return s;
    }

    public com.fasterxml.jackson.core.JsonParser.NumberType numberType()
    {
        return null;
    }

    public abstract void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException;

    public abstract void serializeWithType(JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException;

    public JsonParser traverse()
    {
        return new TreeTraversingParser(this);
    }

    public JsonParser traverse(ObjectCodec objectcodec)
    {
        return new TreeTraversingParser(this, objectcodec);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.JsonSerializableWithType;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.flurry.org.codehaus.jackson.node:
//            MissingNode, TreeTraversingParser, ObjectNode

public abstract class BaseJsonNode extends JsonNode
    implements JsonSerializableWithType
{

    protected BaseJsonNode()
    {
    }

    public abstract JsonToken asToken();

    public volatile JsonNode findParent(String s)
    {
        return findParent(s);
    }

    public ObjectNode findParent(String s)
    {
        return null;
    }

    public List findParents(String s, List list)
    {
        return list;
    }

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

    public JsonNode findValue(String s)
    {
        return null;
    }

    public List findValues(String s, List list)
    {
        return list;
    }

    public List findValuesAsText(String s, List list)
    {
        return list;
    }

    public com.flurry.org.codehaus.jackson.JsonParser.NumberType getNumberType()
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
}

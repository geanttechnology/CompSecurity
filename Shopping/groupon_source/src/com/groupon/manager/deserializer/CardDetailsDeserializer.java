// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.deserializer;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import roboguice.util.Ln;

public class CardDetailsDeserializer extends JsonDeserializer
{

    public CardDetailsDeserializer()
    {
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public Map deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        ObjectMapper objectmapper = (ObjectMapper)jsonparser.getCodec();
        org.codehaus.jackson.map.type.MapType maptype = objectmapper.getTypeFactory().constructMapType(java/util/LinkedHashMap, java/lang/String, java/lang/Object);
        deserializationcontext = null;
        JsonNode jsonnode;
        try
        {
            jsonnode = jsonparser.readValueAsTree();
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            Ln.e(jsonparser);
            return null;
        }
        jsonparser = deserializationcontext;
        if (jsonnode.isObject())
        {
            jsonparser = (LinkedHashMap)objectmapper.readValue(jsonnode, maptype);
        }
        return jsonparser;
    }
}

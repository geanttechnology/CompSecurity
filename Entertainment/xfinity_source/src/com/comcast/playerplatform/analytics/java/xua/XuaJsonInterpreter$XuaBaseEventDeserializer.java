// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            XuaJsonInterpreter, XuaBaseEvent

private static class registry extends StdDeserializer
{

    private Map registry;

    public XuaBaseEvent deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        ObjectMapper objectmapper = (ObjectMapper)jsonparser.getCodec();
        deserializationcontext = (ObjectNode)objectmapper.readTree(jsonparser);
        Object obj = null;
        Iterator iterator = deserializationcontext.fields();
        do
        {
            deserializationcontext = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            deserializationcontext = (String)((java.util.vent)iterator.next()).vent();
            if (!registry.containsKey(deserializationcontext))
            {
                continue;
            }
            deserializationcontext = (Class)registry.get(deserializationcontext);
            break;
        } while (true);
        if (deserializationcontext == null)
        {
            return null;
        } else
        {
            return (XuaBaseEvent)objectmapper.readValue(jsonparser, deserializationcontext);
        }
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    void registerXuaBaseEvent(String s, Class class1)
    {
        registry.put(s, class1);
    }

    ()
    {
        super(com/comcast/playerplatform/analytics/java/xua/XuaBaseEvent);
        registry = new HashMap();
    }
}

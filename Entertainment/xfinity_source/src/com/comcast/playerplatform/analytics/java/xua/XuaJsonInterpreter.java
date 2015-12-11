// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;

import com.comcast.playerplatform.analytics.java.xua.events.XuaHeartbeatEvent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.comcast.playerplatform.analytics.java.xua:
//            XuaBaseEvent, XuaMessage, XuaEvent, XuaGenericEvent

public class XuaJsonInterpreter
    implements com.comcast.playerplatform.analytics.java.util.JsonFileIo.JsonInterpreter
{
    private static class XuaBaseEventDeserializer extends StdDeserializer
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
                deserializationcontext = (String)((java.util.Map.Entry)iterator.next()).getKey();
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

        XuaBaseEventDeserializer()
        {
            super(com/comcast/playerplatform/analytics/java/xua/XuaBaseEvent);
            registry = new HashMap();
        }
    }


    private final ObjectMapper mapper;

    public XuaJsonInterpreter()
    {
        this(new ObjectMapper());
    }

    public XuaJsonInterpreter(ObjectMapper objectmapper)
    {
        mapper = objectmapper;
        setupXuaBaseDeserializer(mapper);
    }

    private void setupXuaBaseDeserializer(ObjectMapper objectmapper)
    {
        XuaBaseEventDeserializer xuabaseeventdeserializer = new XuaBaseEventDeserializer() {

            final XuaJsonInterpreter this$0;

            
            {
                this$0 = XuaJsonInterpreter.this;
                super();
                registerXuaBaseEvent("XuaEvent", com/comcast/playerplatform/analytics/java/xua/XuaEvent);
                registerXuaBaseEvent("XuaGenericEvent", com/comcast/playerplatform/analytics/java/xua/XuaGenericEvent);
                registerXuaBaseEvent("XuaHeartbeatEvent", com/comcast/playerplatform/analytics/java/xua/events/XuaHeartbeatEvent);
            }
        };
        SimpleModule simplemodule = new SimpleModule("SimpleModule", new Version(0, 3, 1, "0.3.001", "com.comcast.playerplatform", "java_analytics"));
        simplemodule.addDeserializer(com/comcast/playerplatform/analytics/java/xua/XuaBaseEvent, xuabaseeventdeserializer);
        objectmapper.registerModule(simplemodule);
    }

    public XuaMessage fromJson(String s)
        throws IOException
    {
        return (XuaMessage)mapper.readValue(s, com/comcast/playerplatform/analytics/java/xua/XuaMessage);
    }

    public volatile Object fromJson(String s)
        throws IOException
    {
        return fromJson(s);
    }

    public String toJson(XuaMessage xuamessage)
        throws IOException
    {
        return mapper.writeValueAsString(xuamessage);
    }

    public volatile String toJson(Object obj)
        throws IOException
    {
        return toJson((XuaMessage)obj);
    }
}

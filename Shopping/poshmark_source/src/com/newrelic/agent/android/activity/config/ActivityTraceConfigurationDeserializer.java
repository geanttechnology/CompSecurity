// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.activity.config;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonDeserializationContext;
import com.newrelic.com.google.gson.JsonDeserializer;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonParseException;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

// Referenced classes of package com.newrelic.agent.android.activity.config:
//            ActivityTraceConfiguration

public class ActivityTraceConfigurationDeserializer
    implements JsonDeserializer
{

    private final AgentLog log = AgentLogManager.getAgentLog();

    public ActivityTraceConfigurationDeserializer()
    {
    }

    private void error(String s)
    {
        log.error((new StringBuilder()).append("ActivityTraceConfigurationDeserializer: ").append(s).toString());
    }

    private Integer getInteger(JsonElement jsonelement)
    {
        if (!jsonelement.isJsonPrimitive())
        {
            error("Expected an integer.");
            return null;
        }
        jsonelement = jsonelement.getAsJsonPrimitive();
        if (!jsonelement.isNumber())
        {
            error("Expected an integer.");
            return null;
        }
        int i = jsonelement.getAsInt();
        if (i < 0)
        {
            error("Integer value must not be negative");
            return null;
        } else
        {
            return Integer.valueOf(i);
        }
    }

    public ActivityTraceConfiguration deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        type = new ActivityTraceConfiguration();
        if (!jsonelement.isJsonArray())
        {
            error("Expected root element to be an array.");
            return null;
        }
        jsonelement = jsonelement.getAsJsonArray();
        if (jsonelement.size() != 2)
        {
            error("Root array must contain 2 elements.");
            return null;
        }
        jsonelement = getInteger(jsonelement.get(0));
        if (jsonelement == null)
        {
            return null;
        }
        if (jsonelement.intValue() < 0)
        {
            error("The first element of the root array must not be negative.");
            return null;
        } else
        {
            type.setMaxTotalTraceCount(jsonelement.intValue());
            return type;
        }
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }
}

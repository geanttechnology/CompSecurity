// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Map;

public class Event extends HarvestableArray
{

    private long eventName;
    private Map params;
    private long timestamp;

    public Event()
    {
        params = new HashMap();
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        jsonarray.add(new JsonPrimitive(Long.valueOf(timestamp)));
        jsonarray.add(new JsonPrimitive(Long.valueOf(eventName)));
        jsonarray.add((new Gson()).toJsonTree(params, GSON_STRING_MAP_TYPE));
        return jsonarray;
    }

    public long getEventName()
    {
        return eventName;
    }

    public Map getParams()
    {
        return params;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setEventName(long l)
    {
        eventName = l;
    }

    public void setParams(Map map)
    {
        params = map;
    }

    public void setTimestamp(long l)
    {
        timestamp = l;
    }
}

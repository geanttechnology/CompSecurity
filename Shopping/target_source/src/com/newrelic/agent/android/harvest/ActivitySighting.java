// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ActivitySighting extends HarvestableArray
{

    private long durationMs;
    private String name;
    private final long timestampMs;

    public ActivitySighting(long l, String s)
    {
        durationMs = 0L;
        timestampMs = l;
        name = s;
    }

    public static ActivitySighting newFromJson(JsonArray jsonarray)
    {
        return new ActivitySighting(jsonarray.get(0).getAsLong(), jsonarray.get(1).getAsString());
    }

    public JsonArray asJsonArray()
    {
        JsonArray jsonarray = new JsonArray();
        this;
        JVM INSTR monitorenter ;
        jsonarray.add(new JsonPrimitive(name));
        jsonarray.add(new JsonPrimitive(Long.valueOf(timestampMs)));
        jsonarray.add(new JsonPrimitive(Long.valueOf(durationMs)));
        this;
        JVM INSTR monitorexit ;
        return jsonarray;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public JsonArray asJsonArrayWithoutDuration()
    {
        JsonArray jsonarray = new JsonArray();
        this;
        JVM INSTR monitorenter ;
        jsonarray.add(new JsonPrimitive(Long.valueOf(timestampMs)));
        jsonarray.add(new JsonPrimitive(name));
        this;
        JVM INSTR monitorexit ;
        return jsonarray;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void end(long l)
    {
        this;
        JVM INSTR monitorenter ;
        durationMs = l - timestampMs;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long getDuration()
    {
        return durationMs;
    }

    public String getName()
    {
        return name;
    }

    public long getTimestampMs()
    {
        return timestampMs;
    }

    public void setName(String s)
    {
        this;
        JVM INSTR monitorenter ;
        name = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }
}

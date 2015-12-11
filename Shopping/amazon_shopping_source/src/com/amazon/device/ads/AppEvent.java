// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class AppEvent
{

    private final String eventName;
    private final HashMap properties;
    private final long timestamp;

    protected AppEvent(String s)
    {
        this(s, -1L);
    }

    public AppEvent(String s, long l)
    {
        eventName = s;
        timestamp = l;
        properties = new HashMap();
    }

    public static AppEvent createAppEventWithTimestamp(AppEvent appevent, long l)
    {
        return new AppEvent(appevent.eventName, l);
    }

    public String getEventName()
    {
        return eventName;
    }

    public String getProperty(String s)
    {
        return (String)properties.get(s);
    }

    public Set getPropertyEntries()
    {
        return properties.entrySet();
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public AppEvent setProperty(String s, String s1)
    {
        properties.put(s, s1);
        return this;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(65);
        stringbuilder.append("Application Event {Name: ");
        stringbuilder.append(eventName);
        stringbuilder.append(", Timestamp: ");
        stringbuilder.append(timestamp);
        String s;
        for (Iterator iterator = properties.keySet().iterator(); iterator.hasNext(); stringbuilder.append((String)properties.get(s)))
        {
            s = (String)iterator.next();
            stringbuilder.append(", ");
            stringbuilder.append(s);
            stringbuilder.append(": ");
        }

        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}

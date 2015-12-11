// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import com.amazon.device.analytics.util.JSONBuilder;
import com.amazon.device.analytics.util.JSONSerializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class Event
    implements JSONSerializable
{

    private String applicationKey;
    private final Map attributes;
    private String eventType;
    private final Map metrics;
    private Long timestamp;
    private String uniqueId;

    public Event(Event event)
    {
        attributes = new ConcurrentHashMap();
        metrics = new ConcurrentHashMap();
        timestamp = null;
        uniqueId = null;
        if (event != null)
        {
            applicationKey = event.getApplicationKey();
            eventType = event.getEventType();
            timestamp = event.getEventTimestamp();
            uniqueId = event.getUniqueId();
            java.util.Map.Entry entry1;
            for (Iterator iterator = event.getAllAttributes().entrySet().iterator(); iterator.hasNext(); addAttribute((String)entry1.getKey(), (String)entry1.getValue()))
            {
                entry1 = (java.util.Map.Entry)iterator.next();
            }

            java.util.Map.Entry entry;
            for (event = event.getAllMetrics().entrySet().iterator(); event.hasNext(); addMetric((String)entry.getKey(), (Number)entry.getValue()))
            {
                entry = (java.util.Map.Entry)event.next();
            }

        } else
        {
            applicationKey = null;
            eventType = null;
        }
    }

    public Event(String s, String s1)
    {
        attributes = new ConcurrentHashMap();
        metrics = new ConcurrentHashMap();
        timestamp = null;
        uniqueId = null;
        applicationKey = s;
        eventType = s1;
    }

    public Event(String s, String s1, Event event)
    {
        this(event);
        applicationKey = s;
        eventType = s1;
    }

    public void addAttribute(String s, String s1)
    {
        attributes.put(s, s1);
    }

    public void addMetric(String s, Number number)
    {
        if (number != null)
        {
            metrics.put(s, number);
        }
    }

    public Event copy()
    {
        return new Event(this);
    }

    public Map getAllAttributes()
    {
        return attributes;
    }

    public Map getAllMetrics()
    {
        return metrics;
    }

    public String getApplicationKey()
    {
        return applicationKey;
    }

    public Long getEventTimestamp()
    {
        return timestamp;
    }

    public String getEventType()
    {
        return eventType;
    }

    public Number getMetric(String s)
    {
        return (Number)metrics.get(s);
    }

    public String getUniqueId()
    {
        return uniqueId;
    }

    public boolean hasAttribute(String s)
    {
        return attributes.containsKey(s);
    }

    public boolean hasMetric(String s)
    {
        return metrics.containsKey(s);
    }

    public void setEventTimestamp(Long long1)
    {
        timestamp = long1;
    }

    public void setUniqueId(String s)
    {
        uniqueId = s;
    }

    public JSONObject toJSONObject()
    {
        JSONBuilder jsonbuilder = new JSONBuilder(this);
        jsonbuilder.withAttribute("application_key", getApplicationKey());
        jsonbuilder.withAttribute("event_type", getEventType());
        jsonbuilder.withAttribute("timestamp", getEventTimestamp());
        jsonbuilder.withAttribute("unique_id", getUniqueId());
        JSONObject jsonobject = new JSONObject();
        for (Iterator iterator = getAllAttributes().entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            try
            {
                jsonobject.put((String)entry.getKey(), entry.getValue());
            }
            catch (JSONException jsonexception) { }
        }

        JSONObject jsonobject1 = new JSONObject();
        Iterator iterator1 = getAllMetrics().entrySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (((Number)entry1.getValue()).getClass() != null)
            {
                try
                {
                    jsonobject1.put((String)entry1.getKey(), new BigDecimal(((Number)entry1.getValue()).toString()));
                }
                catch (JSONException jsonexception1) { }
            }
        } while (true);
        if (jsonobject.length() > 0)
        {
            jsonbuilder.withAttribute("attributes", jsonobject);
        }
        if (jsonobject1.length() > 0)
        {
            jsonbuilder.withAttribute("metrics", jsonobject1);
        }
        return jsonbuilder.toJSONObject();
    }

    public String toString()
    {
        JSONObject jsonobject = toJSONObject();
        String s;
        try
        {
            s = jsonobject.toString(4);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject.toString();
        }
        return s;
    }
}

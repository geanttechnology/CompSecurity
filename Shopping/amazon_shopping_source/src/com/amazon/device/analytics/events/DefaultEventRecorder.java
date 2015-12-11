// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import com.amazon.device.analytics.events.observers.EventObserver;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.JSONBuilder;
import com.amazon.device.analytics.util.JSONSerializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.events:
//            EventRecorder, DefaultEventRecorderBuilder, Event, UniqueIdService

public class DefaultEventRecorder
    implements EventRecorder, JSONSerializable
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/DefaultEventRecorder);
    private final String applicationKey;
    private final Map eventTypeAttributes = new ConcurrentHashMap();
    private final Map eventTypeMetrics = new ConcurrentHashMap();
    private final Map globalAttributes = new ConcurrentHashMap();
    private final Map globalMetrics = new ConcurrentHashMap();
    private List observers;

    public DefaultEventRecorder(DefaultEventRecorderBuilder defaulteventrecorderbuilder)
    {
        observers = defaulteventrecorderbuilder.getObservers();
        applicationKey = defaulteventrecorderbuilder.getApplicationKey();
    }

    public void addGlobalAttribute(String s, String s1)
    {
        if (s == null)
        {
            logger.v("Null key provided to addGlobalAttribute");
            return;
        }
        if (s1 == null)
        {
            logger.v((new StringBuilder()).append("Null value provided to addGlobalAttribute. key:").append(s).toString());
            return;
        } else
        {
            globalAttributes.put(s, s1);
            return;
        }
    }

    public Event createEvent(String s)
    {
        return new Event(applicationKey, s);
    }

    public List getObservers()
    {
        if (observers == null)
        {
            observers = new ArrayList();
        }
        return observers;
    }

    public void notifyObservers(Event event)
    {
        logger.v("Notifying EventObservers");
        if (logger.isLoggingEnabled(com.amazon.device.analytics.log.Logging.LogLevel.VERBOSE))
        {
            logger.v(event.toString());
        }
        for (Iterator iterator = getObservers().iterator(); iterator.hasNext(); ((EventObserver)iterator.next()).notify(event)) { }
    }

    public void recordEvent(Event event)
    {
        if (event == null)
        {
            logger.i("The provided event was null");
            return;
        }
        event = event.copy();
        event.setEventTimestamp(Long.valueOf(System.currentTimeMillis()));
        event.setUniqueId(UniqueIdService.getUniqueId());
        this;
        JVM INSTR monitorenter ;
        if (eventTypeAttributes.containsKey(event.getEventType()))
        {
            Iterator iterator = ((Map)eventTypeAttributes.get(event.getEventType())).entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (!event.hasAttribute((String)entry.getKey()))
                {
                    event.addAttribute((String)entry.getKey(), (String)entry.getValue());
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_145;
        event;
        this;
        JVM INSTR monitorexit ;
        throw event;
        Iterator iterator1 = globalAttributes.entrySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (!event.hasAttribute((String)entry1.getKey()))
            {
                event.addAttribute((String)entry1.getKey(), (String)entry1.getValue());
            }
        } while (true);
        if (eventTypeMetrics.containsKey(event.getEventType()))
        {
            Iterator iterator2 = ((Map)eventTypeMetrics.get(event.getEventType())).entrySet().iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator2.next();
                if (!event.hasMetric((String)entry2.getKey()))
                {
                    event.addMetric((String)entry2.getKey(), (Number)entry2.getValue());
                }
            } while (true);
        }
        Iterator iterator3 = globalMetrics.entrySet().iterator();
        do
        {
            if (!iterator3.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator3.next();
            if (!event.hasMetric((String)entry3.getKey()))
            {
                event.addMetric((String)entry3.getKey(), (Number)entry3.getValue());
            }
        } while (true);
        this;
        JVM INSTR monitorexit ;
        if (logger.isLoggingEnabled(com.amazon.device.analytics.log.Logging.LogLevel.VERBOSE))
        {
            logger.v(String.format("Recording Event: %s", new Object[] {
                event.toString()
            }));
        }
        notifyObservers(event);
        return;
    }

    public JSONObject toJSONObject()
    {
        JSONArray jsonarray = new JSONArray();
        if (observers != null)
        {
            for (Iterator iterator = observers.iterator(); iterator.hasNext();)
            {
                EventObserver eventobserver = (EventObserver)iterator.next();
                if (com/amazon/device/analytics/util/JSONSerializable.isAssignableFrom(eventobserver.getClass()))
                {
                    jsonarray.put(((JSONSerializable)eventobserver).toJSONObject());
                } else
                {
                    jsonarray.put(eventobserver);
                }
            }

        }
        JSONArray jsonarray1 = new JSONArray();
        if (globalAttributes != null)
        {
            for (Iterator iterator1 = globalAttributes.entrySet().iterator(); iterator1.hasNext();)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                try
                {
                    JSONObject jsonobject1 = new JSONObject();
                    jsonobject1.put((String)entry.getKey(), entry.getValue());
                    jsonarray1.put(jsonobject1);
                }
                catch (JSONException jsonexception) { }
            }

        }
        JSONArray jsonarray2 = new JSONArray();
        if (globalMetrics != null)
        {
            for (Iterator iterator2 = globalMetrics.entrySet().iterator(); iterator2.hasNext();)
            {
                java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator2.next();
                try
                {
                    JSONObject jsonobject3 = new JSONObject();
                    jsonobject3.put((String)entry1.getKey(), entry1.getValue());
                    jsonarray2.put(jsonobject3);
                }
                catch (JSONException jsonexception1) { }
            }

        }
        JSONObject jsonobject = new JSONObject();
        if (eventTypeAttributes != null)
        {
            for (Iterator iterator3 = eventTypeAttributes.entrySet().iterator(); iterator3.hasNext();)
            {
                java.util.Map.Entry entry2 = (java.util.Map.Entry)iterator3.next();
                JSONArray jsonarray3 = new JSONArray();
                for (Iterator iterator5 = ((Map)entry2.getValue()).entrySet().iterator(); iterator5.hasNext();)
                {
                    java.util.Map.Entry entry4 = (java.util.Map.Entry)iterator5.next();
                    try
                    {
                        JSONObject jsonobject4 = new JSONObject();
                        jsonobject4.put((String)entry4.getKey(), entry4.getValue());
                        jsonarray3.put(jsonobject4);
                    }
                    catch (JSONException jsonexception4) { }
                }

                try
                {
                    jsonobject.put((String)entry2.getKey(), jsonarray3);
                }
                catch (JSONException jsonexception2) { }
            }

        }
        JSONObject jsonobject2 = new JSONObject();
        if (eventTypeMetrics != null)
        {
            for (Iterator iterator4 = eventTypeMetrics.entrySet().iterator(); iterator4.hasNext();)
            {
                java.util.Map.Entry entry3 = (java.util.Map.Entry)iterator4.next();
                JSONArray jsonarray4 = new JSONArray();
                for (Iterator iterator6 = ((Map)entry3.getValue()).entrySet().iterator(); iterator6.hasNext();)
                {
                    java.util.Map.Entry entry5 = (java.util.Map.Entry)iterator6.next();
                    try
                    {
                        JSONObject jsonobject5 = new JSONObject();
                        jsonobject5.put((String)entry5.getKey(), entry5.getValue());
                        jsonarray4.put(jsonobject5);
                    }
                    catch (JSONException jsonexception5) { }
                }

                try
                {
                    jsonobject2.put((String)entry3.getKey(), jsonarray4);
                }
                catch (JSONException jsonexception3) { }
            }

        }
        return (new JSONBuilder(this)).withAttribute("applicationKey", applicationKey).withAttribute("uniqueId", UniqueIdService.getUniqueId()).withAttribute("observers", jsonarray).withAttribute("globalAttributes", jsonarray1).withAttribute("globalMetrics", jsonarray2).withAttribute("eventTypeAttributes", jsonobject).withAttribute("eventTypeMetrics", jsonobject2).toJSONObject();
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

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.event;

import com.amazon.insights.Event;
import com.amazon.insights.InsightsCredentials;
import com.amazon.insights.core.InsightsContext;
import com.amazon.insights.core.configuration.Configuration;
import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.JSONBuilder;
import com.amazon.insights.core.util.JSONSerializable;
import com.amazon.insights.core.util.Preconditions;
import com.amazon.insights.core.util.StringUtil;
import com.amazon.insights.delivery.DeliveryClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.event:
//            InternalEventClient, EventConstraintDecorator, DefaultEvent, EventObserver, 
//            InternalEvent

public class DefaultEventClient
    implements JSONSerializable, InternalEventClient
{

    private static Logger logger = Logger.getLogger(com/amazon/insights/event/DefaultEventClient);
    private boolean allowEventCollection;
    private final InsightsContext context;
    private final DeliveryClient deliveryClient;
    private final Map eventTypeAttributes = new ConcurrentHashMap();
    private final Map eventTypeMetrics = new ConcurrentHashMap();
    private final Map globalAttributes = new ConcurrentHashMap();
    private final Map globalMetrics = new ConcurrentHashMap();
    private List observers;
    private Map reservedAttributes;

    DefaultEventClient(InsightsContext insightscontext, boolean flag)
    {
        observers = new CopyOnWriteArrayList();
        reservedAttributes = new ConcurrentHashMap();
        allowEventCollection = true;
        Preconditions.checkNotNull(insightscontext, "A valid context must be provided");
        Preconditions.checkNotNull(insightscontext.getDeliveryClient(), "A valid DeliveryClient must be provided");
        allowEventCollection = flag;
        context = insightscontext;
        reservedAttributes.put(insightscontext.getConfiguration().optString("versionKey", "ver"), "v1.2");
        deliveryClient = insightscontext.getDeliveryClient();
        addEventObserver(deliveryClient);
    }

    public static DefaultEventClient newInstance(InsightsContext insightscontext, boolean flag)
    {
        return new DefaultEventClient(insightscontext, flag);
    }

    public void addEventObserver(EventObserver eventobserver)
    {
        logger.v("Adding EventObserver");
        if (eventobserver == null)
        {
            logger.v("Null EventObserver provided to addObserver");
        } else
        {
            if (logger.isLoggingEnabled(com.amazon.insights.core.log.Logger.LogLevel.VERBOSE))
            {
                logger.v(eventobserver.toString());
            }
            if (!getEventObservers().contains(eventobserver))
            {
                getEventObservers().add(eventobserver);
                return;
            }
            logger.v("Observer was already registered with this EventRecorder");
            if (logger.isLoggingEnabled(com.amazon.insights.core.log.Logger.LogLevel.VERBOSE))
            {
                logger.v(toString());
                return;
            }
        }
    }

    public void addGlobalAttribute(String s, String s1)
    {
        if (s == null)
        {
            logger.v("Null attribute name provided to addGlobalAttribute");
            return;
        }
        if (s1 == null)
        {
            logger.v((new StringBuilder()).append("Null attribute value provided to addGlobalAttribute. attribute name:").append(s).toString());
            return;
        } else
        {
            globalAttributes.put(s, s1);
            return;
        }
    }

    public Event createEvent(String s)
    {
        if (s == null)
        {
            logger.v("Null eventType provided to addGlobalAttribute");
            logger.devi("Null eventType provided to createEvent");
            throw new IllegalArgumentException("The eventType passed into create event was null");
        }
        String s1 = StringUtil.clipString(s, 50, false);
        if (s1.length() < s.length())
        {
            logger.devw("The event type has been trimmed to a length of 50 characters");
        }
        return EventConstraintDecorator.newInstance(createInternalEvent(s1));
    }

    public InternalEvent createInternalEvent(String s)
    {
        return DefaultEvent.newInstance(context, Long.valueOf(System.currentTimeMillis()), s);
    }

    public boolean getAllowEventCollection()
    {
        return allowEventCollection;
    }

    protected List getEventObservers()
    {
        if (observers == null)
        {
            observers = new ArrayList();
        }
        return observers;
    }

    protected void notifyObservers(InternalEvent internalevent)
    {
        logger.v("Notifying EventObservers");
        if (logger.isLoggingEnabled(com.amazon.insights.core.log.Logger.LogLevel.VERBOSE))
        {
            logger.v(internalevent.toString());
        }
        for (Iterator iterator = getEventObservers().iterator(); iterator.hasNext(); ((EventObserver)iterator.next()).notify(internalevent)) { }
    }

    public void recordEvent(Event event)
    {
        recordEvent(event, true);
    }

    public void recordEvent(Event event, boolean flag)
    {
        if (event != null) goto _L2; else goto _L1
_L1:
        logger.i("The provided event was null");
        logger.devi("The provided event was null");
_L4:
        return;
_L2:
        if (!context.getConfiguration().optBoolean("isAnalyticsEnabled", Boolean.valueOf(true)).booleanValue() || !getAllowEventCollection()) goto _L4; else goto _L3
_L3:
        event = DefaultEvent.createFromEvent(context, Long.valueOf(System.currentTimeMillis()), event);
        this;
        JVM INSTR monitorenter ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_479;
        }
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
        break MISSING_BLOCK_LABEL_198;
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
        Iterator iterator4 = reservedAttributes.entrySet().iterator();
_L5:
        java.util.Map.Entry entry4;
        do
        {
            if (!iterator4.hasNext())
            {
                break MISSING_BLOCK_LABEL_646;
            }
            entry4 = (java.util.Map.Entry)iterator4.next();
            if (!event.hasAttribute((String)entry4.getKey()))
            {
                break MISSING_BLOCK_LABEL_617;
            }
            String s = event.getAttribute((String)entry4.getKey());
            event.addAttribute((String)entry4.getKey(), (String)entry4.getValue());
            event.addAttribute((new StringBuilder()).append("ud_").append((String)entry4.getKey()).toString(), s);
        } while (true);
        event.addAttribute((String)entry4.getKey(), (String)entry4.getValue());
          goto _L5
        this;
        JVM INSTR monitorexit ;
        notifyObservers(event);
        return;
    }

    public void removeGlobalAttribute(String s)
    {
        if (s == null)
        {
            logger.v("Null attribute name provided to removeGlobalAttribute");
            return;
        } else
        {
            globalAttributes.remove(s);
            return;
        }
    }

    public void submitEvents()
    {
        logger.v("Notifying deliveryClient");
        deliveryClient.attemptDelivery();
    }

    public JSONObject toJSONObject()
    {
        JSONArray jsonarray = new JSONArray();
        if (observers != null)
        {
            for (Iterator iterator = observers.iterator(); iterator.hasNext();)
            {
                EventObserver eventobserver = (EventObserver)iterator.next();
                if (com/amazon/insights/core/util/JSONSerializable.isAssignableFrom(eventobserver.getClass()))
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
        String s = context.getCredentials().getApplicationKey();
        return (new JSONBuilder(this)).withAttribute("applicationKey", s).withAttribute("uniqueId", context.getUniqueId()).withAttribute("observers", jsonarray).withAttribute("globalAttributes", jsonarray1).withAttribute("globalMetrics", jsonarray2).withAttribute("eventTypeAttributes", jsonobject).withAttribute("eventTypeMetrics", jsonobject2).toJSONObject();
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

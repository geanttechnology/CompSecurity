// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEventCategory, AnalyticAttribute

public class AnalyticsEvent extends HarvestableObject
{

    private Set attributeSet;
    private AnalyticsEventCategory category;
    private String eventType;
    private final AgentLog log;
    private String name;
    private long timestamp;

    protected AnalyticsEvent(String s)
    {
        this(s, AnalyticsEventCategory.Custom, null, null);
    }

    protected AnalyticsEvent(String s, AnalyticsEventCategory analyticseventcategory)
    {
        this(s, analyticseventcategory, null, null);
    }

    protected AnalyticsEvent(String s, AnalyticsEventCategory analyticseventcategory, String s1, Set set)
    {
        log = AgentLogManager.getAgentLog();
        attributeSet = Collections.synchronizedSet(new HashSet());
        name = s;
        if (analyticseventcategory == null)
        {
            category = AnalyticsEventCategory.Custom;
        } else
        {
            category = analyticseventcategory;
        }
        timestamp = System.currentTimeMillis();
        if (set != null)
        {
            AnalyticAttribute analyticattribute;
            for (set = set.iterator(); set.hasNext(); attributeSet.add(new AnalyticAttribute(analyticattribute)))
            {
                analyticattribute = (AnalyticAttribute)set.next();
            }

        }
        if (s != null)
        {
            attributeSet.add(new AnalyticAttribute("name", s));
        }
        attributeSet.add(new AnalyticAttribute("timestamp", String.valueOf(timestamp)));
        attributeSet.add(new AnalyticAttribute("category", analyticseventcategory.name()));
        if (s1 != null)
        {
            attributeSet.add(new AnalyticAttribute("eventType", s1));
            return;
        } else
        {
            attributeSet.add(new AnalyticAttribute("eventType", "Mobile"));
            return;
        }
    }

    public void addAttributes(Set set)
    {
        if (set != null)
        {
            set = set.iterator();
            do
            {
                if (!set.hasNext())
                {
                    break;
                }
                AnalyticAttribute analyticattribute = (AnalyticAttribute)set.next();
                if (!attributeSet.add(analyticattribute))
                {
                    log.error((new StringBuilder()).append("Failed to add attribute ").append(analyticattribute.getName()).append(" to event ").append(getName()).append(": the event already contains that attribute.").toString());
                }
            } while (true);
        }
    }

    public JsonObject asJsonObject()
    {
        JsonObject jsonobject = new JsonObject();
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = attributeSet.iterator();
_L2:
        Object obj;
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_97;
        }
        obj = (AnalyticAttribute)iterator.next();
        s = ((AnalyticAttribute) (obj)).getName();
        if (!((AnalyticAttribute) (obj)).isStringAttribute())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new JsonPrimitive(((AnalyticAttribute) (obj)).getStringValue());
_L3:
        jsonobject.add(s, ((com.newrelic.com.google.gson.JsonElement) (obj)));
        if (true) goto _L2; else goto _L1
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
_L1:
        obj = new JsonPrimitive(Float.valueOf(((AnalyticAttribute) (obj)).getFloatValue()));
          goto _L3
        this;
        JVM INSTR monitorexit ;
        return jsonobject;
    }

    public Collection getAttributeSet()
    {
        return Collections.unmodifiableCollection(attributeSet);
    }

    public AnalyticsEventCategory getCategory()
    {
        return category;
    }

    public String getEventType()
    {
        return eventType;
    }

    public String getName()
    {
        return name;
    }

    public long getTimestamp()
    {
        return timestamp;
    }
}

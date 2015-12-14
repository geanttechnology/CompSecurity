// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.impl;

import com.amazon.insights.Event;
import com.amazon.insights.EventClient;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.insights.impl:
//            DisabledAmazonInsights

class val.theEventName
    implements Event
{

    final addMetric this$1;
    final Map val$attributes;
    final Map val$metrics;
    final String val$theEventName;

    public void addAttribute(String s, String s1)
    {
        if (s == null)
        {
            return;
        }
        if (s1 != null)
        {
            val$attributes.put(s, s1);
            return;
        } else
        {
            val$attributes.remove(s);
            return;
        }
    }

    public void addMetric(String s, Number number)
    {
        if (s == null)
        {
            return;
        }
        if (number != null)
        {
            val$metrics.put(s, number);
            return;
        } else
        {
            val$metrics.remove(s);
            return;
        }
    }

    public Map getAllAttributes()
    {
        return Collections.unmodifiableMap(val$attributes);
    }

    public Map getAllMetrics()
    {
        return Collections.unmodifiableMap(val$metrics);
    }

    public String getAttribute(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (String)val$attributes.get(s);
        }
    }

    public String getEventType()
    {
        return val$theEventName;
    }

    public boolean hasAttribute(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return val$attributes.containsKey(s);
        }
    }

    public boolean hasMetric(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return val$metrics.containsKey(s);
        }
    }

    public Event withAttribute(String s, String s1)
    {
        addAttribute(s, s1);
        return this;
    }

    public Event withMetric(String s, Number number)
    {
        addMetric(s, number);
        return this;
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$attributes = map;
        val$metrics = map1;
        val$theEventName = String.this;
        super();
    }

    // Unreferenced inner class com/amazon/insights/impl/DisabledAmazonInsights$2

/* anonymous class */
    class DisabledAmazonInsights._cls2
        implements EventClient
    {

        final DisabledAmazonInsights this$0;

        public void addGlobalAttribute(String s, String s1)
        {
        }

        public Event createEvent(String s)
        {
            return s. new DisabledAmazonInsights._cls2._cls1();
        }

        public void recordEvent(Event event)
        {
        }

        public void removeGlobalAttribute(String s)
        {
        }

        public void submitEvents()
        {
        }

            
            {
                this$0 = DisabledAmazonInsights.this;
                super();
            }
    }

}

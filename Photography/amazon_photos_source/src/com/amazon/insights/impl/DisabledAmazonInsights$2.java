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

class this._cls0
    implements EventClient
{

    final DisabledAmazonInsights this$0;

    public void addGlobalAttribute(String s, String s1)
    {
    }

    public Event createEvent(String s)
    {
        return new Event() {

            final DisabledAmazonInsights._cls2 this$1;
            final Map val$attributes;
            final Map val$metrics;
            final String val$theEventName;

            public void addAttribute(String s1, String s2)
            {
                if (s1 == null)
                {
                    return;
                }
                if (s2 != null)
                {
                    attributes.put(s1, s2);
                    return;
                } else
                {
                    attributes.remove(s1);
                    return;
                }
            }

            public void addMetric(String s1, Number number)
            {
                if (s1 == null)
                {
                    return;
                }
                if (number != null)
                {
                    metrics.put(s1, number);
                    return;
                } else
                {
                    metrics.remove(s1);
                    return;
                }
            }

            public Map getAllAttributes()
            {
                return Collections.unmodifiableMap(attributes);
            }

            public Map getAllMetrics()
            {
                return Collections.unmodifiableMap(metrics);
            }

            public String getAttribute(String s1)
            {
                if (s1 == null)
                {
                    return null;
                } else
                {
                    return (String)attributes.get(s1);
                }
            }

            public String getEventType()
            {
                return theEventName;
            }

            public boolean hasAttribute(String s1)
            {
                if (s1 == null)
                {
                    return false;
                } else
                {
                    return attributes.containsKey(s1);
                }
            }

            public boolean hasMetric(String s1)
            {
                if (s1 == null)
                {
                    return false;
                } else
                {
                    return metrics.containsKey(s1);
                }
            }

            public Event withAttribute(String s1, String s2)
            {
                addAttribute(s1, s2);
                return this;
            }

            public Event withMetric(String s1, Number number)
            {
                addMetric(s1, number);
                return this;
            }

            
            {
                this$1 = DisabledAmazonInsights._cls2.this;
                attributes = map;
                metrics = map1;
                theEventName = s;
                super();
            }
        };
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

    _cls1.val.theEventName()
    {
        this$0 = DisabledAmazonInsights.this;
        super();
    }
}

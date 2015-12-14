// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.impl;

import com.amazon.insights.ABTestClient;
import com.amazon.insights.AmazonInsights;
import com.amazon.insights.Event;
import com.amazon.insights.EventClient;
import com.amazon.insights.InsightsCallback;
import com.amazon.insights.InsightsHandler;
import com.amazon.insights.SessionClient;
import com.amazon.insights.UserProfile;
import com.amazon.insights.error.InsightsError;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DisabledAmazonInsights extends AmazonInsights
{

    public DisabledAmazonInsights()
    {
    }

    public ABTestClient getABTestClient()
    {
        return new ABTestClient() {

            final DisabledAmazonInsights this$0;

            public transient InsightsHandler getVariations(String as[])
            {
                return new InsightsHandler() {

                    final _cls1 this$1;

                    public void setCallback(InsightsCallback insightscallback)
                    {
                        insightscallback.onError(new InsightsError() {

                            final _cls1 this$2;

                            public String getMessage()
                            {
                                return "The Amazon Insights SDK was not initialized";
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                };
            }

            
            {
                this$0 = DisabledAmazonInsights.this;
                super();
            }
        };
    }

    public EventClient getEventClient()
    {
        return new EventClient() {

            final DisabledAmazonInsights this$0;

            public void addGlobalAttribute(String s, String s1)
            {
            }

            public Event createEvent(String s)
            {
                return s. new Event() {

                    final _cls2 this$1;
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
                            attributes.put(s, s1);
                            return;
                        } else
                        {
                            attributes.remove(s);
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
                            metrics.put(s, number);
                            return;
                        } else
                        {
                            metrics.remove(s);
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

                    public String getAttribute(String s)
                    {
                        if (s == null)
                        {
                            return null;
                        } else
                        {
                            return (String)attributes.get(s);
                        }
                    }

                    public String getEventType()
                    {
                        return theEventName;
                    }

                    public boolean hasAttribute(String s)
                    {
                        if (s == null)
                        {
                            return false;
                        } else
                        {
                            return attributes.containsKey(s);
                        }
                    }

                    public boolean hasMetric(String s)
                    {
                        if (s == null)
                        {
                            return false;
                        } else
                        {
                            return metrics.containsKey(s);
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

            
            {
                this$1 = final__pcls2;
                attributes = map;
                metrics = map1;
                theEventName = String.this;
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

            
            {
                this$0 = DisabledAmazonInsights.this;
                super();
            }
        };
    }

    public SessionClient getSessionClient()
    {
        return new SessionClient() {

            final DisabledAmazonInsights this$0;

            public void pauseSession()
            {
            }

            public void resumeSession()
            {
            }

            
            {
                this$0 = DisabledAmazonInsights.this;
                super();
            }
        };
    }

    public UserProfile getUserProfile()
    {
        return new UserProfile() {

            final DisabledAmazonInsights this$0;
            Map userProfile;

            public UserProfile addDimensionAsString(String s, String s1)
            {
                userProfile.put(s, s1);
                return this;
            }

            public Map getDimensions()
            {
                return userProfile;
            }

            
            {
                this$0 = DisabledAmazonInsights.this;
                super();
                userProfile = new ConcurrentHashMap();
            }
        };
    }
}

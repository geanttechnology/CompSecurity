// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.Map;
import java.util.Set;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEvent, AnalyticsEventCategory, AnalyticAttribute, EventManager

public interface AnalyticsController
{

    public abstract boolean addEvent(AnalyticsEvent analyticsevent);

    public abstract boolean addEvent(String s, AnalyticsEventCategory analyticseventcategory, String s1, Set set);

    public abstract boolean addEvent(String s, Set set);

    public abstract AnalyticAttribute getAttribute(String s);

    public abstract EventManager getEventManager();

    public abstract int getMaxEventBufferTime();

    public abstract int getMaxEventPoolSize();

    public abstract int getSessionAttributeCount();

    public abstract Set getSessionAttributes();

    public abstract int getSystemAttributeCount();

    public abstract Set getSystemAttributes();

    public abstract int getUserAttributeCount();

    public abstract Set getUserAttributes();

    public abstract boolean incrementAttribute(String s, float f);

    public abstract boolean incrementAttribute(String s, float f, boolean flag);

    public abstract boolean recordEvent(String s, Map map);

    public abstract boolean removeAllAttributes();

    public abstract boolean removeAttribute(String s);

    public abstract boolean setAttribute(String s, float f);

    public abstract boolean setAttribute(String s, float f, boolean flag);

    public abstract boolean setAttribute(String s, String s1);

    public abstract boolean setAttribute(String s, String s1, boolean flag);

    public abstract boolean setAttribute(String s, boolean flag);

    public abstract boolean setAttribute(String s, boolean flag, boolean flag1);

    public abstract void setMaxEventBufferTime(int i);

    public abstract void setMaxEventPoolSize(int i);
}

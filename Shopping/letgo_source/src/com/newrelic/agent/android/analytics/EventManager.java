// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import java.util.Collection;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsEvent

public interface EventManager
{

    public abstract boolean addEvent(AnalyticsEvent analyticsevent);

    public abstract void empty();

    public abstract int getEventsEjected();

    public abstract int getEventsRecorded();

    public abstract int getMaxEventBufferTime();

    public abstract int getMaxEventPoolSize();

    public abstract Collection getQueuedEvents();

    public abstract void initialize();

    public abstract boolean isMaxEventBufferTimeExceeded();

    public abstract boolean isMaxEventPoolSizeExceeded();

    public abstract boolean isTransmitRequired();

    public abstract void setMaxEventBufferTime(int i);

    public abstract void setMaxEventPoolSize(int i);

    public abstract void shutdown();

    public abstract int size();
}

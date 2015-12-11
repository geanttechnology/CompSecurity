// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            EventManager, AnalyticsEvent

public class EventManagerImpl
    implements EventManager
{

    public static int DEFAULT_MAX_EVENT_BUFFER_SIZE = 1000;
    public static int DEFAULT_MAX_EVENT_BUFFER_TIME = 600;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private List events;
    private AtomicInteger eventsEjected;
    private AtomicInteger eventsRecorded;
    private long firstEventTimestamp;
    private AtomicBoolean initialized;
    private int maxBufferTimeInSec;
    private int maxEventPoolSize;

    public EventManagerImpl()
    {
        this(DEFAULT_MAX_EVENT_BUFFER_SIZE, DEFAULT_MAX_EVENT_BUFFER_TIME);
    }

    public EventManagerImpl(int i, int j)
    {
        initialized = new AtomicBoolean(false);
        eventsRecorded = new AtomicInteger(0);
        eventsEjected = new AtomicInteger(0);
        events = Collections.synchronizedList(new ArrayList(i));
        maxBufferTimeInSec = j;
        maxEventPoolSize = i;
        firstEventTimestamp = 0L;
        eventsRecorded.set(0);
        eventsEjected.set(0);
    }

    public boolean addEvent(AnalyticsEvent analyticsevent)
    {
        int i = eventsRecorded.incrementAndGet();
        if (events.size() == 0)
        {
            log.verbose((new StringBuilder()).append("EventManagerImpl.addEvent - Queue is currently empty, setting first event timestamp to ").append(System.currentTimeMillis()).toString());
            firstEventTimestamp = System.currentTimeMillis();
        }
        if (events.size() >= maxEventPoolSize)
        {
            eventsEjected.incrementAndGet();
            i = (int)(Math.random() * (double)i);
            if (i >= maxEventPoolSize)
            {
                return true;
            }
            events.remove(i);
        }
        return events.add(analyticsevent);
    }

    public void empty()
    {
        events.clear();
        firstEventTimestamp = 0L;
    }

    public int getEventsEjected()
    {
        return eventsEjected.get();
    }

    public int getEventsRecorded()
    {
        return eventsRecorded.get();
    }

    public int getMaxEventBufferTime()
    {
        return maxBufferTimeInSec;
    }

    public int getMaxEventPoolSize()
    {
        return maxEventPoolSize;
    }

    public Collection getQueuedEvents()
    {
        return Collections.unmodifiableCollection(events);
    }

    public void initialize()
    {
        if (!initialized.compareAndSet(false, true))
        {
            log.verbose("EventManagerImpl has already been initialized.  Bypassing...");
            return;
        } else
        {
            firstEventTimestamp = 0L;
            eventsRecorded.set(0);
            eventsEjected.set(0);
            empty();
            return;
        }
    }

    public boolean isMaxEventBufferTimeExceeded()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (firstEventTimestamp > 0L)
        {
            flag = flag1;
            if (System.currentTimeMillis() - firstEventTimestamp > (long)(maxBufferTimeInSec * 1000))
            {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isMaxEventPoolSizeExceeded()
    {
        return events.size() > maxEventPoolSize;
    }

    public boolean isTransmitRequired()
    {
        return !initialized.get() && events.size() > 0 || isMaxEventBufferTimeExceeded();
    }

    public void setMaxEventBufferTime(int i)
    {
        maxBufferTimeInSec = i;
    }

    public void setMaxEventPoolSize(int i)
    {
        maxEventPoolSize = i;
    }

    public void shutdown()
    {
        initialized.set(false);
    }

    public int size()
    {
        return events.size();
    }

}

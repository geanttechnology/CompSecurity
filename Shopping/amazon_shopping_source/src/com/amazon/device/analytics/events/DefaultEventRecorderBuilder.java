// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events;

import com.amazon.device.analytics.events.observers.EventObserver;
import com.amazon.device.analytics.util.JSONBuilder;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Referenced classes of package com.amazon.device.analytics.events:
//            DefaultEventRecorder, EventRecorder

public class DefaultEventRecorderBuilder
{

    private String applicationKey;
    private List observers;

    public DefaultEventRecorderBuilder()
    {
        observers = new CopyOnWriteArrayList();
    }

    public EventRecorder build()
    {
        return new DefaultEventRecorder(this);
    }

    protected String getApplicationKey()
    {
        return applicationKey;
    }

    protected List getObservers()
    {
        return observers;
    }

    public String toString()
    {
        return (new JSONBuilder(this)).toString();
    }

    public DefaultEventRecorderBuilder withApplicationKey(String s)
    {
        applicationKey = s;
        return this;
    }

    public DefaultEventRecorderBuilder withObserver(EventObserver eventobserver)
    {
        observers.add(eventobserver);
        return this;
    }
}

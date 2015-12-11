// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.model.Factory;
import com.shazam.n.l;

public class StartupEvent
{

    private final l applicationLaunchInterval;
    private final l displayedActivityLaunchInterval;
    private boolean sent;

    public StartupEvent(Factory factory)
    {
        applicationLaunchInterval = (l)factory.create(null);
        displayedActivityLaunchInterval = (l)factory.create(null);
    }

    public long getTotalAppStartupTime()
    {
        return applicationLaunchInterval.a() + displayedActivityLaunchInterval.a();
    }

    public boolean hasNotBeenSent()
    {
        return !sent;
    }

    public void markApplicationCreationEnded()
    {
        applicationLaunchInterval.b(0L);
    }

    public void markApplicationCreationStarted()
    {
        sent = false;
        applicationLaunchInterval.a(0L);
    }

    public void markDisplayedActivitiesCreationEnded()
    {
        sent = true;
        displayedActivityLaunchInterval.b(0L);
    }

    public void markDisplayedActivitiesCreationStarted()
    {
        if (!displayedActivityLaunchInterval.a)
        {
            displayedActivityLaunchInterval.a(0L);
        }
    }
}

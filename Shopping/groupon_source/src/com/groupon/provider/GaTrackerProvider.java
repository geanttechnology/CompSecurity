// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Application;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import javax.inject.Provider;

public class GaTrackerProvider
    implements Provider
{

    Application application;
    private volatile Tracker tracker;

    public GaTrackerProvider()
    {
    }

    public Tracker get()
    {
        if (tracker != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (tracker == null)
        {
            tracker = GoogleAnalytics.getInstance(application).newTracker("UA-63974607-2");
        }
        this;
        JVM INSTR monitorexit ;
_L2:
        return tracker;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object get()
    {
        return get();
    }
}

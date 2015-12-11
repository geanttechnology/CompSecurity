// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.provider;

import android.app.Application;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.groupon.ConsumerDeviceSettings;
import com.kochava.android.tracker.Feature;
import java.util.HashMap;
import java.util.Map;

public class KochavaProvider
    implements Provider
{

    private static final String BCOOKIE = "bcookie";
    Application application;
    Injector injector;
    private volatile Feature kochavaTracker;

    public KochavaProvider()
    {
    }

    public Feature get()
    {
        if (kochavaTracker == null)
        {
            initInstance();
        }
        return kochavaTracker;
    }

    public volatile Object get()
    {
        return get();
    }

    public void initInstance()
    {
        if (kochavaTracker != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        this;
        JVM INSTR monitorenter ;
        if (kochavaTracker == null)
        {
            kochavaTracker = new Feature(application, "kogroupon-android553bc3628a244");
            HashMap hashmap = new HashMap(1);
            hashmap.put("bcookie", ((ConsumerDeviceSettings)injector.getInstance(com/groupon/ConsumerDeviceSettings)).getBcookie());
            kochavaTracker.linkIdentity(hashmap);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

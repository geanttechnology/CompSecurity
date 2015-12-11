// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.commonsware.cwac.wakeful.WakefulIntentService;
import com.google.inject.Injector;
import com.groupon.events.activity.OnConfigurationChangedEvent;
import com.groupon.events.activity.OnCreateEvent;
import com.groupon.events.activity.OnDestroyEvent;
import com.groupon.events.activity.OnStartEvent;
import com.squareup.otto.Bus;
import roboguice.RoboGuice;

public abstract class GrouponRoboWakefulIntentService extends WakefulIntentService
{

    private Bus bus;

    public GrouponRoboWakefulIntentService(String s)
    {
        super(s);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        Configuration configuration1 = getResources().getConfiguration();
        super.onConfigurationChanged(configuration);
        bus.post(new OnConfigurationChangedEvent(this, configuration1, configuration));
    }

    public void onCreate()
    {
        RoboGuice.getInjector(this).injectMembers(this);
        super.onCreate();
        bus.post(new OnCreateEvent(this, null));
    }

    public void onDestroy()
    {
        if (bus != null)
        {
            bus.post(new OnDestroyEvent(this));
        }
        super.onDestroy();
        return;
        Exception exception;
        exception;
        super.onDestroy();
        throw exception;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        i = super.onStartCommand(intent, i, j);
        bus.post(new OnStartEvent(this));
        return i;
    }
}

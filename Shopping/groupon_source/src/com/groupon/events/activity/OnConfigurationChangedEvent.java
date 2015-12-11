// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.events.activity;

import android.content.Context;
import android.content.res.Configuration;

public class OnConfigurationChangedEvent
{

    protected final Context context;
    protected final Configuration newConfig;
    protected final Configuration oldConfig;

    public OnConfigurationChangedEvent(Context context1, Configuration configuration, Configuration configuration1)
    {
        oldConfig = configuration;
        newConfig = configuration1;
        context = context1;
    }

    public Context getContext()
    {
        return context;
    }

    public Configuration getNewConfig()
    {
        return newConfig;
    }

    public Configuration getOldConfig()
    {
        return oldConfig;
    }
}

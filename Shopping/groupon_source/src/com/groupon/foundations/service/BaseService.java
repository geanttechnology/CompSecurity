// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.foundations.service;

import android.app.Service;
import com.google.inject.Injector;
import roboguice.RoboGuice;

public abstract class BaseService extends Service
{

    protected Injector injector;

    public BaseService()
    {
    }

    public void onCreate()
    {
        super.onCreate();
        if (injector == null)
        {
            injector = RoboGuice.getInjector(this);
            injector.injectMembers(this);
        }
    }

    public void onDestroy()
    {
        RoboGuice.destroyInjector(this);
        super.onDestroy();
    }
}

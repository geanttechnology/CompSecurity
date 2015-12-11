// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.service;

import android.app.IntentService;
import android.content.Context;
import android.net.wifi.WifiManager;
import com.amazon.logging.Logger;

public abstract class WifiLockIntentService extends IntentService
{

    private static final Logger LOG = Logger.getLogger(com/amazon/android/service/WifiLockIntentService);
    private android.net.wifi.WifiManager.WifiLock networkLock;
    private final String serviceName;

    public WifiLockIntentService(String s)
    {
        super(s);
        serviceName = s;
    }

    public void onCreate()
    {
        super.onCreate();
        networkLock = ((WifiManager)getApplicationContext().getSystemService("wifi")).createWifiLock(serviceName);
        networkLock.acquire();
        LOG.v((new StringBuilder()).append("acquired network lock for '").append(serviceName).append("'").toString());
    }

    public void onDestroy()
    {
        if (networkLock.isHeld())
        {
            networkLock.release();
            LOG.v((new StringBuilder()).append("released network lock for '").append(serviceName).append("'").toString());
        }
    }

}

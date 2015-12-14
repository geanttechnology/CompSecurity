// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class NetworkConnectionReceiver extends BroadcastReceiver
{

    private int connectionStatus;

    public NetworkConnectionReceiver()
    {
        connectionStatus = -1;
    }

    public static IntentFilter getIntentFilter()
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        return intentfilter;
    }

    protected abstract void onNetworkConnected(boolean flag);

    protected abstract void onNetworkDisconnected();

    public void onReceive(Context context, Intent intent)
    {
        int i;
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        i = connectionStatus;
        if (context == null || !context.isConnected()) goto _L2; else goto _L1
_L1:
        if (context.getType() != 1) goto _L4; else goto _L3
_L3:
        connectionStatus = 1;
        if (i != connectionStatus)
        {
            onNetworkConnected(false);
        }
_L6:
        return;
_L4:
        if (context.getType() == 0)
        {
            connectionStatus = 0;
            if (i != connectionStatus)
            {
                onNetworkConnected(true);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        connectionStatus = 0;
        if (i != connectionStatus)
        {
            onNetworkDisconnected();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}

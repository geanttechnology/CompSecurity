// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cyberlink.beautycircle.Globals;

public class c
{

    public static void a(Context context, BroadcastReceiver broadcastreceiver)
    {
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(broadcastreceiver, intentfilter);
    }

    public static boolean a()
    {
        Object obj = (ConnectivityManager)Globals.n().getBaseContext().getSystemService("connectivity");
        if (obj != null)
        {
            obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
            if (obj != null)
            {
                return ((NetworkInfo) (obj)).isConnected();
            }
        }
        return false;
    }

    public static void b(Context context, BroadcastReceiver broadcastreceiver)
    {
        context.unregisterReceiver(broadcastreceiver);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class 
{

    public static void registerLocalReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        registerReceiver(broadcastreceiver, intentfilter, true);
    }

    public static void registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        registerReceiver(broadcastreceiver, intentfilter, false);
    }

    private static void registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, boolean flag)
    {
        Context context = CommonUtil.getApplicationContext();
        if (flag)
        {
            LocalBroadcastManager.getInstance(context).registerReceiver(broadcastreceiver, intentfilter);
            return;
        } else
        {
            context.registerReceiver(broadcastreceiver, intentfilter);
            return;
        }
    }

    public static void sendBroadcast(String s)
    {
        sendBroadcast(s, null, null);
    }

    public static void sendBroadcast(String s, Bundle bundle)
    {
        sendBroadcast(s, bundle, null);
    }

    public static void sendBroadcast(String s, Bundle bundle, String s1)
    {
        sendBroadcast(s, bundle, s1, false);
    }

    public static void sendBroadcast(String s, Bundle bundle, String s1, boolean flag)
    {
        Context context = CommonUtil.getApplicationContext();
        Intent intent = new Intent();
        intent.setAction(s);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        if (s1 != null)
        {
            intent.setType(s1);
        }
        if (flag)
        {
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            return;
        } else
        {
            context.sendBroadcast(intent);
            return;
        }
    }

    public static void sendLocalBroadcast(String s)
    {
        sendBroadcast(s, null, null, true);
    }

    public static void sendLocalBroadcast(String s, Bundle bundle)
    {
        sendBroadcast(s, bundle, null, true);
    }

    public static void unregisterLocalReceiver(BroadcastReceiver broadcastreceiver)
    {
        unregisterReceiver(broadcastreceiver, true);
    }

    public static void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        unregisterReceiver(broadcastreceiver, false);
    }

    private static void unregisterReceiver(BroadcastReceiver broadcastreceiver, boolean flag)
    {
        Context context = CommonUtil.getApplicationContext();
        if (flag)
        {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastreceiver);
            return;
        } else
        {
            context.unregisterReceiver(broadcastreceiver);
            return;
        }
    }
}

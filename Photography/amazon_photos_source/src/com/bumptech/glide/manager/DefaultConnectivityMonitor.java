// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.bumptech.glide.manager:
//            ConnectivityMonitor

class DefaultConnectivityMonitor
    implements ConnectivityMonitor
{

    private final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() {

        final DefaultConnectivityMonitor this$0;

        public void onReceive(Context context2, Intent intent)
        {
            boolean flag = isConnected;
            isConnected = isConnected(context2);
            if (flag != isConnected)
            {
                listener.onConnectivityChanged(isConnected);
            }
        }

            
            {
                this$0 = DefaultConnectivityMonitor.this;
                super();
            }
    };
    private final Context context;
    private boolean isConnected;
    private boolean isRegistered;
    private final ConnectivityMonitor.ConnectivityListener listener;

    public DefaultConnectivityMonitor(Context context1, ConnectivityMonitor.ConnectivityListener connectivitylistener)
    {
        context = context1.getApplicationContext();
        listener = connectivitylistener;
    }

    private boolean isConnected(Context context1)
    {
        context1 = ((ConnectivityManager)context1.getSystemService("connectivity")).getActiveNetworkInfo();
        return context1 != null && context1.isConnected();
    }

    private void register()
    {
        if (isRegistered)
        {
            return;
        } else
        {
            isConnected = isConnected(context);
            context.registerReceiver(connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            isRegistered = true;
            return;
        }
    }

    private void unregister()
    {
        if (!isRegistered)
        {
            return;
        } else
        {
            context.unregisterReceiver(connectivityReceiver);
            isRegistered = false;
            return;
        }
    }

    public void onDestroy()
    {
    }

    public void onStart()
    {
        register();
    }

    public void onStop()
    {
        unregister();
    }



/*
    static boolean access$002(DefaultConnectivityMonitor defaultconnectivitymonitor, boolean flag)
    {
        defaultconnectivitymonitor.isConnected = flag;
        return flag;
    }

*/


}

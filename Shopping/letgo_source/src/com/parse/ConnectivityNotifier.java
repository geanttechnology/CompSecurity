// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ReceiverCallNotAllowedException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.parse:
//            PLog

class ConnectivityNotifier extends BroadcastReceiver
{
    public static interface ConnectivityListener
    {

        public abstract void networkConnectivityStatusChanged(Context context, Intent intent);
    }


    private static final String TAG = "com.parse.ConnectivityNotifier";
    private static final ConnectivityNotifier singleton = new ConnectivityNotifier();
    private boolean hasRegisteredReceiver;
    private Set listeners;
    private final Object lock = new Object();

    ConnectivityNotifier()
    {
        listeners = new HashSet();
        hasRegisteredReceiver = false;
    }

    public static ConnectivityNotifier getNotifier(Context context)
    {
        singleton.tryToRegisterForNetworkStatusNotifications(context);
        return singleton;
    }

    public static boolean isConnected(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context == null)
        {
            return false;
        }
        context = context.getActiveNetworkInfo();
        boolean flag;
        if (context != null && context.isConnected())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private boolean tryToRegisterForNetworkStatusNotifications(Context context)
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (hasRegisteredReceiver)
        {
            return true;
        }
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        context.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        hasRegisteredReceiver = true;
        obj;
        JVM INSTR monitorexit ;
        return true;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
        context;
        PLog.v("com.parse.ConnectivityNotifier", "Cannot register a broadcast receiver because the executing thread is currently in a broadcast receiver. Will try again later.");
        obj;
        JVM INSTR monitorexit ;
        return false;
    }

    public void addListener(ConnectivityListener connectivitylistener)
    {
        synchronized (lock)
        {
            listeners.add(connectivitylistener);
        }
        return;
        connectivitylistener;
        obj;
        JVM INSTR monitorexit ;
        throw connectivitylistener;
    }

    public void onReceive(Context context, Intent intent)
    {
        ArrayList arraylist;
        synchronized (lock)
        {
            arraylist = new ArrayList(listeners);
        }
        for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); ((ConnectivityListener)((Iterator) (obj)).next()).networkConnectivityStatusChanged(context, intent)) { }
        break MISSING_BLOCK_LABEL_63;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void removeListener(ConnectivityListener connectivitylistener)
    {
        synchronized (lock)
        {
            listeners.remove(connectivitylistener);
        }
        return;
        connectivitylistener;
        obj;
        JVM INSTR monitorexit ;
        throw connectivitylistener;
    }

}

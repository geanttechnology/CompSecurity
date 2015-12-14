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
//            Parse

class ConnectivityNotifier extends BroadcastReceiver
{
    protected static interface ConnectivityListener
    {

        public abstract void networkConnectivityStatusChanged(Intent intent);
    }


    static final String TAG = "com.parse.ConnectivityNotifier";
    private static final ConnectivityNotifier singleton = new ConnectivityNotifier();
    private boolean hasRegisteredReceiver;
    private Set listeners;
    private final Object lock = new Object();

    ConnectivityNotifier()
    {
        listeners = new HashSet();
        hasRegisteredReceiver = false;
    }

    static ConnectivityNotifier getNotifier()
    {
        return singleton;
    }

    public void addListener(ConnectivityListener connectivitylistener, Context context)
    {
        synchronized (lock)
        {
            listeners.add(connectivitylistener);
            tryToRegisterForNetworkStatusNotifications();
        }
        return;
        connectivitylistener;
        context;
        JVM INSTR monitorexit ;
        throw connectivitylistener;
    }

    public boolean isConnected()
    {
        if (Parse.applicationContext == null)
        {
            Parse.logW("com.parse.ConnectivityNotifier", "Trying to check network connectivity without a known context. Has Parse.initialize been called from Application.onCreate? (Not Activity.onCreate)");
        } else
        {
            Object obj = (ConnectivityManager)Parse.applicationContext.getSystemService("connectivity");
            if (obj != null)
            {
                obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
                if (obj != null && !((NetworkInfo) (obj)).isConnected())
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void onReceive(Context context, Intent intent)
    {
        ArrayList arraylist;
        synchronized (lock)
        {
            arraylist = new ArrayList(listeners);
        }
        for (context = arraylist.iterator(); context.hasNext(); ((ConnectivityListener)context.next()).networkConnectivityStatusChanged(intent)) { }
        break MISSING_BLOCK_LABEL_60;
        intent;
        context;
        JVM INSTR monitorexit ;
        throw intent;
    }

    public void removeListener(ConnectivityListener connectivitylistener)
    {
        synchronized (lock)
        {
            listeners.remove(connectivitylistener);
            tryToRegisterForNetworkStatusNotifications();
        }
        return;
        connectivitylistener;
        obj;
        JVM INSTR monitorexit ;
        throw connectivitylistener;
    }

    public boolean tryToRegisterForNetworkStatusNotifications()
    {
label0:
        {
            synchronized (lock)
            {
                if (!hasRegisteredReceiver)
                {
                    break label0;
                }
            }
            return true;
        }
        Context context = Parse.applicationContext;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        obj;
        JVM INSTR monitorexit ;
        return false;
        Parse.applicationContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        hasRegisteredReceiver = true;
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        ReceiverCallNotAllowedException receivercallnotallowedexception;
        receivercallnotallowedexception;
        Parse.logV("com.parse.ConnectivityNotifier", "Cannot register a broadcast receiver because the executing thread is currently in a broadcast receiver. Will try again later.");
        obj;
        JVM INSTR monitorexit ;
        return false;
    }

}

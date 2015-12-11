// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.penthera.virtuososdk.utility.CommonUtil;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Vector;

public final class ConnectivityMonitor extends BroadcastReceiver
{
    public static interface IOnConnectivityChangeObserver
    {

        public abstract void onConnectivityChange(NetworkInfo networkinfo);
    }


    private static SoftReference iInstance = null;
    private Vector iObservers;

    private ConnectivityMonitor()
    {
        iObservers = null;
        iObservers = new Vector();
    }

    public static ConnectivityMonitor getInstance()
    {
        com/penthera/virtuososdk/monitor/ConnectivityMonitor;
        JVM INSTR monitorenter ;
        ConnectivityMonitor connectivitymonitor = null;
        if (iInstance != null)
        {
            connectivitymonitor = (ConnectivityMonitor)iInstance.get();
        }
        ConnectivityMonitor connectivitymonitor1;
        connectivitymonitor1 = connectivitymonitor;
        if (connectivitymonitor != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        connectivitymonitor1 = new ConnectivityMonitor();
        iInstance = new SoftReference(connectivitymonitor1);
        com/penthera/virtuososdk/monitor/ConnectivityMonitor;
        JVM INSTR monitorexit ;
        return connectivitymonitor1;
        Exception exception;
        exception;
        throw exception;
    }

    private void notifyObservers(NetworkInfo networkinfo)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = iObservers.iterator();
_L4:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        IOnConnectivityChangeObserver ionconnectivitychangeobserver = (IOnConnectivityChangeObserver)iterator.next();
        if (ionconnectivitychangeobserver == null) goto _L4; else goto _L3
_L3:
        ionconnectivitychangeobserver.onConnectivityChange(networkinfo);
          goto _L4
        networkinfo;
        this;
        JVM INSTR monitorexit ;
        throw networkinfo;
    }

    public void addObserver(IOnConnectivityChangeObserver ionconnectivitychangeobserver)
    {
        this;
        JVM INSTR monitorenter ;
        if (iObservers.size() == 0)
        {
            CommonUtil.getApplicationContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (ionconnectivitychangeobserver == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        if (!iObservers.contains(ionconnectivitychangeobserver))
        {
            iObservers.add(ionconnectivitychangeobserver);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        ionconnectivitychangeobserver;
        throw ionconnectivitychangeobserver;
    }

    protected void finalize()
        throws Throwable
    {
        iObservers.clear();
        super.finalize();
    }

    public void onReceive(Context context, Intent intent)
    {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
        {
            notifyObservers(((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo());
        }
    }

}

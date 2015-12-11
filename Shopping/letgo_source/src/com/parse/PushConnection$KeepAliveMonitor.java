// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.support.v7.ct;
import android.support.v7.cu;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.parse:
//            PushConnection, Parse, PLog, ParseWakeLock, 
//            ParseRESTCommand

private class interval
{

    private PendingIntent broadcast;
    private final long interval;
    private cu keepAliveTask;
    private AlarmManager manager;
    private BroadcastReceiver readReceiver;
    private final Socket socket;
    final PushConnection this$0;
    private boolean unregistered;
    private BroadcastReceiver writeReceiver;

    private void signalKeepAliveFailure()
    {
        this;
        JVM INSTR monitorenter ;
        if (!unregistered)
        {
            PushConnection.access$300(PushConnection.this).ent(ERROR);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void register()
    {
        final Context appContext = Parse.getApplicationContext();
        String s = appContext.getPackageName();
        final Intent readIntent = new Intent("com.parse.PushConnection.readKeepAlive");
        readIntent.setPackage(s);
        readIntent.addCategory(s);
        Intent intent = new Intent("com.parse.PushConnection.writeKeepAlive");
        intent.setPackage(s);
        intent.addCategory(s);
        manager = (AlarmManager)appContext.getSystemService("alarm");
        PendingIntent pendingintent = PendingIntent.getBroadcast(appContext, 0, readIntent, 0);
        long l;
        if (pendingintent != null)
        {
            manager.cancel(pendingintent);
            pendingintent.cancel();
        } else
        {
            PLog.e("com.parse.PushConnection", "oldReadBroadcast was null");
        }
        broadcast = PendingIntent.getBroadcast(appContext, 0, intent, 0);
        manager.cancel(broadcast);
        l = SystemClock.elapsedRealtime();
        manager.setInexactRepeating(2, l, interval, broadcast);
        readReceiver = new BroadcastReceiver() {

            final PushConnection.KeepAliveMonitor this$1;

            public void onReceive(Context context, Intent intent1)
            {
                long l1 = SystemClock.elapsedRealtime() - PushConnection.access$1100(this$0).get();
                if (l1 > PushConnection.KEEP_ALIVE_ACK_INTERVAL * 2L)
                {
                    PLog.v("com.parse.PushConnection", (new StringBuilder()).append("Keep alive failure: last read was ").append(l1).append(" ms ago.").toString());
                    signalKeepAliveFailure();
                }
            }

            
            {
                this$1 = PushConnection.KeepAliveMonitor.this;
                super();
            }
        };
        writeReceiver = new BroadcastReceiver() {

            final PushConnection.KeepAliveMonitor this$1;
            final Context val$appContext;
            final Intent val$readIntent;

            public void onReceive(Context context, Intent intent1)
            {
                context = ParseWakeLock.acquireNewWakeLock(PushConnection.access$1000(this$0), 1, "push-keep-alive", 20000L);
                if (keepAliveTask == null)
                {
                    keepAliveTask = cu.a(null).j();
                }
                keepAliveTask = keepAliveTask.a(context. new ct() {

                    final _cls2 this$2;
                    final ParseWakeLock val$wl;

                    public volatile Object then(cu cu)
                        throws Exception
                    {
                        return then(cu);
                    }

                    public Void then(cu cu)
                    {
                        boolean flag1 = false;
                        if (!PushConnection.access$700(socket, "{}"))
                        {
                            signalKeepAliveFailure();
                        }
                        boolean flag = flag1;
                        if (PushConnection.ENABLE_QUICK_ACK_CHECK)
                        {
                            try
                            {
                                Thread.sleep(2500L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (cu cu) { }
                            flag = flag1;
                            if (SystemClock.elapsedRealtime() - PushConnection.access$1100(this$0).get() <= 2500L * 2L)
                            {
                                flag = true;
                            }
                        }
                        if (!flag)
                        {
                            cu = PendingIntent.getBroadcast(appContext, System.identityHashCode(this), readIntent, 0x50000000);
                            manager.set(2, SystemClock.elapsedRealtime() + PushConnection.KEEP_ALIVE_ACK_INTERVAL, cu);
                        } else
                        {
                            PLog.v("com.parse.PushConnection", "Keep alive ack was received quickly.");
                        }
                        wl.release();
                        return null;
                    }

            
            {
                this$2 = final__pcls2;
                wl = ParseWakeLock.this;
                super();
            }
                }, ParseRESTCommand.NETWORK_EXECUTOR);
            }

            
            {
                this$1 = PushConnection.KeepAliveMonitor.this;
                appContext = context;
                readIntent = intent;
                super();
            }
        };
        readIntent = new IntentFilter("com.parse.PushConnection.readKeepAlive");
        readIntent.addCategory(s);
        appContext.registerReceiver(readReceiver, readIntent);
        readIntent = new IntentFilter("com.parse.PushConnection.writeKeepAlive");
        readIntent.addCategory(s);
        appContext.registerReceiver(writeReceiver, readIntent);
    }

    public void unregister()
    {
        Context context = Parse.getApplicationContext();
        context.unregisterReceiver(readReceiver);
        context.unregisterReceiver(writeReceiver);
        manager.cancel(broadcast);
        broadcast.cancel();
        this;
        JVM INSTR monitorenter ;
        unregistered = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }




/*
    static cu access$1302(_cls2._cls1 _pcls1, cu cu)
    {
        _pcls1.keepAliveTask = cu;
        return cu;
    }

*/



    public _cls2.val.readIntent(Socket socket1, long l)
    {
        this$0 = PushConnection.this;
        super();
        socket = socket1;
        interval = l;
    }
}

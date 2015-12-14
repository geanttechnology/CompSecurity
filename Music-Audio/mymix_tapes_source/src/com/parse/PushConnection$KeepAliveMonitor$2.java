// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.parse:
//            PushConnection, ParseWakeLock, ParseCommand, Parse

class val.readIntent extends BroadcastReceiver
{

    final _cls1.val.wl this$1;
    final Context val$appContext;
    final Intent val$readIntent;

    public void onReceive(final Context wl, Intent intent)
    {
        wl = ParseWakeLock.acquireNewWakeLock(PushConnection.access$1000(_fld0), 1, "push-keep-alive", 20000L);
        if (cess._mth1300(this._cls1.this) == null)
        {
            cess._mth1302(this._cls1.this, Task.forResult(null).makeVoid());
        }
        cess._mth1302(this._cls1.this, cess._mth1300(this._cls1.this).continueWith(new Continuation() {

            final PushConnection.KeepAliveMonitor._cls2 this$2;
            final ParseWakeLock val$wl;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
            {
                if (!PushConnection.access$700(PushConnection.KeepAliveMonitor.access$1400(this$1), "{}"))
                {
                    PushConnection.KeepAliveMonitor.access$1200(this$1);
                }
                boolean flag = false;
                if (PushConnection.ENABLE_QUICK_ACK_CHECK)
                {
                    try
                    {
                        Thread.sleep(2500L);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Task task) { }
                    if (SystemClock.elapsedRealtime() - PushConnection.access$1100(this$0).get() <= 2L * 2500L)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                }
                if (!flag)
                {
                    task = PendingIntent.getBroadcast(appContext, System.identityHashCode(this), readIntent, 0x50000000);
                    PushConnection.KeepAliveMonitor.access$1500(this$1).set(2, SystemClock.elapsedRealtime() + PushConnection.KEEP_ALIVE_ACK_INTERVAL, task);
                } else
                {
                    Parse.logV("com.parse.PushConnection", "Keep alive ack was received quickly.");
                }
                wl.release();
                return null;
            }

            
            {
                this$2 = PushConnection.KeepAliveMonitor._cls2.this;
                wl = parsewakelock;
                super();
            }
        }, ParseCommand.NETWORK_EXECUTOR));
    }

    _cls1.val.wl()
    {
        this$1 = final_wl;
        val$appContext = context;
        val$readIntent = Intent.this;
        super();
    }
}

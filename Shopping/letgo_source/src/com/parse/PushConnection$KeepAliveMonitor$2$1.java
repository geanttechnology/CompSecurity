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
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.parse:
//            PushConnection, ParseWakeLock, PLog, ParseRESTCommand

class val.wl
    implements ct
{

    final val.wl this$2;
    final ParseWakeLock val$wl;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
    {
        boolean flag1 = false;
        if (!PushConnection.access$700(ss._mth1400(_fld1), "{}"))
        {
            ss._mth1200(_fld1);
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
            if (SystemClock.elapsedRealtime() - PushConnection.access$1100(_fld0).get() <= 2500L * 2L)
            {
                flag = true;
            }
        }
        if (!flag)
        {
            cu = PendingIntent.getBroadcast(appContext, System.identityHashCode(this), readIntent, 0x50000000);
            ss._mth1500(_fld1).set(2, SystemClock.elapsedRealtime() + PushConnection.KEEP_ALIVE_ACK_INTERVAL, cu);
        } else
        {
            PLog.v("com.parse.PushConnection", "Keep alive ack was received quickly.");
        }
        val$wl.release();
        return null;
    }

    l.readIntent()
    {
        this$2 = final_readintent;
        val$wl = ParseWakeLock.this;
        super();
    }

    // Unreferenced inner class com/parse/PushConnection$KeepAliveMonitor$2

/* anonymous class */
    class PushConnection.KeepAliveMonitor._cls2 extends BroadcastReceiver
    {

        final PushConnection.KeepAliveMonitor this$1;
        final Context val$appContext;
        final Intent val$readIntent;

        public void onReceive(Context context, Intent intent)
        {
            context = ParseWakeLock.acquireNewWakeLock(PushConnection.access$1000(this$0), 1, "push-keep-alive", 20000L);
            if (PushConnection.KeepAliveMonitor.access$1300(PushConnection.KeepAliveMonitor.this) == null)
            {
                PushConnection.KeepAliveMonitor.access$1302(PushConnection.KeepAliveMonitor.this, cu.a(null).j());
            }
            PushConnection.KeepAliveMonitor.access$1302(PushConnection.KeepAliveMonitor.this, PushConnection.KeepAliveMonitor.access$1300(PushConnection.KeepAliveMonitor.this).a(context. new PushConnection.KeepAliveMonitor._cls2._cls1(), ParseRESTCommand.NETWORK_EXECUTOR));
        }

            
            {
                this$1 = final_keepalivemonitor;
                appContext = context;
                readIntent = Intent.this;
                super();
            }
    }

}

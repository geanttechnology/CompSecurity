// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sessionm.core.f;
import com.sessionm.net.RequestQueue;

// Referenced classes of package com.sessionm.api:
//            ConnectionReceiver

class val.context
    implements Runnable
{

    final ConnectionReceiver this$0;
    final Context val$context;
    final f val$session;

    public void run()
    {
        f f1 = f.E();
        f1;
        JVM INSTR monitorenter ;
        RequestQueue requestqueue;
        NetworkInfo networkinfo;
        requestqueue = val$session.M();
        networkinfo = ((ConnectivityManager)val$context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo == null) goto _L2; else goto _L1
_L1:
        if (!networkinfo.isConnected()) goto _L2; else goto _L3
_L3:
        if (requestqueue.bp() == com.sessionm.net.ueueNetworkState.fR)
        {
            requestqueue.reconnect();
        }
_L5:
        f1;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (requestqueue.bo() == com.sessionm.net.ueueSendState.fU && requestqueue.bp() == com.sessionm.net.ueueNetworkState.fQ)
        {
            requestqueue.a(com.sessionm.net.ueueNetworkState.fR);
        }
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ueueSendState()
    {
        this$0 = final_connectionreceiver;
        val$session = f1;
        val$context = Context.this;
        super();
    }
}

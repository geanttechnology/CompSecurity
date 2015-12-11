// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.sessionm.core.f;
import com.sessionm.net.RequestQueue;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

public class ConnectionReceiver extends BroadcastReceiver
{

    private static final String TAG = "SessionM.Connection";

    public ConnectionReceiver()
    {
    }

    public void onReceive(final Context context, final Intent session)
    {
        if (Log.isLoggable("SessionM.Connection", 3))
        {
            Log.d("SessionM.Connection", String.format(Locale.US, "Received connection update. intent: %s receiver: %s", new Object[] {
                session, this
            }));
        }
        session = f.E();
        if (!session.getSessionState().isStarted())
        {
            return;
        } else
        {
            session.getExecutorService().execute(new Runnable() {

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
                    requestqueue = session.M();
                    networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (networkinfo == null) goto _L2; else goto _L1
_L1:
                    if (!networkinfo.isConnected()) goto _L2; else goto _L3
_L3:
                    if (requestqueue.bp() == com.sessionm.net.RequestQueue.RequestQueueNetworkState.fR)
                    {
                        requestqueue.reconnect();
                    }
_L5:
                    f1;
                    JVM INSTR monitorexit ;
                    return;
_L2:
                    if (requestqueue.bo() == com.sessionm.net.RequestQueue.RequestQueueSendState.fU && requestqueue.bp() == com.sessionm.net.RequestQueue.RequestQueueNetworkState.fQ)
                    {
                        requestqueue.a(com.sessionm.net.RequestQueue.RequestQueueNetworkState.fR);
                    }
                    if (true) goto _L5; else goto _L4
_L4:
                    Exception exception;
                    exception;
                    f1;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$0 = ConnectionReceiver.this;
                session = f1;
                context = context1;
                super();
            }
            });
            return;
        }
    }
}

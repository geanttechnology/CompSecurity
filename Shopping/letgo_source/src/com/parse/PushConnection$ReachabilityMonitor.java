// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.parse:
//            PushConnection, ConnectivityNotifier

private class <init>
{

    private stener listener;
    final PushConnection this$0;
    private boolean unregistered;

    public void register()
    {
        listener = new ConnectivityNotifier.ConnectivityListener() {

            final PushConnection.ReachabilityMonitor this$1;

            public void networkConnectivityStatusChanged(Context context, Intent intent)
            {
                synchronized (PushConnection.ReachabilityMonitor.this)
                {
                    if (!unregistered)
                    {
                        PushConnection.access$300(this$0).signalEvent(PushConnection.Event.CONNECTIVITY_CHANGED);
                    }
                }
                return;
                intent;
                context;
                JVM INSTR monitorexit ;
                throw intent;
            }

            
            {
                this$1 = PushConnection.ReachabilityMonitor.this;
                super();
            }
        };
        ConnectivityNotifier.getNotifier(PushConnection.access$1000(PushConnection.this)).addListener(listener);
    }

    public void unregister()
    {
        ConnectivityNotifier.getNotifier(PushConnection.access$1000(PushConnection.this)).removeListener(listener);
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


    private _cls1.this._cls1()
    {
        this$0 = PushConnection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}

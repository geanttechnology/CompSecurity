// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.ExecutorService;

// Referenced classes of package com.parse:
//            PushConnection, PLog

public abstract class this._cls0
    implements Runnable
{

    final PushConnection this$0;

    public boolean isTerminal()
    {
        return false;
    }

    public void run()
    {
        this._cls0 _lcls0 = runState();
        PushConnection.access$100(PushConnection.this, this, _lcls0);
        if (isTerminal())
        {
            PLog.i("com.parse.PushConnection", (new StringBuilder()).append(this).append(" finished and is the terminal state. Thread exiting.").toString());
            PushConnection.access$200(PushConnection.this).shutdown();
            return;
        }
        if (_lcls0 != null)
        {
            PLog.i("com.parse.PushConnection", (new StringBuilder()).append("PushConnection transitioning from ").append(this).append(" to ").append(_lcls0).toString());
            PushConnection.access$200(PushConnection.this).execute(_lcls0);
            return;
        } else
        {
            throw new NullPointerException((new StringBuilder()).append(this).append(" tried to transition to null state.").toString());
        }
    }

    public abstract g runState();

    public rvice()
    {
        this$0 = PushConnection.this;
        super();
    }
}

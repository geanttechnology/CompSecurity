// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.ExecutorService;

// Referenced classes of package com.parse:
//            PushConnection, Parse

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
        Object obj = runState();
        com/parse/PushConnection;
        JVM INSTR monitorenter ;
        if (PushConnection.access$100() != null)
        {
            PushConnection.access$100().onStateChange(PushConnection.this, this, ((this._cls0) (obj)));
        }
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        if (isTerminal())
        {
            Parse.logI("com.parse.PushConnection", (new StringBuilder()).append(this).append(" finished and is the terminal state. Thread exiting.").toString());
            PushConnection.access$200(PushConnection.this).shutdown();
            return;
        }
        break MISSING_BLOCK_LABEL_81;
        obj;
        com/parse/PushConnection;
        JVM INSTR monitorexit ;
        throw obj;
        if (obj != null)
        {
            Parse.logI("com.parse.PushConnection", (new StringBuilder()).append("PushConnection transitioning from ").append(this).append(" to ").append(obj).toString());
            PushConnection.access$200(PushConnection.this).execute(((Runnable) (obj)));
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

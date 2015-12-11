// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;


// Referenced classes of package com.sessionm.core:
//            f, h

class 
    implements Runnable
{

    final f cM;

    public void run()
    {
        synchronized (cM)
        {
            if (!cM.D().isOptedOut() && cM.getSessionState().isStarted())
            {
                f.a(cM, null);
            }
        }
        return;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    nM.State(f f1)
    {
        cM = f1;
        super();
    }
}

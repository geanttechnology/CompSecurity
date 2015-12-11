// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import java.util.ArrayList;

// Referenced classes of package com.jirbo.adcolony:
//            an, ak

class ao extends Thread
{

    Runnable a;

    ao()
    {
    }

    public void run()
    {
_L2:
        if (a != null)
        {
            try
            {
                a.run();
            }
            catch (RuntimeException runtimeexception)
            {
                ak.d("Exception caught in reusable thread.");
                ak.d((new StringBuilder()).append(runtimeexception).append("").toString());
                runtimeexception.printStackTrace();
            }
            a = null;
        }
        if (an.f)
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        synchronized (an.a)
        {
            an.b.add(this);
        }
        try
        {
            wait();
        }
        catch (InterruptedException interruptedexception) { }
        this;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

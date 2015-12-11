// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;


// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            au, ad

class a extends Thread
{

    final au a;

    public void run()
    {
_L3:
        try
        {
            if (au.a(a))
            {
                au.b(a);
            }
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        this;
        JVM INSTR monitorenter ;
        if (!au.c(a))
        {
            break MISSING_BLOCK_LABEL_45;
        }
        this;
        JVM INSTR monitorexit ;
        ad.d("Background thread exited");
        return;
        if (au.a(a)) goto _L2; else goto _L1
_L1:
        ad.d("Download manager stopped");
        wait();
_L5:
        this;
        JVM INSTR monitorexit ;
          goto _L3
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw exception1;
        }
        catch (InterruptedException interruptedexception)
        {
            ad.a(interruptedexception);
        }
          goto _L3
_L2:
        if (!au.d(a)) goto _L5; else goto _L4
_L4:
        ad.d("Download manager will be idle until next signal");
        if (!a.n)
        {
            a.l = true;
        }
        wait();
          goto _L5
    }

    (au au1)
    {
        a = au1;
        super();
    }
}

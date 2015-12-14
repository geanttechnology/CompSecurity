// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;


// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            aa, ab, y

class a
    implements Runnable
{

    final aa a;

    public void run()
    {
        ab ab1 = aa.a(a);
        ab1;
        JVM INSTR monitorenter ;
        aa.a(a, true);
_L1:
        if (!aa.b(a))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        synchronized (aa.c(a))
        {
            ab ab2 = aa.c(a);
            aa.a(a, aa.a(a));
            aa.b(a, ab2);
            aa.b(a, false);
        }
        a.a.a(aa.a(a).c, aa.a(a).a, aa.a(a).b);
          goto _L1
        obj;
        ab1;
        JVM INSTR monitorexit ;
        throw obj;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        aa.a(a, false);
        ab1;
        JVM INSTR monitorexit ;
    }

    (aa aa1)
    {
        a = aa1;
        super();
    }
}

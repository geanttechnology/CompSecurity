// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            jy, ju, jw, jx

class jz
    implements Runnable
{

    final jy a;

    jz(jy jy1)
    {
        a = jy1;
        super();
    }

    public void run()
    {
        Object obj = ju.d(a.a);
        obj;
        JVM INSTR monitorenter ;
        synchronized (ju.e(a.a))
        {
            if (ju.f(a.a) != null && ju.g(a.a) != -1)
            {
                ju.f(a.a).findViewById(ju.g(a.a)).setVisibility(8);
            }
        }
        if (ju.h(a.a) != null)
        {
            ju.h(a.a).l();
        }
        ju.a(a.a, jx.d);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

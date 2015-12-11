// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;


// Referenced classes of package com.google.ads:
//            e, c, AdRequest

class nit>
    implements Runnable
{

    final c a;
    final AdRequest b;
    final e c;

    public void run()
    {
        e.a(c, a, b);
        synchronized (e.a(c))
        {
            e.a(c, null);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    quest(e e1, c c1, AdRequest adrequest)
    {
        c = e1;
        a = c1;
        b = adrequest;
        super();
    }
}

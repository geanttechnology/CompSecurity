// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.a.a.a.a;

import java.util.concurrent.Callable;

// Referenced classes of package com.nostra13.universalimageloader.a.a.a.a:
//            a

class a
    implements Callable
{

    final a a;

    public Void a()
    {
label0:
        {
            synchronized (a)
            {
                if (com.nostra13.universalimageloader.a.a.a.a.a.a(a) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        com.nostra13.universalimageloader.a.a.a.a.a.b(a);
        com.nostra13.universalimageloader.a.a.a.a.a.c(a);
        if (com.nostra13.universalimageloader.a.a.a.a.a.d(a))
        {
            com.nostra13.universalimageloader.a.a.a.a.a.e(a);
            com.nostra13.universalimageloader.a.a.a.a.a.a(a, 0);
        }
        a1;
        JVM INSTR monitorexit ;
        return null;
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
    {
        return a();
    }

    (a a1)
    {
        a = a1;
        super();
    }
}

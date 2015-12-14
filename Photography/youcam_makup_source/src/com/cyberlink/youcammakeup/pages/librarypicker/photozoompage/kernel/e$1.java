// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel;

import java.util.concurrent.Callable;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel:
//            e

class a
    implements Callable
{

    final e a;

    public Void a()
    {
label0:
        {
            synchronized (a)
            {
                if (e.a(a))
                {
                    break label0;
                }
            }
            return null;
        }
        e.b(a);
        if (e.c(a))
        {
            e.d(a);
            e.a(a, 0);
        }
        e1;
        JVM INSTR monitorexit ;
        return null;
        exception;
        e1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
    {
        return a();
    }

    (e e1)
    {
        a = e1;
        super();
    }
}

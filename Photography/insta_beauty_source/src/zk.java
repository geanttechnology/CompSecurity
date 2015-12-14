// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Callable;

class zk
    implements Callable
{

    final zj a;

    zk(zj zj1)
    {
        a = zj1;
        super();
    }

    public Void a()
    {
label0:
        {
            synchronized (a)
            {
                if (zj.a(a) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        zj.b(a);
        if (zj.c(a))
        {
            zj.d(a);
            zj.a(a, 0);
        }
        zj1;
        JVM INSTR monitorexit ;
        return null;
        exception;
        zj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
    {
        return a();
    }
}

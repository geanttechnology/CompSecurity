// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.Callable;

// Referenced classes of package android.support.v7:
//            ahw

class a
    implements Callable
{

    final ahw a;

    public Void a()
        throws Exception
    {
label0:
        {
            synchronized (a)
            {
                if (ahw.a(a) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        ahw.b(a);
        ahw.c(a);
        if (ahw.d(a))
        {
            ahw.e(a);
            ahw.a(a, 0);
        }
        ahw1;
        JVM INSTR monitorexit ;
        return null;
        exception;
        ahw1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call()
        throws Exception
    {
        return a();
    }

    able(ahw ahw1)
    {
        a = ahw1;
        super();
    }
}

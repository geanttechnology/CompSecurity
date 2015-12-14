// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.o;

import java.util.concurrent.Callable;

// Referenced classes of package myobfuscated.o:
//            a

final class nit>
    implements Callable
{

    private a a;

    private Void a()
    {
label0:
        {
            synchronized (a)
            {
                if (myobfuscated.o.a.a(a) != null)
                {
                    break label0;
                }
            }
            return null;
        }
        myobfuscated.o.a.b(a);
        if (myobfuscated.o.a.c(a))
        {
            myobfuscated.o.a.d(a);
            myobfuscated.o.a.e(a);
        }
        a1;
        JVM INSTR monitorexit ;
        return null;
        exception;
        a1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Object call()
    {
        return a();
    }

    t.Callable(a a1)
    {
        a = a1;
        super();
    }
}

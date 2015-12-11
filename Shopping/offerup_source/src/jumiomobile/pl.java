// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.performance.indicator.benchmarks.coremark.CoremarkC;

// Referenced classes of package jumiomobile:
//            pk, pi, ab, pj

class pl
    implements Runnable
{

    final pk a;

    pl(pk pk1)
    {
        a = pk1;
        super();
    }

    public void run()
    {
        synchronized (pk.a(a))
        {
            CoremarkC coremarkc = new CoremarkC();
            ab.a("BenchmarkService", (new StringBuilder("starting benchmark ")).append(coremarkc.c()).toString());
            coremarkc.a();
            pk.a(a, coremarkc.f());
            pk.b(a, pk.b(a));
            ab.a("BenchmarkService", String.format("Classified device as %s at %.2f %s (%s)", new Object[] {
                coremarkc.f().toString(), coremarkc.d(), coremarkc.e(), coremarkc.c()
            }));
            pk.a(a).notifyAll();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}

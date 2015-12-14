// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.recognitionresult.b;

public final class ax extends Thread
{

    private static b a = null;
    private static final Object b = new Object();
    private static int c;

    public static void a()
    {
        synchronized (b)
        {
            if (a == null)
            {
                a = new b(b);
            }
            c++;
        }
    }

    public static void a(Runnable runnable)
    {
        a(runnable, 0);
    }

    public static void a(Runnable runnable, int i)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        com.nuance.nmdp.speechkit.recognitionresult.b.c(null, "Job added while JobRunner not active");
_L2:
        return;
        a.a(new Runnable(runnable) {

            private Runnable a;

            public final void run()
            {
                try
                {
                    a.run();
                    return;
                }
                catch (Throwable throwable)
                {
                    com.nuance.nmdp.speechkit.recognitionresult.b.a(ax.c(), "Error running job", throwable);
                }
            }

            
            {
                a = runnable;
                super();
            }
        }, i);
        if (true) goto _L2; else goto _L1
_L1:
        runnable;
        throw runnable;
    }

    public static void b()
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        c--;
        if (c < 0)
        {
            com.nuance.nmdp.speechkit.recognitionresult.b.b(a, "JobRunner shutdown more often than initialized");
            c = 0;
        }
        if (c <= 0)
        {
            a(new Runnable(a) {

                private b a;

                public final void run()
                {
                    b b1 = a;
                    b.a();
                }

            
            {
                a = b1;
                super();
            }
            }, 0);
            a = null;
        }
_L2:
        return;
        com.nuance.nmdp.speechkit.recognitionresult.b.c(null, "JobRunner shutdown when not active");
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    static b c()
    {
        return a;
    }

}

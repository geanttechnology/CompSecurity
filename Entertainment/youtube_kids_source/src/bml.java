// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import java.util.concurrent.Executor;

public class bml
{

    private static volatile boolean a;
    private final Context b;
    private final Executor c;
    private final bck d;

    public bml(Context context, Executor executor, bck bck1)
    {
        b = (Context)b.a(context);
        c = (Executor)b.a(executor);
        d = (bck)b.a(bck1);
    }

    static boolean b()
    {
        return a;
    }

    public final void a()
    {
        if (a)
        {
            return;
        }
        bml;
        JVM INSTR monitorenter ;
        if (!a)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        bml;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        bml;
        JVM INSTR monitorexit ;
        throw obj;
        if (Looper.myLooper() == Looper.getMainLooper())
        {
            bmo.b("Blocking main thread on ProviderInstaller.");
        }
        d.a(b);
        a = true;
_L1:
        bml;
        JVM INSTR monitorexit ;
        return;
        obj;
        bmo.b("ProviderInstaller failed.", ((Throwable) (obj)));
        a = true;
          goto _L1
        obj;
        bmo.b("ProviderInstaller failed.", ((Throwable) (obj)));
        a = true;
          goto _L1
    }

    public final void a(Runnable runnable)
    {
        if (a)
        {
            if (runnable != null)
            {
                runnable.run();
            }
            return;
        } else
        {
            c.execute(new bmm(this, runnable));
            return;
        }
    }
}

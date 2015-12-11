// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

// Referenced classes of package android.support.v7:
//            co

private static class <init>
    implements Executor
{

    private ThreadLocal a;

    private int a()
    {
        Integer integer1 = (Integer)a.get();
        Integer integer = integer1;
        if (integer1 == null)
        {
            integer = Integer.valueOf(0);
        }
        int i = integer.intValue() + 1;
        a.set(Integer.valueOf(i));
        return i;
    }

    private int b()
    {
        Integer integer1 = (Integer)a.get();
        Integer integer = integer1;
        if (integer1 == null)
        {
            integer = Integer.valueOf(0);
        }
        int i = integer.intValue() - 1;
        if (i == 0)
        {
            a.remove();
            return i;
        } else
        {
            a.set(Integer.valueOf(i));
            return i;
        }
    }

    public void execute(Runnable runnable)
    {
        if (a() > 15) goto _L2; else goto _L1
_L1:
        runnable.run();
_L4:
        b();
        return;
_L2:
        co.a().execute(runnable);
        if (true) goto _L4; else goto _L3
_L3:
        runnable;
        b();
        throw runnable;
    }

    private cutorService()
    {
        a = new ThreadLocal();
    }

    nit>(nit> nit>)
    {
        this();
    }
}

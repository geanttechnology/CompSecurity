// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package android.support.v7:
//            cm

final class co
{
    private static class a
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

        private a()
        {
            a = new ThreadLocal();
        }

    }


    private static final co a = new co();
    private final ExecutorService b;
    private final ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
    private final Executor d = new a();

    private co()
    {
        ExecutorService executorservice;
        if (!c())
        {
            executorservice = Executors.newCachedThreadPool();
        } else
        {
            executorservice = cm.a();
        }
        b = executorservice;
    }

    public static ExecutorService a()
    {
        return a.b;
    }

    static Executor b()
    {
        return a.d;
    }

    private static boolean c()
    {
        String s = System.getProperty("java.runtime.name");
        if (s == null)
        {
            return false;
        } else
        {
            return s.toLowerCase(Locale.US).contains("android");
        }
    }

}

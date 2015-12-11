// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package a:
//            f, a

final class e
{

    private static final e a = new e();
    private final ExecutorService b;
    private final Executor c = new f((byte)0);

    private e()
    {
        Object obj = System.getProperty("java.runtime.name");
        boolean flag;
        if (obj == null)
        {
            flag = false;
        } else
        {
            flag = ((String) (obj)).toLowerCase(Locale.US).contains("android");
        }
        if (!flag)
        {
            obj = Executors.newCachedThreadPool();
        } else
        {
            obj = a.a.a();
        }
        b = ((ExecutorService) (obj));
        Executors.newSingleThreadScheduledExecutor();
    }

    public static ExecutorService a()
    {
        return a.b;
    }

    static Executor b()
    {
        return a.c;
    }

}

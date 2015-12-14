// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.a;

import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.configs.b;
import com.inmobi.commons.core.utilities.Logger;

// Referenced classes of package com.inmobi.commons.core.a:
//            a, b

public class c
    implements Thread.UncaughtExceptionHandler
{
    static class a
        implements com.inmobi.commons.core.configs.b.b
    {

        public void a(com.inmobi.commons.core.configs.a a1)
        {
            com.inmobi.commons.core.c.a.a().a(a1.a(), ((com.inmobi.commons.core.a.a)a1).e());
        }

        a()
        {
        }
    }


    private static final String b = com/inmobi/commons/core/a/c.getSimpleName();
    private static boolean c = false;
    private static a d;
    private Thread.UncaughtExceptionHandler a;

    private c(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        a = uncaughtexceptionhandler;
    }

    public static void a()
    {
        com/inmobi/commons/core/a/c;
        JVM INSTR monitorenter ;
        if (!c)
        {
            com.inmobi.commons.core.a.a a1 = new com.inmobi.commons.core.a.a();
            d = new a();
            com.inmobi.commons.core.configs.b.a().a(a1, d);
            com.inmobi.commons.core.c.a.a().a(a1.a(), a1.e());
            Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
            c = true;
        }
        com/inmobi/commons/core/a/c;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean a(Throwable throwable)
    {
        boolean flag1 = false;
        throwable = throwable.getStackTrace();
        int j = throwable.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!throwable[i].getClassName().contains("com.inmobi."))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (a(throwable))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Crash due to inmobi, will report it");
            com.inmobi.commons.core.a.b b1 = new com.inmobi.commons.core.a.b(thread, throwable);
            com.inmobi.commons.core.c.a.a().a(b1);
        }
        a.uncaughtException(thread, throwable);
    }

}

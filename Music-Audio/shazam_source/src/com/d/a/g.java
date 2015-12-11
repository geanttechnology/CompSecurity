// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import java.util.Map;

// Referenced classes of package com.d.a:
//            f, o

public final class g
    implements Thread.UncaughtExceptionHandler
{

    private Thread.UncaughtExceptionHandler a;

    g()
    {
        a = Thread.getDefaultUncaughtExceptionHandler();
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        f f1;
        f1 = f.b();
        throwable.printStackTrace();
        Object obj = "";
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        if (astacktraceelement == null) goto _L2; else goto _L1
_L1:
        if (astacktraceelement.length <= 0) goto _L2; else goto _L3
_L3:
        obj = astacktraceelement[0];
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(((StackTraceElement) (obj)).getClassName()).append(".").append(((StackTraceElement) (obj)).getMethodName()).append(":").append(((StackTraceElement) (obj)).getLineNumber());
        if (throwable.getMessage() != null)
        {
            stringbuilder.append((new StringBuilder(" (")).append(throwable.getMessage()).append(")").toString());
        }
        obj = stringbuilder.toString();
_L5:
        String s = throwable.getClass().toString();
        f.a.a("uncaught", ((String) (obj)), s);
_L6:
        Throwable throwable1;
        try
        {
            f1.b.clear();
            f1.a(null, true);
        }
        catch (Throwable throwable2)
        {
            o.a("FlurryAgent", "", throwable2);
        }
        if (a != null)
        {
            a.uncaughtException(thread, throwable);
        }
        return;
_L2:
        if (throwable.getMessage() == null) goto _L5; else goto _L4
_L4:
        obj = throwable.getMessage();
          goto _L5
        throwable1;
        o.a("FlurryAgent", "", throwable1);
          goto _L6
    }
}

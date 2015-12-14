// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.utils;

import com.amazon.dp.logger.DPLogger;

// Referenced classes of package com.dp.utils:
//            FailFastException

public final class FailFast
{

    private static final DPLogger log = new DPLogger();

    private static String buildFailFastMessage(String s, String s1, Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder("FailFast: ");
        stringbuilder.append("expected<");
        stringbuilder.append(s);
        stringbuilder.append("> actual<");
        stringbuilder.append(s1);
        stringbuilder.append("> ");
        if (aobj != null)
        {
            for (int i = 0; i < aobj.length; i++)
            {
                stringbuilder.append(aobj[i]);
            }

        }
        return stringbuilder.toString();
    }

    private static String buildFailFastMessage(Object aobj[])
    {
        StringBuilder stringbuilder = new StringBuilder("FailFast: ");
        if (aobj != null)
        {
            for (int i = 0; i < aobj.length; i++)
            {
                stringbuilder.append(aobj[i]);
            }

        }
        return stringbuilder.toString();
    }

    public static transient void expectEquals(int i, int j, Object aobj[])
    {
        failFastInternal(i, j, aobj);
    }

    public static void expectNotNull(Object obj)
    {
        boolean flag;
        if (obj != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        failFastInternal(flag, new Object[0]);
    }

    public static transient void expectTrue(boolean flag, Object aobj[])
    {
        failFastInternal(flag, aobj);
    }

    private static transient void failFastInternal(int i, int j, Object aobj[])
    {
        if (i != j)
        {
            logFailFastMessage(buildFailFastMessage(String.valueOf(i), String.valueOf(j), aobj));
            logStackTrace();
            throw new FailFastException();
        } else
        {
            return;
        }
    }

    private static transient void failFastInternal(boolean flag, Object aobj[])
    {
        if (!flag)
        {
            logFailFastMessage(buildFailFastMessage(aobj));
            logStackTrace();
            throw new FailFastException();
        } else
        {
            return;
        }
    }

    private static void logFailFastMessage(String s)
    {
        log.error("", s, new Object[0]);
    }

    private static void logStackTrace()
    {
        StackTraceElement astacktraceelement[] = (new Throwable()).getStackTrace();
        for (int i = 0; i < astacktraceelement.length; i++)
        {
            StringBuilder stringbuilder = new StringBuilder("\t> ");
            stringbuilder.append(astacktraceelement[i].toString());
            log.error("", stringbuilder.toString(), new Object[0]);
        }

    }

}

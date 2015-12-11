// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;

import android.text.TextUtils;

public final class Log
{

    private static final String TAG = "InvestLarge";

    public Log()
    {
    }

    public static void d(String s)
    {
        android.util.Log.d("InvestLarge", (new StringBuilder(String.valueOf(getLocation()))).append(s).toString());
    }

    public static void e(String s)
    {
        android.util.Log.e("InvestLarge", (new StringBuilder(String.valueOf(getLocation()))).append(s).toString());
    }

    public static void e(String s, Throwable throwable)
    {
        android.util.Log.e("InvestLarge", (new StringBuilder(String.valueOf(getLocation()))).append(s).toString(), throwable);
    }

    private static String getClassName(Class class1)
    {
        if (class1 != null)
        {
            if (!TextUtils.isEmpty(class1.getSimpleName()))
            {
                return class1.getSimpleName();
            } else
            {
                return getClassName(class1.getEnclosingClass());
            }
        } else
        {
            return "";
        }
    }

    private static String getLocation()
    {
        String s;
        StackTraceElement astacktraceelement[];
        int i;
        boolean flag;
        s = com/samsung/rest/Log.getName();
        astacktraceelement = Thread.currentThread().getStackTrace();
        flag = false;
        i = 0;
_L2:
        StackTraceElement stacktraceelement;
        boolean flag1;
        if (i >= astacktraceelement.length)
        {
            return "[]: ";
        }
        stacktraceelement = astacktraceelement[i];
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        flag1 = flag;
        if (!stacktraceelement.getClassName().startsWith(s))
        {
            Class class1 = Class.forName(stacktraceelement.getClassName());
            return (new StringBuilder("[")).append(getClassName(class1)).append(":").append(stacktraceelement.getMethodName()).append(":").append(stacktraceelement.getLineNumber()).append("]: ").toString();
        }
        break MISSING_BLOCK_LABEL_133;
        boolean flag2 = stacktraceelement.getClassName().startsWith(s);
        flag1 = flag;
        if (flag2)
        {
            flag1 = true;
        }
_L3:
        i++;
        flag = flag1;
        if (true) goto _L2; else goto _L1
_L1:
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        flag1 = flag;
          goto _L3
    }

    public static void v(String s)
    {
        android.util.Log.v("InvestLarge", (new StringBuilder(String.valueOf(getLocation()))).append(s).toString());
    }
}

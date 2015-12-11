// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StackUtil
{

    static final String TAG = "StackUtil";

    public StackUtil()
    {
    }

    public static String deepStackTrace(Throwable throwable, int i)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        throwable = stringwriter.getBuffer();
        return throwable.substring(0, Math.min(throwable.length(), i));
    }

    public static String getBackTrace(StackTraceElement astacktraceelement[], int i, int j, String s)
    {
        StringBuilder stringbuilder;
        if (astacktraceelement == null)
        {
            return "";
        }
        stringbuilder = new StringBuilder();
        j = Math.min(j + i, astacktraceelement.length);
_L2:
        StackTraceElement stacktraceelement;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        stacktraceelement = astacktraceelement[i];
        stringbuilder.append((new StringBuilder()).append(stacktraceelement.toString()).append(s).toString());
        i++;
        if (true) goto _L2; else goto _L1
        astacktraceelement;
        Log.e("StackUtil", "Logic error: parsing stack trace.", astacktraceelement);
_L1:
        return stringbuilder.toString();
    }

    public static String getCurrentThreadBackTrace(int i, int j, String s)
    {
        return getBackTrace(Thread.currentThread().getStackTrace(), i, j, s);
    }
}

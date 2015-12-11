// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.util.Log;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.util.Collection;
import java.util.Iterator;

public final class MAPLog
{

    private static volatile String sMyUserTag = "";
    private static volatile String sPackageName = "Unknown";

    public static void accountNotRegisteredError(String s, String s1, Collection collection)
    {
        StringBuilder stringbuilder = new StringBuilder("Account not registered: ");
        if (s1 == null)
        {
            stringbuilder.append("null");
        } else
        {
            appendMaskedDirectedId(stringbuilder, s1);
        }
        if (collection != null)
        {
            stringbuilder.append(". Registered accounts are:");
            for (s1 = collection.iterator(); s1.hasNext(); appendMaskedDirectedId(stringbuilder, collection))
            {
                collection = (String)s1.next();
                stringbuilder.append(' ');
            }

        }
        e(s, stringbuilder.toString(), new IllegalArgumentException());
    }

    private static void appendMaskedDirectedId(StringBuilder stringbuilder, String s)
    {
        stringbuilder.append("***").append(s.substring(s.length() - Math.min(2, s.length())));
    }

    private static String createTag(String s)
    {
        return (new StringBuilder()).append(sPackageName).append('/').append(s).append(sMyUserTag).toString();
    }

    public static void e(String s, String s1)
    {
        Log.e(createTag(s), s1);
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        Log.e(createTag(s), s1, throwable);
    }

    public static transient void formattedError(String s, String s1, Object aobj[])
    {
        Log.e(createTag(s), String.format(s1, aobj));
    }

    public static transient void formattedInfo(String s, String s1, Object aobj[])
    {
        i(s, String.format(s1, aobj));
    }

    public static transient void formattedWarning(String s, String s1, Object aobj[])
    {
        w(s, String.format(s1, aobj));
    }

    public static void i(String s, String s1)
    {
        Log.i(createTag(s), s1);
    }

    public static void i(String s, String s1, Throwable throwable)
    {
        Log.i(createTag(s), s1, throwable);
    }

    public static void logAndReportError(String s, Tracer tracer, String s1, String s2)
    {
        e(s, s1);
        if (tracer != null)
        {
            tracer.incrementCounter(s2);
            return;
        } else
        {
            MetricsHelper.incrementCounter(s2, new String[0]);
            return;
        }
    }

    public static void logAndReportError(String s, Tracer tracer, String s1, String s2, Throwable throwable)
    {
        e(s, s1, throwable);
        if (tracer != null)
        {
            tracer.incrementCounter(s2);
            return;
        } else
        {
            MetricsHelper.incrementCounter(s2, new String[0]);
            return;
        }
    }

    public static void setPackageName(String s)
    {
        sPackageName = s;
    }

    public static void w(String s, String s1)
    {
        Log.w(createTag(s), s1);
    }

    public static void w(String s, String s1, Throwable throwable)
    {
        Log.w(createTag(s), s1, throwable);
    }

}

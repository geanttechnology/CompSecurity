// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.util.Log;
import java.util.Collection;
import java.util.Iterator;

public final class MAPLog
{

    private static volatile String sMyUserTag = "";
    private static volatile String sPackageName = "Unknown";

    private MAPLog()
    {
    }

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

    public static void d(String s, String s1)
    {
        writeToLogcat(3, s, s1, ((Throwable) (null)));
    }

    public static void d(String s, String s1, Throwable throwable)
    {
        writeToLogcat(3, s, s1, throwable);
    }

    public static transient void d(String s, String s1, Object aobj[])
    {
        writeToLogcat(3, s, s1, aobj);
    }

    public static void e(String s, String s1)
    {
        writeToLogcat(6, s, s1, ((Throwable) (null)));
    }

    public static void e(String s, String s1, Throwable throwable)
    {
        writeToLogcat(6, s, s1, throwable);
    }

    public static transient void e(String s, String s1, Object aobj[])
    {
        writeToLogcat(6, s, s1, aobj);
    }

    public static void i(String s, String s1)
    {
        writeToLogcat(4, s, s1, ((Throwable) (null)));
    }

    public static void i(String s, String s1, Throwable throwable)
    {
        writeToLogcat(4, s, s1, throwable);
    }

    public static transient void i(String s, String s1, Object aobj[])
    {
        writeToLogcat(4, s, s1, aobj);
    }

    public static void pii(String s, String s1)
    {
        writeToLogcat(3, s, s1, ((Throwable) (null)));
    }

    public static void pii(String s, String s1, Throwable throwable)
    {
        writeToLogcat(3, s, s1, throwable);
    }

    public static transient void pii(String s, String s1, Object aobj[])
    {
        writeToLogcat(3, s, s1, aobj);
    }

    public static void setPackageName(String s)
    {
        sPackageName = s;
    }

    public static void setUserId(int j)
    {
        sMyUserTag = (new StringBuilder("[")).append(j).append("]").toString();
    }

    public static void verboseError(String s, String s1)
    {
        e(s, s1);
    }

    public static void w(String s, String s1)
    {
        writeToLogcat(5, s, s1, ((Throwable) (null)));
    }

    public static void w(String s, String s1, Throwable throwable)
    {
        writeToLogcat(5, s, s1, throwable);
    }

    public static transient void w(String s, String s1, Object aobj[])
    {
        writeToLogcat(5, s, s1, aobj);
    }

    private static void writeToLogcat(int j, String s, String s1, Throwable throwable)
    {
        s = (new StringBuilder()).append(sPackageName).append('/').append(s).append(sMyUserTag).toString();
        Log.println(j, s, s1);
        if (throwable != null)
        {
            Log.println(j, s, Log.getStackTraceString(throwable));
        }
    }

    private static transient void writeToLogcat(int j, String s, String s1, Object aobj[])
    {
        writeToLogcat(j, s, String.format(s1, aobj), ((Throwable) (null)));
    }

}

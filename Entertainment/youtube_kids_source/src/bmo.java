// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bmo
{

    private static String a = "L";
    private static final int b = 19;
    private static final String c = bmo.getName();
    private static Pattern d = Pattern.compile("");
    private static boolean e;

    private bmo()
    {
    }

    public static void a()
    {
        a(5, "", null);
    }

    private static void a(int i, String s, Throwable throwable)
    {
        StackTraceElement astacktraceelement[];
        int j;
        int k;
        astacktraceelement = Thread.currentThread().getStackTrace();
        k = astacktraceelement.length;
        j = 0;
_L15:
        if (j >= k) goto _L2; else goto _L1
_L1:
        Object obj;
        String s2;
        obj = astacktraceelement[j];
        s2 = ((StackTraceElement) (obj)).getClassName();
        if (s2.equals(c) || !s2.startsWith("com.google.android.")) goto _L4; else goto _L3
_L3:
        String s1 = String.valueOf(s2.substring(b));
        s2 = String.valueOf(((StackTraceElement) (obj)).getMethodName());
        j = ((StackTraceElement) (obj)).getLineNumber();
        obj = (new StringBuilder(String.valueOf(s1).length() + 13 + String.valueOf(s2).length())).append(s1).append(".").append(s2).append(":").append(j).toString();
_L12:
        s = (new StringBuilder(String.valueOf(obj).length() + 1 + String.valueOf(s).length())).append(((String) (obj))).append(" ").append(s).toString();
        bmp.a[i - 1];
        JVM INSTR tableswitch 1 5: default 224
    //                   1 255
    //                   2 265
    //                   3 275
    //                   4 280
    //                   5 285;
           goto _L5 _L6 _L7 _L8 _L9 _L10
_L5:
        if (!e)
        {
            throw new AssertionError("Unknown type.");
        }
          goto _L11
_L4:
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        obj = "(unknown)";
          goto _L12
_L6:
        Log.e(a, s, throwable);
_L11:
        return;
_L7:
        Log.w(a, s, throwable);
        return;
_L8:
        s = a;
        return;
_L9:
        s = a;
        return;
_L10:
        if (obj != null && d.matcher(((CharSequence) (obj))).matches())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0) goto _L11; else goto _L13
_L13:
        s = a;
        return;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public static void a(String s)
    {
        a = s;
    }

    public static void a(String s, Throwable throwable)
    {
        a(1, s, throwable);
    }

    public static void b(String s)
    {
        a(1, s, null);
    }

    public static void b(String s, Throwable throwable)
    {
        a(2, s, throwable);
    }

    public static void c(String s)
    {
        a(2, s, null);
    }

    public static void c(String s, Throwable throwable)
    {
        a(3, s, throwable);
    }

    public static void d(String s)
    {
        a(3, s, null);
    }

    public static void d(String s, Throwable throwable)
    {
        a(4, s, throwable);
    }

    public static void e(String s)
    {
        a(4, s, null);
    }

    public static void f(String s)
    {
        a(5, s, null);
    }

    static 
    {
        boolean flag;
        if (!bmo.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
    }
}

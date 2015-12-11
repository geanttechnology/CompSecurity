// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.util.Log;
import com.j.a.a.d;
import com.j.a.d.e;
import java.util.Date;

public class w
{

    private static final w a = new w();
    private static boolean b = false;

    private w()
    {
    }

    public static w a()
    {
        return a;
    }

    public static void a(String s)
    {
        a(s, ((Date) (null)));
    }

    public static void a(String s, Exception exception)
    {
label0:
        {
            if (b)
            {
                if (exception == null)
                {
                    break label0;
                }
                Log.w("Taplytics", (new StringBuilder()).append("WARNING: ").append(s).append(", error: ").append(exception.toString()).toString());
            }
            return;
        }
        Log.w("Taplytics", (new StringBuilder()).append("WARNING: ").append(s).toString());
    }

    public static void a(String s, String s1, Exception exception)
    {
        if (b)
        {
            if (exception != null)
            {
                Log.e("Taplytics", (new StringBuilder()).append("NETWORK ERROR: ").append(s1).append(", error: ").append(exception.toString()).toString());
            } else
            {
                Log.e("Taplytics", (new StringBuilder()).append("NETWORK ERROR: ").append(s1).toString());
            }
        }
        if (e.e().i())
        {
            e.e().n().a("tlRequestFailed", s, s1, exception);
            return;
        }
        if (exception != null)
        {
            c((new StringBuilder()).append("Network Error:").append(s1).append(", error: ").append(exception.toString()).toString());
            return;
        } else
        {
            c((new StringBuilder()).append("Network Error:").append(s1).toString());
            return;
        }
    }

    public static void a(String s, Date date)
    {
label0:
        {
            if (b)
            {
                if (date == null)
                {
                    break label0;
                }
                long l = (new Date()).getTime();
                long l1 = date.getTime();
                Log.d("Taplytics", d((new StringBuilder()).append(s).append(", time: ").append(l - l1).append("ms").toString()));
            }
            return;
        }
        Log.d("Taplytics", d(s));
    }

    public static String b()
    {
        return "Taplytics";
    }

    public static void b(String s)
    {
        a(s, ((Exception) (null)));
    }

    public static void b(String s, Exception exception)
    {
        if (b)
        {
            if (exception != null)
            {
                Log.e("Taplytics", (new StringBuilder()).append("ERROR: ").append(s).append(", error: ").append(exception.toString()).toString());
            } else
            {
                Log.e("Taplytics", (new StringBuilder()).append("ERROR: ").append(s).toString());
            }
        }
        e.e().n().a(s, exception);
    }

    public static void c(String s)
    {
        b(s, null);
    }

    public static void c(String s, Exception exception)
    {
label0:
        {
            if (b)
            {
                if (exception == null)
                {
                    break label0;
                }
                Log.e("Taplytics", (new StringBuilder()).append("SUPER ERROR: ").append(s).append(", error: ").append(exception.toString()).toString());
            }
            return;
        }
        Log.e("Taplytics", (new StringBuilder()).append("SUPER ERROR: ").append(s).toString());
    }

    private static String d(String s)
    {
        Object obj = Thread.currentThread();
        if (((Thread) (obj)).getName() != null)
        {
            obj = ((Thread) (obj)).getName();
        } else
        {
            obj = (new StringBuilder()).append(((Thread) (obj)).getId()).append("").toString();
        }
        return (new StringBuilder()).append(((String) (obj))).append(": ").append(s).toString();
    }

    public void a(boolean flag)
    {
        b = flag;
    }

}

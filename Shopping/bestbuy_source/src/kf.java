// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;

public class kf
{

    public static void a(String s, Exception exception)
    {
        if (na.a && exception != null && exception.getStackTrace() != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            if (exception.toString() != null)
            {
                e(s, exception.getLocalizedMessage());
            }
            if (exception.getCause() != null)
            {
                e(s, exception.getCause().getLocalizedMessage());
            }
            if (exception.getMessage() != null)
            {
                e(s, exception.getMessage());
            }
            int j = astacktraceelement.length;
            int i = 0;
            exception = stringbuilder;
            for (; i < j; i++)
            {
                StackTraceElement stacktraceelement = astacktraceelement[i];
                exception.append(stacktraceelement.getClassName()).append(" - ").append(stacktraceelement.getMethodName()).append(" - ").append(stacktraceelement.getLineNumber());
                e(s, exception.toString());
                exception = new StringBuilder();
            }

        } else
        {
            e(s, "Error - No Message");
        }
    }

    public static void a(String s, String s1)
    {
        if (na.a)
        {
            Log.v((new StringBuilder()).append("[BBYLog] ").append(s).toString(), (new StringBuilder()).append("").append(s1).toString());
        }
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        if (na.a)
        {
            Log.w((new StringBuilder()).append("[BBYLog] ").append(s).toString(), (new StringBuilder()).append("").append(s1).toString(), throwable);
        }
    }

    public static void b(String s, String s1)
    {
        if (na.a)
        {
            Log.d((new StringBuilder()).append("[BBYLog] ").append(s).toString(), (new StringBuilder()).append("").append(s1).toString());
        }
    }

    public static void c(String s, String s1)
    {
        if (na.a)
        {
            Log.i((new StringBuilder()).append("[BBYLog] ").append(s).toString(), (new StringBuilder()).append("").append(s1).toString());
        }
    }

    public static void d(String s, String s1)
    {
        if (na.a)
        {
            Log.w((new StringBuilder()).append("[BBYLog] ").append(s).toString(), (new StringBuilder()).append("").append(s1).toString());
        }
    }

    public static void e(String s, String s1)
    {
        if (na.a)
        {
            Log.d((new StringBuilder()).append("[BBYLog] ").append(s).toString(), (new StringBuilder()).append("").append(s1).toString());
        }
    }
}

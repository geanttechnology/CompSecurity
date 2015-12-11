// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edisonwang.android.slog;

import android.util.Log;
import co.vine.android.util.CrashUtil;
import java.util.Random;

// Referenced classes of package com.edisonwang.android.slog:
//            MessageFormatter, FormattingTuple

public class SLog
{

    private static final String TAG = "Playback_";
    private static String sAuthority;
    public static boolean sIsAmazon;
    public static boolean sLogsOn;
    private static Random sRandom = new Random();

    public SLog()
    {
    }

    public static void b(String s, Object obj)
    {
        b(s, obj, false);
    }

    public static void b(String s, Object obj, boolean flag)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            if (flag)
            {
                Log.e("Playback_[Benchmark]", s.getMessage());
            } else
            {
                Log.d("Playback_[Benchmark]", s.getMessage());
            }
            if (flag && sRandom.nextInt(100) < 10)
            {
                CrashUtil.logException(new IllegalMonitorStateException(s.getMessage()));
            }
        }
    }

    public static void b(String s, Object aobj[])
    {
        b(s, aobj, false);
    }

    public static void b(String s, Object aobj[], boolean flag)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            if (flag)
            {
                Log.e("Playback_[Benchmark]", s.getMessage());
            } else
            {
                Log.d("Playback_[Benchmark]", s.getMessage());
            }
            if (flag && sRandom.nextInt(100) < 10)
            {
                CrashUtil.logException(new IllegalMonitorStateException(s.getMessage()));
            }
        }
    }

    public static void d(String s)
    {
        if (sLogsOn)
        {
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString());
        }
    }

    public static void d(String s, Object obj)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void d(String s, Object obj, Object obj1)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1);
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void d(String s, Object obj, Object obj1, Object obj2)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1, obj2);
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void d(String s, Object obj, Object obj1, Throwable throwable)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1);
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString(), throwable);
        }
    }

    public static void d(String s, Object obj, Throwable throwable)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString(), throwable);
        }
    }

    public static void d(String s, Throwable throwable)
    {
        if (sLogsOn)
        {
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString(), throwable);
        }
    }

    public static void d(String s, Object aobj[])
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void d(String s, Object aobj[], Throwable throwable)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.d((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString(), throwable);
        }
    }

    public static void dWithTag(String s, String s1)
    {
        if (sLogsOn)
        {
            Log.d(s, (new StringBuilder()).append(getCallingClass()).append(":").append(getCallingLine()).append(s1).toString());
        }
    }

    public static void e(String s)
    {
        if (sLogsOn)
        {
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString());
        }
    }

    public static void e(String s, Object obj)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void e(String s, Object obj, Object obj1)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1);
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void e(String s, Object obj, Throwable throwable)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString(), throwable);
        }
    }

    public static void e(String s, Throwable throwable)
    {
        if (sLogsOn)
        {
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString(), throwable);
        }
    }

    public static void e(String s, Object aobj[])
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), s.getMessage());
        }
    }

    public static void e(String s, Object aobj[], Throwable throwable)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString(), throwable);
        }
    }

    public static void e2(String s, Exception exception)
    {
        if (sLogsOn)
        {
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass2()).toString(), (new StringBuilder()).append(getCallingLine2()).append(s).toString());
        }
    }

    public static void e2(String s, Throwable throwable)
    {
        if (sLogsOn)
        {
            Log.e((new StringBuilder()).append("Playback_").append(getCallingClass2()).toString(), (new StringBuilder()).append(getCallingLine2()).append(s).toString(), throwable);
        }
    }

    public static String getAuthority()
    {
        return sAuthority;
    }

    private static String getCallingClass()
    {
        String s1 = Thread.currentThread().getStackTrace()[4].getClassName();
        int j = s1.lastIndexOf('.');
        String s;
        if (j >= s1.length() - 1)
        {
            s = "";
        } else
        {
            s = s1;
            if (j >= 0)
            {
                return s1.substring(j + 1);
            }
        }
        return s;
    }

    private static String getCallingClass2()
    {
        String s1 = Thread.currentThread().getStackTrace()[5].getClassName();
        int j = s1.lastIndexOf('.');
        String s;
        if (j >= s1.length() - 1)
        {
            s = "";
        } else
        {
            s = s1;
            if (j >= 0)
            {
                return s1.substring(j + 1);
            }
        }
        return s;
    }

    private static String getCallingLine()
    {
        return (new StringBuilder()).append(Thread.currentThread().getStackTrace()[4].getMethodName()).append("()").append(":").append(Thread.currentThread().getStackTrace()[4].getLineNumber()).append(" - ").toString();
    }

    private static String getCallingLine2()
    {
        return (new StringBuilder()).append(Thread.currentThread().getStackTrace()[5].getMethodName()).append("()").append(":").append(Thread.currentThread().getStackTrace()[5].getLineNumber()).append(" - ").toString();
    }

    public static void i(String s)
    {
        if (sLogsOn)
        {
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString());
        }
    }

    public static void i(String s, Object obj)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void i(String s, Object obj, Object obj1)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1);
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void i(String s, Object obj, Object obj1, Object obj2)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1, obj2);
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void i(String s, Object obj, Throwable throwable)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString(), throwable);
        }
    }

    public static void i(String s, Throwable throwable)
    {
        if (sLogsOn)
        {
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString(), throwable);
        }
    }

    public static void i(String s, Object aobj[])
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void i2(String s)
    {
        if (sLogsOn)
        {
            Log.i((new StringBuilder()).append("Playback_").append(getCallingClass2()).toString(), (new StringBuilder()).append(getCallingLine2()).append(s).toString());
        }
    }

    public static void setup(boolean flag, boolean flag1, String s)
    {
        sLogsOn = flag;
        sIsAmazon = flag1;
        sAuthority = s;
        sRandom = new Random();
    }

    public static void v(String s)
    {
        if (sLogsOn)
        {
            Log.v((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString());
        }
    }

    public static void v(String s, Object obj)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.v((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void v(String s, Object obj, Object obj1)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1);
            Log.v((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void v(String s, Throwable throwable)
    {
        if (sLogsOn)
        {
            Log.v((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString(), throwable);
        }
    }

    public static void v(String s, Object aobj[])
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.v((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void w(String s)
    {
        if (sLogsOn)
        {
            Log.w((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString());
        }
    }

    public static void w(String s, Object obj)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj);
            Log.w((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void w(String s, Object obj, Object obj1)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, obj, obj1);
            Log.w((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void w(String s, Throwable throwable)
    {
        if (sLogsOn)
        {
            Log.w((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s).toString(), throwable);
        }
    }

    public static void w(String s, Object aobj[])
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.w((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString());
        }
    }

    public static void w(String s, Object aobj[], Throwable throwable)
    {
        if (sLogsOn)
        {
            s = MessageFormatter.format(s, aobj);
            Log.w((new StringBuilder()).append("Playback_").append(getCallingClass()).toString(), (new StringBuilder()).append(getCallingLine()).append(s.getMessage()).toString(), throwable);
        }
    }

}

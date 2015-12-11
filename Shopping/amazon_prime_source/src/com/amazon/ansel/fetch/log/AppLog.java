// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.log;

import android.util.Log;

public class AppLog
{

    private static int logLevel = 6;

    public AppLog()
    {
    }

    public static int d(String s, String s1)
    {
        if (doLog(s, 3))
        {
            return Log.d(s, s1);
        } else
        {
            return -1;
        }
    }

    public static int d(String s, String s1, Throwable throwable)
    {
        if (doLog(s, 3))
        {
            return Log.d(s, s1, throwable);
        } else
        {
            return -1;
        }
    }

    private static boolean doLog(String s, int j)
    {
        return isLoggable(s, j);
    }

    public static int e(String s, String s1)
    {
        if (doLog(s, 6))
        {
            return Log.w(s, s1);
        } else
        {
            return -1;
        }
    }

    public static int e(String s, String s1, Throwable throwable)
    {
        if (doLog(s, 6))
        {
            return Log.e(s, s1, throwable);
        } else
        {
            return -1;
        }
    }

    public static int getLogLevel()
    {
        return logLevel;
    }

    public static int i(String s, String s1)
    {
        if (doLog(s, 4))
        {
            return Log.i(s, s1);
        } else
        {
            return -1;
        }
    }

    public static int i(String s, String s1, Throwable throwable)
    {
        if (doLog(s, 4))
        {
            return Log.i(s, s1, throwable);
        } else
        {
            return -1;
        }
    }

    public static boolean isLoggable(String s, int j)
    {
        if (logLevel != -1)
        {
            return j >= logLevel;
        } else
        {
            return Log.isLoggable(s, j);
        }
    }

    public static void setLogLevel(int j)
    {
        logLevel = j;
    }

    public static int v(String s, String s1)
    {
        if (doLog(s, 2))
        {
            return Log.v(s, s1);
        } else
        {
            return -1;
        }
    }

    public static int v(String s, String s1, Throwable throwable)
    {
        if (doLog(s, 2))
        {
            return Log.v(s, s1, throwable);
        } else
        {
            return -1;
        }
    }

    public static int w(String s, String s1)
    {
        if (doLog(s, 5))
        {
            return Log.w(s, s1);
        } else
        {
            return -1;
        }
    }

    public static int w(String s, String s1, Throwable throwable)
    {
        if (doLog(s, 5))
        {
            return Log.w(s, s1, throwable);
        } else
        {
            return -1;
        }
    }

    public static int w(String s, Throwable throwable)
    {
        if (doLog(s, 5))
        {
            return Log.w(s, throwable);
        } else
        {
            return -1;
        }
    }

    public static int wtf(String s, String s1)
    {
        if (doLog(s, 7))
        {
            return Log.wtf(s, s1);
        } else
        {
            return -1;
        }
    }

    public static int wtf(String s, String s1, Throwable throwable)
    {
        if (doLog(s, 7))
        {
            return Log.wtf(s, s1, throwable);
        } else
        {
            return -1;
        }
    }

    public static int wtf(String s, Throwable throwable)
    {
        if (doLog(s, 7))
        {
            return Log.wtf(s, throwable);
        } else
        {
            return -1;
        }
    }

}

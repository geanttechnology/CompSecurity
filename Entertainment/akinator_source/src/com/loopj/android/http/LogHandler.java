// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;

// Referenced classes of package com.loopj.android.http:
//            LogInterface

public class LogHandler
    implements LogInterface
{

    boolean mLoggingEnabled;
    int mLoggingLevel;

    public LogHandler()
    {
        mLoggingEnabled = true;
        mLoggingLevel = 2;
    }

    private void checkedWtf(String s, String s1, Throwable throwable)
    {
        Log.wtf(s, s1, throwable);
    }

    public void d(String s, String s1)
    {
        log(2, s, s1);
    }

    public void d(String s, String s1, Throwable throwable)
    {
        logWithThrowable(3, s, s1, throwable);
    }

    public void e(String s, String s1)
    {
        log(6, s, s1);
    }

    public void e(String s, String s1, Throwable throwable)
    {
        logWithThrowable(6, s, s1, throwable);
    }

    public int getLoggingLevel()
    {
        return mLoggingLevel;
    }

    public void i(String s, String s1)
    {
        log(4, s, s1);
    }

    public void i(String s, String s1, Throwable throwable)
    {
        logWithThrowable(4, s, s1, throwable);
    }

    public boolean isLoggingEnabled()
    {
        return mLoggingEnabled;
    }

    public void log(int j, String s, String s1)
    {
        logWithThrowable(j, s, s1, null);
    }

    public void logWithThrowable(int j, String s, String s1, Throwable throwable)
    {
        if (!isLoggingEnabled() || !shouldLog(j)) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 2 8: default 60
    //                   2 61
    //                   3 88
    //                   4 129
    //                   5 70
    //                   6 79
    //                   7 60
    //                   8 97;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L2 _L8
_L2:
        return;
_L3:
        Log.v(s, s1, throwable);
        return;
_L6:
        Log.w(s, s1, throwable);
        return;
_L7:
        Log.e(s, s1, throwable);
        return;
_L4:
        Log.d(s, s1, throwable);
        return;
_L8:
        if (Integer.valueOf(android.os.Build.VERSION.SDK).intValue() > 8)
        {
            checkedWtf(s, s1, throwable);
            return;
        } else
        {
            Log.e(s, s1, throwable);
            return;
        }
_L5:
        Log.i(s, s1, throwable);
        return;
    }

    public void setLoggingEnabled(boolean flag)
    {
        mLoggingEnabled = flag;
    }

    public void setLoggingLevel(int j)
    {
        mLoggingLevel = j;
    }

    public boolean shouldLog(int j)
    {
        return j >= mLoggingLevel;
    }

    public void v(String s, String s1)
    {
        log(2, s, s1);
    }

    public void v(String s, String s1, Throwable throwable)
    {
        logWithThrowable(2, s, s1, throwable);
    }

    public void w(String s, String s1)
    {
        log(5, s, s1);
    }

    public void w(String s, String s1, Throwable throwable)
    {
        logWithThrowable(5, s, s1, throwable);
    }

    public void wtf(String s, String s1)
    {
        log(8, s, s1);
    }

    public void wtf(String s, String s1, Throwable throwable)
    {
        logWithThrowable(8, s, s1, throwable);
    }
}

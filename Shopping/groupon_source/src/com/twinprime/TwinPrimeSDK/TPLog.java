// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPLogMessage

final class TPLog extends Enum
{

    private static final TPLog $VALUES[];
    public static final TPLog LOG;
    public static final TPLog LOG1;
    public static final TPLog LOG10;
    public static final TPLog LOG11;
    public static final TPLog LOG12;
    public static final TPLog LOG13;
    public static final TPLog LOG2;
    public static final TPLog LOG3;
    public static final TPLog LOG4;
    public static final TPLog LOG5;
    public static final TPLog LOG6;
    public static final TPLog LOG7;
    public static final TPLog LOG8;
    public static final TPLog LOG9;
    static Context appContext = null;
    static Handler logHandler = null;
    static ArrayList overrideLogTags = new ArrayList();
    static int tpAppLogLevel = 2;
    static boolean tpDevelop = false;
    static int tpLogLevel = 0;
    static int tpPolicyLogLevel = 0;
    int logLevel;

    private TPLog(String s, int j, int k)
    {
        super(s, j);
        logLevel = k;
    }

    static void calcLogLevel()
    {
        tpLogLevel = Math.max(tpAppLogLevel, tpPolicyLogLevel);
    }

    static void initLogLevel(Context context)
    {
        appContext = context;
        tpPolicyLogLevel = appContext.getSharedPreferences("com.twinprime.sdk", 0).getInt("com.twinprime.log_level", 0);
        LOG10.i("TwinPrimeSDK", (new StringBuilder()).append("starting policy log level: ").append(tpPolicyLogLevel).toString());
        calcLogLevel();
    }

    static boolean isInTPDevelop()
    {
        return tpDevelop;
    }

    static boolean isNotInTPDevelop()
    {
        return !tpDevelop;
    }

    public static void setAppLogLevel(int j)
    {
        if (tpAppLogLevel != j)
        {
            tpAppLogLevel = j;
            LOG13.i("TwinPrimeSDK", (new StringBuilder()).append("set app log level: ").append(tpAppLogLevel).toString());
            calcLogLevel();
        }
    }

    static void setPolicyLogLevel(int j)
    {
        if (tpPolicyLogLevel != j)
        {
            SharedPreferences sharedpreferences = appContext.getSharedPreferences("com.twinprime.sdk", 0);
            tpPolicyLogLevel = j;
            sharedpreferences.edit().putInt("com.twinprime.log_level", j).commit();
            LOG10.i("TwinPrimeSDK", (new StringBuilder()).append("set policy log level: ").append(tpPolicyLogLevel).toString());
        }
        calcLogLevel();
    }

    public static TPLog valueOf(String s)
    {
        return (TPLog)Enum.valueOf(com/twinprime/TwinPrimeSDK/TPLog, s);
    }

    public static TPLog[] values()
    {
        return (TPLog[])$VALUES.clone();
    }

    void d(String s, String s1)
    {
        if (logToHandler(s1))
        {
            return;
        }
        if (logLevel <= 9)
        {
            s = "TwinPrimeSDK";
        }
        Log.d(s, s1);
    }

    void e(String s, String s1)
    {
        if (logToHandler(s1))
        {
            return;
        }
        if (logLevel <= 9)
        {
            s = "TwinPrimeSDK";
        }
        Log.e(s, s1);
    }

    void i(String s, String s1)
    {
        if (logToHandler(s1))
        {
            return;
        }
        if (logLevel <= 9)
        {
            s = "TwinPrimeSDK";
        }
        Log.i(s, s1);
    }

    boolean isLoggable()
    {
        return tpLogLevel >= logLevel;
    }

    boolean isLoggable(String s)
    {
        if (isLoggable())
        {
            return true;
        } else
        {
            return overrideLogTags.contains(s);
        }
    }

    boolean logToHandler(String s)
    {
        if (logHandler != null)
        {
            s = new TPLogMessage(logLevel, s);
            Message message = logHandler.obtainMessage();
            message.obj = s;
            logHandler.sendMessage(message);
        } else
        if (tpLogLevel != 0)
        {
            return false;
        }
        return true;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Level: ").append(logLevel).append(" AppLog: ").append(tpAppLogLevel).append(" Policy: ").append(tpPolicyLogLevel).toString();
    }

    void w(String s, String s1)
    {
        if (logToHandler(s1))
        {
            return;
        }
        if (logLevel <= 9)
        {
            s = "TwinPrimeSDK";
        }
        Log.w(s, s1);
    }

    static 
    {
        LOG = new TPLog("LOG", 0, 0);
        LOG1 = new TPLog("LOG1", 1, 1);
        LOG2 = new TPLog("LOG2", 2, 2);
        LOG3 = new TPLog("LOG3", 3, 3);
        LOG4 = new TPLog("LOG4", 4, 4);
        LOG5 = new TPLog("LOG5", 5, 5);
        LOG6 = new TPLog("LOG6", 6, 6);
        LOG7 = new TPLog("LOG7", 7, 7);
        LOG8 = new TPLog("LOG8", 8, 8);
        LOG9 = new TPLog("LOG9", 9, 9);
        LOG10 = new TPLog("LOG10", 10, 10);
        LOG11 = new TPLog("LOG11", 11, 11);
        LOG12 = new TPLog("LOG12", 12, 12);
        LOG13 = new TPLog("LOG13", 13, 13);
        $VALUES = (new TPLog[] {
            LOG, LOG1, LOG2, LOG3, LOG4, LOG5, LOG6, LOG7, LOG8, LOG9, 
            LOG10, LOG11, LOG12, LOG13
        });
    }
}

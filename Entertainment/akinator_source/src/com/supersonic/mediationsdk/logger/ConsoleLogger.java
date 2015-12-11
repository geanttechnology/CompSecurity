// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;

import android.util.Log;

// Referenced classes of package com.supersonic.mediationsdk.logger:
//            SupersonicLogger

public class ConsoleLogger extends SupersonicLogger
{

    public static final String NAME = "console";

    private ConsoleLogger()
    {
        super("console");
    }

    public ConsoleLogger(int i)
    {
        super("console", i);
    }

    public void log(SupersonicLogger.SupersonicTag supersonictag, String s, int i)
    {
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            Log.v((new StringBuilder()).append("").append(supersonictag).toString(), s);
            return;

        case 1: // '\001'
            Log.i((new StringBuilder()).append("").append(supersonictag).toString(), s);
            return;

        case 2: // '\002'
            Log.w((new StringBuilder()).append("").append(supersonictag).toString(), s);
            return;

        case 3: // '\003'
            Log.e((new StringBuilder()).append("").append(supersonictag).toString(), s);
            break;
        }
    }

    public void logException(SupersonicLogger.SupersonicTag supersonictag, String s, Throwable throwable)
    {
        log(supersonictag, (new StringBuilder()).append(s).append(":stacktrace[").append(Log.getStackTraceString(throwable)).append("]").toString(), 3);
    }
}

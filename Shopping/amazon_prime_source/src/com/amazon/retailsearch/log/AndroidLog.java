// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.log;

import android.util.Log;

// Referenced classes of package com.amazon.retailsearch.log:
//            AbstractMessageRecorder, MessageLogger, AppLog

public class AndroidLog extends AbstractMessageRecorder
{

    public AndroidLog(AppLog applog)
    {
        super(applog);
    }

    private void logMessage(MessageLogger messagelogger, int i, String s)
    {
        switch (i)
        {
        default:
            Log.v(messagelogger.getTag(), s);
            return;

        case 6: // '\006'
            Log.e(messagelogger.getTag(), s);
            return;

        case 5: // '\005'
            Log.w(messagelogger.getTag(), s);
            return;

        case 4: // '\004'
            Log.i(messagelogger.getTag(), s);
            return;

        case 3: // '\003'
            Log.d(messagelogger.getTag(), s);
            return;
        }
    }

    public void log(MessageLogger messagelogger, int i, String s, Throwable throwable)
    {
        if (!getAppLog().enabled(i))
        {
            return;
        }
        if (throwable == null)
        {
            logMessage(messagelogger, i, s);
            return;
        }
        switch (i)
        {
        default:
            Log.v(messagelogger.getTag(), s, throwable);
            return;

        case 6: // '\006'
            Log.e(messagelogger.getTag(), s, throwable);
            return;

        case 5: // '\005'
            Log.w(messagelogger.getTag(), s, throwable);
            return;

        case 4: // '\004'
            Log.i(messagelogger.getTag(), s, throwable);
            return;

        case 3: // '\003'
            Log.d(messagelogger.getTag(), s, throwable);
            return;
        }
    }
}

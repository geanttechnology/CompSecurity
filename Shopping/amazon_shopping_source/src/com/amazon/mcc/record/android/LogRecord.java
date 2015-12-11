// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record.android;

import com.amazon.mcc.record.Record;

// Referenced classes of package com.amazon.mcc.record.android:
//            AndroidLogLevel

public class LogRecord extends Record
{

    public LogRecord(AndroidLogLevel androidloglevel, String s, String s1)
    {
        super("Log", s1);
        setType("Log");
        setTag(s);
        setLogLevel(androidloglevel);
    }

    public LogRecord(AndroidLogLevel androidloglevel, String s, String s1, Throwable throwable)
    {
        this(androidloglevel, s, s1);
        setThrowable(throwable);
    }

    private void setLogLevel(AndroidLogLevel androidloglevel)
    {
        setProperty("LogLevel", androidloglevel);
    }

    private void setTag(String s)
    {
        setProperty("LogTag", s);
    }

    private void setThrowable(Throwable throwable)
    {
        setProperty("Throwable", throwable);
    }
}

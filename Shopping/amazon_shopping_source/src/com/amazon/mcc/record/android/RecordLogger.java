// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record.android;

import com.amazon.mcc.record.BasicRecorder;
import com.amazon.mcc.record.RecordableContext;

// Referenced classes of package com.amazon.mcc.record.android:
//            LogRecord, AndroidLogLevel

public class RecordLogger extends BasicRecorder
{

    public RecordLogger()
    {
    }

    public RecordLogger(RecordableContext recordablecontext)
    {
        super(recordablecontext);
    }

    public void e(String s, String s1)
    {
        record(new LogRecord(AndroidLogLevel.ERROR, s, s1));
    }

    public void e(String s, String s1, Throwable throwable)
    {
        record(new LogRecord(AndroidLogLevel.ERROR_THROWABLE, s, s1, throwable));
    }

    public void i(String s, String s1)
    {
        record(new LogRecord(AndroidLogLevel.INFO, s, s1));
    }

    public void v(String s, String s1)
    {
        record(new LogRecord(AndroidLogLevel.VERBOSE, s, s1));
    }
}

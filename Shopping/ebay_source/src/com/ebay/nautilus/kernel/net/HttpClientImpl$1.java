// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            HttpClientImpl

static final class  extends Handler
{

    public void close()
    {
    }

    public void flush()
    {
    }

    public void publish(LogRecord logrecord)
    {
        try
        {
            FwLog.println(HttpClientImpl.access$300().ority, (new StringBuilder()).append(HttpClientImpl.access$300().).append(':').append(logrecord.getLoggerName()).append('(').append(Thread.currentThread().getName()).append(')').toString(), logrecord.getMessage());
            return;
        }
        catch (Exception exception)
        {
            String s = exception.getMessage();
            logrecord = s;
            if (TextUtils.isEmpty(s))
            {
                logrecord = exception.getClass().getSimpleName();
            }
            HttpClientImpl.access$300().AsError(logrecord, exception);
            return;
        }
    }

    ()
    {
    }
}

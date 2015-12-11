// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.crashes;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.harvest.crash.Crash;
import com.newrelic.agent.android.logging.AgentLog;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

// Referenced classes of package com.newrelic.agent.android.crashes:
//            CrashReporter, CrashStore

private class crash
    implements Runnable
{

    private final Crash crash;
    final CrashReporter this$0;

    public void run()
    {
        Object obj;
        if (CrashReporter.access$200().useSsl())
        {
            obj = "https://";
        } else
        {
            obj = "http://";
        }
        obj = (HttpURLConnection)(new URL((new StringBuilder()).append(((String) (obj))).append(CrashReporter.access$200().getCrashCollectorHost()).append("/mobile_crash").toString())).openConnection();
        ((HttpURLConnection) (obj)).setDoOutput(true);
        ((HttpURLConnection) (obj)).setChunkedStreamingMode(0);
        ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/json");
        ((HttpURLConnection) (obj)).setConnectTimeout(5000);
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(((HttpURLConnection) (obj)).getOutputStream());
        bufferedoutputstream.write(crash.toJsonString().getBytes());
        bufferedoutputstream.close();
        if (((HttpURLConnection) (obj)).getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        CrashReporter.access$100(CrashReporter.this).info((new StringBuilder()).append("Crash ").append(crash.getUuid().toString()).append(" successfully submitted.").toString());
        CrashReporter.access$500(CrashReporter.this).delete(crash);
_L1:
        Exception exception1;
        try
        {
            ((HttpURLConnection) (obj)).disconnect();
            return;
        }
        catch (Exception exception)
        {
            CrashReporter.access$100(CrashReporter.this).error("Unable to report crash to New Relic, will try again later.", exception);
        }
        break MISSING_BLOCK_LABEL_251;
        CrashReporter.access$100(CrashReporter.this).error((new StringBuilder()).append("Something went wrong while submitting a crash (will try again later) - Response code ").append(((HttpURLConnection) (obj)).getResponseCode()).toString());
          goto _L1
        exception1;
        ((HttpURLConnection) (obj)).disconnect();
        throw exception1;
    }

    (Crash crash1)
    {
        this$0 = CrashReporter.this;
        super();
        crash = crash1;
    }
}

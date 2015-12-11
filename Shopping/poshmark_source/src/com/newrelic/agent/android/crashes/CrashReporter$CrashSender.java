// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.crashes;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.harvest.crash.Crash;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import java.io.BufferedOutputStream;
import java.io.IOException;
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

    private boolean requestWasSuccessful(HttpURLConnection httpurlconnection)
        throws IOException
    {
        switch (httpurlconnection.getResponseCode())
        {
        default:
            return false;

        case 200: 
            return true;
        }
    }

    public void run()
    {
        Object obj;
        TicToc tictoc;
        BufferedOutputStream bufferedoutputstream;
        if (CrashReporter.access$100().useSsl())
        {
            obj = "https://";
        } else
        {
            obj = "http://";
        }
        Exception exception1;
        try
        {
            obj = (HttpURLConnection)(new URL((new StringBuilder()).append(((String) (obj))).append(CrashReporter.access$100().getCrashCollectorHost()).append("/mobile_crash").toString())).openConnection();
            tictoc = new TicToc();
            tictoc.tic();
            ((HttpURLConnection) (obj)).setDoOutput(true);
            ((HttpURLConnection) (obj)).setChunkedStreamingMode(0);
            ((HttpURLConnection) (obj)).setRequestProperty("Content-Type", "application/json");
            ((HttpURLConnection) (obj)).setConnectTimeout(5000);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            recordFailedUpload((new StringBuilder()).append("Unable to report crash to New Relic, will try again later. ").append(((Exception) (obj)).getMessage()).toString());
            return;
        }
        bufferedoutputstream = new BufferedOutputStream(((HttpURLConnection) (obj)).getOutputStream());
        bufferedoutputstream.write(crash.toJsonString().getBytes());
        bufferedoutputstream.close();
        if (!requestWasSuccessful(((HttpURLConnection) (obj)))) goto _L2; else goto _L1
_L1:
        StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Crash/UploadTime", tictoc.toc());
        CrashReporter.access$000(CrashReporter.this).info((new StringBuilder()).append("Crash ").append(crash.getUuid().toString()).append(" successfully submitted.").toString());
        CrashReporter.access$200(CrashReporter.this).delete(crash);
_L3:
        ((HttpURLConnection) (obj)).disconnect();
_L4:
        CrashReporter.access$000(CrashReporter.this).debug((new StringBuilder()).append("Crash collection took ").append(tictoc.toc()).append("ms").toString());
        return;
_L2:
        recordFailedUpload((new StringBuilder()).append("Something went wrong while submitting a crash (will try again later) - Response code ").append(((HttpURLConnection) (obj)).getResponseCode()).toString());
          goto _L3
        exception1;
        recordFailedUpload((new StringBuilder()).append("Crash upload failed: ").append(exception1.getMessage()).toString());
        ((HttpURLConnection) (obj)).disconnect();
          goto _L4
        Exception exception;
        exception;
        ((HttpURLConnection) (obj)).disconnect();
        throw exception;
          goto _L3
    }

    (Crash crash1)
    {
        this$0 = CrashReporter.this;
        super();
        crash = crash1;
    }
}

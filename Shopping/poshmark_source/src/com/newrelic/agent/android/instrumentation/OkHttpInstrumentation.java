// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            HttpsURLConnectionExtension, HttpURLConnectionExtension

public class OkHttpInstrumentation
{

    private static final AgentLog log = AgentLogManager.getAgentLog();

    public OkHttpInstrumentation()
    {
    }

    public static HttpURLConnection open(HttpURLConnection httpurlconnection)
    {
        if (httpurlconnection instanceof HttpsURLConnection)
        {
            return new HttpsURLConnectionExtension((HttpsURLConnection)httpurlconnection);
        }
        if (httpurlconnection != null)
        {
            return new HttpURLConnectionExtension(httpurlconnection);
        } else
        {
            return null;
        }
    }

    public static HttpURLConnection openWithProxy(HttpURLConnection httpurlconnection)
    {
        if (httpurlconnection instanceof HttpsURLConnection)
        {
            return new HttpsURLConnectionExtension((HttpsURLConnection)httpurlconnection);
        }
        if (httpurlconnection != null)
        {
            return new HttpURLConnectionExtension(httpurlconnection);
        } else
        {
            return null;
        }
    }

    public static HttpURLConnection urlFactoryOpen(HttpURLConnection httpurlconnection)
    {
        log.debug("OkHttpInstrumentation - wrapping return of call to OkUrlFactory.open...");
        if (httpurlconnection instanceof HttpsURLConnection)
        {
            return new HttpsURLConnectionExtension((HttpsURLConnection)httpurlconnection);
        }
        if (httpurlconnection != null)
        {
            return new HttpURLConnectionExtension(httpurlconnection);
        } else
        {
            return null;
        }
    }

}

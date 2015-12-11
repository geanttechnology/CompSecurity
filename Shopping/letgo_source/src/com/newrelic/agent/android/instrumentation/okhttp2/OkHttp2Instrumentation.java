// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.newrelic.agent.android.instrumentation.okhttp2:
//            ResponseBuilderExtension, RequestBuilderExtension, CallExtension

public class OkHttp2Instrumentation
{

    private static final AgentLog log = AgentLogManager.getAgentLog();

    private OkHttp2Instrumentation()
    {
    }

    public static com.squareup.okhttp.Response.Builder body(com.squareup.okhttp.Response.Builder builder, ResponseBody responsebody)
    {
        return (new ResponseBuilderExtension(builder)).body(responsebody);
    }

    public static Request build(com.squareup.okhttp.Request.Builder builder)
    {
        return (new RequestBuilderExtension(builder)).build();
    }

    public static com.squareup.okhttp.Response.Builder newBuilder(com.squareup.okhttp.Response.Builder builder)
    {
        return new ResponseBuilderExtension(builder);
    }

    public static Call newCall(OkHttpClient okhttpclient, Request request)
    {
        return new CallExtension(okhttpclient, request, okhttpclient.newCall(request));
    }

    public static HttpURLConnection open(OkUrlFactory okurlfactory, URL url)
    {
        okurlfactory = okurlfactory.open(url);
        url = url.getProtocol();
        if (url.equals("http"))
        {
            return new HttpURLConnectionExtension(okurlfactory);
        }
        if (url.equals("https") && (okurlfactory instanceof HttpsURLConnection))
        {
            return new HttpsURLConnectionExtension((HttpsURLConnection)okurlfactory);
        } else
        {
            return new HttpURLConnectionExtension(okurlfactory);
        }
    }

}

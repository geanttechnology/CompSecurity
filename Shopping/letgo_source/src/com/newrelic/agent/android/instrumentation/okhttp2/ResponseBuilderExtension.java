// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import android.support.v7.apv;
import android.support.v7.apx;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;

// Referenced classes of package com.newrelic.agent.android.instrumentation.okhttp2:
//            PrebufferedResponseBody

public class ResponseBuilderExtension extends com.squareup.okhttp.Response.Builder
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private com.squareup.okhttp.Response.Builder impl;

    public ResponseBuilderExtension(com.squareup.okhttp.Response.Builder builder)
    {
        impl = builder;
    }

    public com.squareup.okhttp.Response.Builder addHeader(String s, String s1)
    {
        return impl.addHeader(s, s1);
    }

    public com.squareup.okhttp.Response.Builder body(ResponseBody responsebody)
    {
        apx apx1 = responsebody.source();
        apv apv1 = new apv();
        try
        {
            apx1.a(apv1);
        }
        catch (IOException ioexception)
        {
            log.error("IOException reading from source: ", ioexception);
        }
        return impl.body(new PrebufferedResponseBody(responsebody, apv1));
    }

    public Response build()
    {
        return impl.build();
    }

    public com.squareup.okhttp.Response.Builder cacheResponse(Response response)
    {
        return impl.cacheResponse(response);
    }

    public com.squareup.okhttp.Response.Builder code(int i)
    {
        return impl.code(i);
    }

    public com.squareup.okhttp.Response.Builder handshake(Handshake handshake1)
    {
        return impl.handshake(handshake1);
    }

    public com.squareup.okhttp.Response.Builder header(String s, String s1)
    {
        return impl.header(s, s1);
    }

    public com.squareup.okhttp.Response.Builder headers(Headers headers1)
    {
        return impl.headers(headers1);
    }

    public com.squareup.okhttp.Response.Builder message(String s)
    {
        return impl.message(s);
    }

    public com.squareup.okhttp.Response.Builder networkResponse(Response response)
    {
        return impl.networkResponse(response);
    }

    public com.squareup.okhttp.Response.Builder priorResponse(Response response)
    {
        return impl.priorResponse(response);
    }

    public com.squareup.okhttp.Response.Builder protocol(Protocol protocol1)
    {
        return impl.protocol(protocol1);
    }

    public com.squareup.okhttp.Response.Builder removeHeader(String s)
    {
        return impl.removeHeader(s);
    }

    public com.squareup.okhttp.Response.Builder request(Request request1)
    {
        return impl.request(request1);
    }

}

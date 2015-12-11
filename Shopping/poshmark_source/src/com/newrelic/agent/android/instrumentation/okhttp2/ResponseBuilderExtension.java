// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;

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
        if (responsebody == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        Object obj = responsebody.source();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        Buffer buffer = new Buffer();
        ((BufferedSource) (obj)).readAll(buffer);
        obj = impl.body(new PrebufferedResponseBody(responsebody, buffer));
        return ((com.squareup.okhttp.Response.Builder) (obj));
        Object obj1;
        obj1;
        log.error("IOException reading from source: ", ((Throwable) (obj1)));
_L2:
        return impl.body(responsebody);
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
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

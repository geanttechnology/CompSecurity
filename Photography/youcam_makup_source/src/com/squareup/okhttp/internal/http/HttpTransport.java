// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import java.net.Proxy;
import okio.q;
import okio.r;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Transport, HttpEngine, HttpConnection, OkHeaders, 
//            RequestLine, CacheRequest, RetryableSink

public final class HttpTransport
    implements Transport
{

    private final HttpConnection httpConnection;
    private final HttpEngine httpEngine;

    public HttpTransport(HttpEngine httpengine, HttpConnection httpconnection)
    {
        httpEngine = httpengine;
        httpConnection = httpconnection;
    }

    public boolean canReuseConnection()
    {
        while ("close".equalsIgnoreCase(httpEngine.getRequest().header("Connection")) || "close".equalsIgnoreCase(httpEngine.getResponse().header("Connection")) || httpConnection.isClosed()) 
        {
            return false;
        }
        return true;
    }

    public q createRequestBody(Request request, long l)
    {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding")))
        {
            return httpConnection.newChunkedSink();
        }
        if (l != -1L)
        {
            return httpConnection.newFixedLengthSink(l);
        } else
        {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public void disconnect(HttpEngine httpengine)
    {
        httpConnection.closeIfOwnedBy(httpengine);
    }

    public void emptyTransferStream()
    {
        httpConnection.emptyResponseBody();
    }

    public void flushRequest()
    {
        httpConnection.flush();
    }

    public r getTransferStream(CacheRequest cacherequest)
    {
        if (!httpEngine.hasResponseBody())
        {
            return httpConnection.newFixedLengthSource(cacherequest, 0L);
        }
        if ("chunked".equalsIgnoreCase(httpEngine.getResponse().header("Transfer-Encoding")))
        {
            return httpConnection.newChunkedSource(cacherequest, httpEngine);
        }
        long l = OkHeaders.contentLength(httpEngine.getResponse());
        if (l != -1L)
        {
            return httpConnection.newFixedLengthSource(cacherequest, l);
        } else
        {
            return httpConnection.newUnknownLengthSource(cacherequest);
        }
    }

    public com.squareup.okhttp.Response.Builder readResponseHeaders()
    {
        return httpConnection.readResponse();
    }

    public void releaseConnectionOnIdle()
    {
        if (canReuseConnection())
        {
            httpConnection.poolOnIdle();
            return;
        } else
        {
            httpConnection.closeOnIdle();
            return;
        }
    }

    public void writeRequestBody(RetryableSink retryablesink)
    {
        httpConnection.writeRequestBody(retryablesink);
    }

    public void writeRequestHeaders(Request request)
    {
        httpEngine.writingRequestHeaders();
        String s = RequestLine.get(request, httpEngine.getConnection().getRoute().getProxy().type(), httpEngine.getConnection().getProtocol());
        httpConnection.writeRequest(request.headers(), s);
    }
}

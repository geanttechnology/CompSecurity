// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client;

import com.comcast.cim.httpcomponentsandroid.HttpEntityEnclosingRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.client.HttpRequestRetryHandler;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;

public class DefaultHttpRequestRetryHandler
    implements HttpRequestRetryHandler
{

    private final boolean requestSentRetryEnabled;
    private final int retryCount;

    public DefaultHttpRequestRetryHandler()
    {
        this(3, false);
    }

    public DefaultHttpRequestRetryHandler(int i, boolean flag)
    {
        retryCount = i;
        requestSentRetryEnabled = flag;
    }

    private boolean handleAsIdempotent(HttpRequest httprequest)
    {
        return !(httprequest instanceof HttpEntityEnclosingRequest);
    }

    public int getRetryCount()
    {
        return retryCount;
    }

    public boolean isRequestSentRetryEnabled()
    {
        return requestSentRetryEnabled;
    }

    public boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
    {
        if (ioexception == null)
        {
            throw new IllegalArgumentException("Exception parameter may not be null");
        }
        if (httpcontext == null)
        {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        break MISSING_BLOCK_LABEL_28;
        if (i <= retryCount && !(ioexception instanceof InterruptedIOException) && !(ioexception instanceof UnknownHostException) && !(ioexception instanceof ConnectException) && !(ioexception instanceof SSLException))
        {
            if (handleAsIdempotent((HttpRequest)httpcontext.getAttribute("http.request")))
            {
                return true;
            }
            ioexception = (Boolean)httpcontext.getAttribute("http.request_sent");
            if (ioexception != null && ioexception.booleanValue())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i == 0 || requestSentRetryEnabled)
            {
                return true;
            }
        }
        return false;
    }
}

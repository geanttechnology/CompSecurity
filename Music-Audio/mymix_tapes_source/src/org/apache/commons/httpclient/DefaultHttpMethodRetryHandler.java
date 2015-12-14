// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpMethodRetryHandler, HttpMethodBase, NoHttpResponseException, HttpMethod

public class DefaultHttpMethodRetryHandler
    implements HttpMethodRetryHandler
{

    private static Class SSL_HANDSHAKE_EXCEPTION = null;
    private boolean requestSentRetryEnabled;
    private int retryCount;

    public DefaultHttpMethodRetryHandler()
    {
        this(3, false);
    }

    public DefaultHttpMethodRetryHandler(int i, boolean flag)
    {
        retryCount = i;
        requestSentRetryEnabled = flag;
    }

    public int getRetryCount()
    {
        return retryCount;
    }

    public boolean isRequestSentRetryEnabled()
    {
        return requestSentRetryEnabled;
    }

    public boolean retryMethod(HttpMethod httpmethod, IOException ioexception, int i)
    {
        if (httpmethod == null)
        {
            throw new IllegalArgumentException("HTTP method may not be null");
        }
        if (ioexception == null)
        {
            throw new IllegalArgumentException("Exception parameter may not be null");
        }
        if ((httpmethod instanceof HttpMethodBase) && ((HttpMethodBase)httpmethod).isAborted())
        {
            return false;
        }
        if (i > retryCount)
        {
            return false;
        }
        if (ioexception instanceof NoHttpResponseException)
        {
            return true;
        }
        if (ioexception instanceof InterruptedIOException)
        {
            return false;
        }
        if (ioexception instanceof UnknownHostException)
        {
            return false;
        }
        if (ioexception instanceof NoRouteToHostException)
        {
            return false;
        }
        if (SSL_HANDSHAKE_EXCEPTION != null && SSL_HANDSHAKE_EXCEPTION.isInstance(ioexception))
        {
            return false;
        }
        return !httpmethod.isRequestSent() || requestSentRetryEnabled;
    }

    static 
    {
        try
        {
            SSL_HANDSHAKE_EXCEPTION = Class.forName("javax.net.ssl.SSLHandshakeException");
        }
        catch (ClassNotFoundException classnotfoundexception) { }
    }
}

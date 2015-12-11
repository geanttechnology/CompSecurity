// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

public class DefaultServiceUnavailableRetryStrategy
    implements ServiceUnavailableRetryStrategy
{

    private final int maxRetries;
    private final long retryInterval;

    public DefaultServiceUnavailableRetryStrategy()
    {
        this(1, 1000);
    }

    public DefaultServiceUnavailableRetryStrategy(int i, int j)
    {
        Args.positive(i, "Max retries");
        Args.positive(j, "Retry interval");
        maxRetries = i;
        retryInterval = j;
    }

    public long getRetryInterval()
    {
        return retryInterval;
    }

    public boolean retryRequest(HttpResponse httpresponse, int i, HttpContext httpcontext)
    {
        return i <= maxRetries && httpresponse.getStatusLine().getStatusCode() == 503;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import java.net.ConnectException;
import java.net.SocketTimeoutException;

public class DefaultBackoffStrategy
    implements ConnectionBackoffStrategy
{

    public DefaultBackoffStrategy()
    {
    }

    public boolean shouldBackoff(HttpResponse httpresponse)
    {
        return httpresponse.getStatusLine().getStatusCode() == 503;
    }

    public boolean shouldBackoff(Throwable throwable)
    {
        return (throwable instanceof SocketTimeoutException) || (throwable instanceof ConnectException);
    }
}

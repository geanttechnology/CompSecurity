// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client.support;

import android.util.Log;
import java.io.IOException;
import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.Assert;

public abstract class HttpAccessor
{

    private static final String TAG = org/springframework/http/client/support/HttpAccessor.getSimpleName();
    private ClientHttpRequestFactory requestFactory;

    protected HttpAccessor()
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            requestFactory = new SimpleClientHttpRequestFactory();
            return;
        } else
        {
            requestFactory = new HttpComponentsClientHttpRequestFactory();
            return;
        }
    }

    protected ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod)
        throws IOException
    {
        ClientHttpRequest clienthttprequest = getRequestFactory().createRequest(uri, httpmethod);
        if (Log.isLoggable(TAG, 3))
        {
            Log.d(TAG, (new StringBuilder()).append("Created ").append(httpmethod.name()).append(" request for \"").append(uri).append("\"").toString());
        }
        return clienthttprequest;
    }

    public ClientHttpRequestFactory getRequestFactory()
    {
        return requestFactory;
    }

    public void setRequestFactory(ClientHttpRequestFactory clienthttprequestfactory)
    {
        Assert.notNull(clienthttprequestfactory, "'requestFactory' must not be null");
        requestFactory = clienthttprequestfactory;
    }

}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequestFactory, SimpleBufferingClientHttpRequest, SimpleStreamingClientHttpRequest, ClientHttpRequest

public class SimpleClientHttpRequestFactory
    implements ClientHttpRequestFactory
{

    private boolean bufferRequestBody;
    private int chunkSize;
    private int connectTimeout;
    private Proxy proxy;
    private int readTimeout;

    public SimpleClientHttpRequestFactory()
    {
        bufferRequestBody = true;
        chunkSize = 0;
        connectTimeout = -1;
        readTimeout = -1;
    }

    public ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod)
        throws IOException
    {
        uri = openConnection(uri.toURL(), proxy);
        prepareConnection(uri, httpmethod.name());
        if (bufferRequestBody)
        {
            return new SimpleBufferingClientHttpRequest(uri);
        } else
        {
            return new SimpleStreamingClientHttpRequest(uri, chunkSize);
        }
    }

    protected HttpURLConnection openConnection(URL url, Proxy proxy1)
        throws IOException
    {
        if (proxy1 != null)
        {
            url = url.openConnection(proxy1);
        } else
        {
            url = url.openConnection();
        }
        Assert.isInstanceOf(java/net/HttpURLConnection, url);
        return (HttpURLConnection)url;
    }

    protected void prepareConnection(HttpURLConnection httpurlconnection, String s)
        throws IOException
    {
        if (connectTimeout >= 0)
        {
            httpurlconnection.setConnectTimeout(connectTimeout);
        }
        if (readTimeout >= 0)
        {
            httpurlconnection.setReadTimeout(readTimeout);
        }
        httpurlconnection.setDoInput(true);
        if ("GET".equals(s))
        {
            httpurlconnection.setInstanceFollowRedirects(true);
        } else
        {
            httpurlconnection.setInstanceFollowRedirects(false);
        }
        if ("PUT".equals(s) || "POST".equals(s))
        {
            httpurlconnection.setDoOutput(true);
        } else
        {
            httpurlconnection.setDoOutput(false);
        }
        httpurlconnection.setRequestMethod(s);
    }
}

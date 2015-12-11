// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.PoolingHttpClientConnectionManager;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            HttpClientBuilder, MinimalHttpClient, CloseableHttpClient

public class HttpClients
{

    private HttpClients()
    {
    }

    public static CloseableHttpClient createDefault()
    {
        return HttpClientBuilder.create().build();
    }

    public static CloseableHttpClient createMinimal()
    {
        return new MinimalHttpClient(new PoolingHttpClientConnectionManager());
    }

    public static CloseableHttpClient createMinimal(HttpClientConnectionManager httpclientconnectionmanager)
    {
        return new MinimalHttpClient(httpclientconnectionmanager);
    }

    public static CloseableHttpClient createSystem()
    {
        return HttpClientBuilder.create().useSystemProperties().build();
    }

    public static HttpClientBuilder custom()
    {
        return HttpClientBuilder.create();
    }
}

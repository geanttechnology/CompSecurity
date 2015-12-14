// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.http;

import android.content.Context;
import com.amazon.gallery.framework.network.auth.AmazonHttpClientFactory;
import org.apache.http.client.HttpClient;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.http:
//            HttpFactory

public abstract class AbstractHttpFactory
    implements HttpFactory
{

    private static HttpClient httpClient = null;

    public AbstractHttpFactory()
    {
    }

    public HttpClient getHttpClient(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        if (httpClient == null)
        {
            httpClient = AmazonHttpClientFactory.getHttpClient();
        }
        context = httpClient;
        this;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

}

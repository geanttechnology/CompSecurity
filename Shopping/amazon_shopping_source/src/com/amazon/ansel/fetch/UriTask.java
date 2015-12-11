// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.cache.ResourceCacheValue;
import com.amazon.ansel.fetch.tools.web.WebClient;
import com.amazon.ansel.fetch.tools.web.WebClientFactory;
import com.amazon.ansel.fetch.tools.web.WebConnection;
import com.amazon.ansel.fetch.tools.web.WebResponse;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.ansel.fetch:
//            LoaderTask, LoaderException, LoaderContext, UriRequest

public abstract class UriTask extends LoaderTask
{

    private volatile WebConnection connection;
    private final UriRequest uriRequest;

    public UriTask(LoaderContext loadercontext, Object obj, long l, UriRequest urirequest)
    {
        super(loadercontext, obj, l);
        uriRequest = urirequest;
    }

    protected void abortTask()
    {
        WebConnection webconnection;
        webconnection = connection;
        if (webconnection == null)
        {
            break MISSING_BLOCK_LABEL_15;
        }
        webconnection.abort();
        return;
        Throwable throwable;
        throwable;
    }

    public ResourceCacheValue executeTask()
        throws LoaderException
    {
        InputStream inputstream;
        InputStream inputstream2;
        ResourceCacheValue resourcecachevalue;
        resourcecachevalue = null;
        inputstream2 = null;
        inputstream = resourcecachevalue;
        Object obj = getContext().getWebClientFactory().getWebClient();
        InputStream inputstream1;
        inputstream1 = inputstream2;
        inputstream = resourcecachevalue;
        connection = ((WebClient) (obj)).createConnection(uriRequest.getMethod(), uriRequest.getUri(), uriRequest.getHeaders(), null);
        inputstream1 = inputstream2;
        inputstream = resourcecachevalue;
        obj = connection.getResponse();
        inputstream1 = inputstream2;
        inputstream = resourcecachevalue;
        inputstream2 = ((WebResponse) (obj)).getContent();
        inputstream1 = inputstream2;
        inputstream = inputstream2;
        resourcecachevalue = readResponse(((WebResponse) (obj)).getStatusCode(), inputstream2);
        inputstream1 = inputstream2;
        inputstream = inputstream2;
        connection = null;
        Exception exception;
        IOException ioexception2;
        if (inputstream2 != null)
        {
            try
            {
                inputstream2.close();
            }
            catch (IOException ioexception)
            {
                return resourcecachevalue;
            }
        }
        return resourcecachevalue;
        ioexception2;
        inputstream = inputstream1;
        throw new LoaderException(ioexception2);
        exception;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception1) { }
        }
        throw exception;
    }

    public abstract ResourceCacheValue readResponse(int i, InputStream inputstream)
        throws LoaderException;
}

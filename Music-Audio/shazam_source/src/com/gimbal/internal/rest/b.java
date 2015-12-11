// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.rest;

import java.io.IOException;
import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.Assert;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

public final class b extends RestTemplate
{

    public b(HttpComponentsClientHttpRequestFactory httpcomponentsclienthttprequestfactory)
    {
        super(httpcomponentsclienthttprequestfactory);
    }

    protected final Object doExecute(URI uri, HttpMethod httpmethod, RequestCallback requestcallback, ResponseExtractor responseextractor)
    {
        Object obj;
        obj = null;
        Assert.notNull(uri, "'url' must not be null");
        Assert.notNull(httpmethod, "'method' must not be null");
        uri = createRequest(uri, httpmethod);
        if (requestcallback == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        requestcallback.doWithRequest(uri);
        uri = uri.execute();
        httpmethod = uri;
        if (!getErrorHandler().hasError(uri))
        {
            break MISSING_BLOCK_LABEL_67;
        }
        httpmethod = uri;
        getErrorHandler().handleError(uri);
        if (responseextractor == null) goto _L2; else goto _L1
_L1:
        httpmethod = uri;
        requestcallback = ((RequestCallback) (responseextractor.extractData(uri)));
        httpmethod = requestcallback;
        requestcallback = httpmethod;
        if (uri != null)
        {
            uri.close();
            requestcallback = httpmethod;
        }
_L4:
        return requestcallback;
_L2:
        requestcallback = obj;
        if (uri == null) goto _L4; else goto _L3
_L3:
        uri.close();
        return null;
        requestcallback;
        uri = null;
_L8:
        httpmethod = uri;
        throw new ResourceAccessException((new StringBuilder("I/O error: ")).append(requestcallback.getMessage()).toString(), requestcallback);
        uri;
_L6:
        if (httpmethod != null)
        {
            httpmethod.close();
        }
        throw uri;
        uri;
        httpmethod = null;
        if (true) goto _L6; else goto _L5
_L5:
        requestcallback;
        if (true) goto _L8; else goto _L7
_L7:
    }
}

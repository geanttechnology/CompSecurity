// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.service;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.http.response.ResponseHandler;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import com.comcast.cim.httpcomponentsandroid.protocol.BasicHttpContext;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import com.comcast.cim.httpcomponentsandroid.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultHttpService
    implements HttpService
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/apachehttp/service/DefaultHttpService);
    private HttpClient httpClient;

    public DefaultHttpService(HttpClient httpclient)
    {
        httpClient = httpclient;
    }

    private Map convertHeadersToMap(Header aheader[])
    {
        HashMap hashmap = new HashMap(aheader.length);
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            Header header = aheader[i];
            hashmap.put(header.getName(), header.getValue());
        }

        return hashmap;
    }

    public ResponseHandler executeRequest(RequestProvider requestprovider, Provider provider)
    {
        HttpEntity httpentity;
        Object obj;
        ResponseHandler responsehandler;
        Object obj1;
        Object obj2;
        responsehandler = (ResponseHandler)provider.get();
        obj1 = (HttpUriRequest)requestprovider.createRequest();
        obj2 = new BasicHttpContext();
        obj = null;
        httpentity = null;
        provider = httpentity;
        requestprovider = ((RequestProvider) (obj));
        obj1 = httpClient.execute(((HttpUriRequest) (obj1)), ((HttpContext) (obj2)));
        provider = httpentity;
        requestprovider = ((RequestProvider) (obj));
        httpentity = ((HttpResponse) (obj1)).getEntity();
        provider = httpentity;
        requestprovider = httpentity;
        obj = (HttpUriRequest)((HttpContext) (obj2)).getAttribute("http.request");
        provider = httpentity;
        requestprovider = httpentity;
        obj2 = (HttpHost)((HttpContext) (obj2)).getAttribute("http.target_host");
        provider = httpentity;
        requestprovider = httpentity;
        if (!((HttpUriRequest) (obj)).getURI().isAbsolute()) goto _L2; else goto _L1
_L1:
        provider = httpentity;
        requestprovider = httpentity;
        obj = ((HttpUriRequest) (obj)).getURI().toString();
_L4:
        provider = httpentity;
        requestprovider = httpentity;
        responsehandler.handleResponseHeaders(((String) (obj)), new DetailedRequestStatus(Integer.valueOf(((HttpResponse) (obj1)).getStatusLine().getStatusCode()), ((HttpResponse) (obj1)).getStatusLine().getReasonPhrase()), convertHeadersToMap(((HttpResponse) (obj1)).getAllHeaders()));
        provider = httpentity;
        requestprovider = httpentity;
        if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() == 204)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        provider = httpentity;
        requestprovider = httpentity;
        if (httpentity.getContent() == null)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        provider = httpentity;
        requestprovider = httpentity;
        responsehandler.handleResponseBody(httpentity.getContent());
        IOException ioexception;
        try
        {
            EntityUtils.consume(httpentity);
        }
        // Misplaced declaration of an exception variable
        catch (RequestProvider requestprovider)
        {
            return responsehandler;
        }
        return responsehandler;
_L2:
        provider = httpentity;
        requestprovider = httpentity;
        obj = (new StringBuilder()).append(((HttpHost) (obj2)).toURI()).append(((HttpUriRequest) (obj)).getURI()).toString();
        if (true) goto _L4; else goto _L3
_L3:
        ioexception;
        requestprovider = provider;
        throw new CimIOException(ioexception);
        provider;
        try
        {
            EntityUtils.consume(requestprovider);
        }
        // Misplaced declaration of an exception variable
        catch (RequestProvider requestprovider) { }
        throw provider;
    }

}

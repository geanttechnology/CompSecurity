// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service.resttemplate;

import com.disney.datg.videoplatforms.sdk.service.Request;
import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

public class RestTemplateRequest
    implements Request
{

    private final Class clazz;
    private HttpHeaders headers;
    private HttpMethod httpMethod;
    private MultiValueMap postParams;
    private URI serviceUri;

    public RestTemplateRequest(URI uri, HttpMethod httpmethod, Class class1)
    {
        clazz = class1;
        setServiceUri(uri);
        setHttpMethod(httpmethod);
    }

    public RestTemplateRequest(URI uri, HttpMethod httpmethod, HttpHeaders httpheaders, MultiValueMap multivaluemap, Class class1)
    {
        clazz = class1;
        setPostParams(multivaluemap);
        setHeaders(httpheaders);
        setServiceUri(uri);
        setHttpMethod(httpmethod);
    }

    public void addHeader(String s, String s1)
    {
        if (headers != null)
        {
            headers.add(s, s1);
        }
    }

    public HttpEntity createHttpEntity()
    {
        if (postParams != null && postParams.size() > 0)
        {
            return new HttpEntity(postParams, getHeaders());
        } else
        {
            return new HttpEntity(null, getHeaders());
        }
    }

    public HttpHeaders getHeaders()
    {
        return headers;
    }

    public HttpMethod getHttpMethod()
    {
        return httpMethod;
    }

    public Class getResponseType()
    {
        return clazz;
    }

    public URI getServiceUri()
    {
        return serviceUri;
    }

    public void setHeaders(HttpHeaders httpheaders)
    {
        headers = httpheaders;
    }

    public void setHttpMethod(HttpMethod httpmethod)
    {
        httpMethod = httpmethod;
    }

    public void setPostParams(MultiValueMap multivaluemap)
    {
        postParams = multivaluemap;
    }

    public void setServiceUri(URI uri)
    {
        serviceUri = uri;
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.EntityEnclosingMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

// Referenced classes of package org.springframework.http.client:
//            AbstractBufferingClientHttpRequest, CommonsClientHttpResponse, ClientHttpResponse

final class CommonsClientHttpRequest extends AbstractBufferingClientHttpRequest
{

    private final HttpClient httpClient;
    private final HttpMethodBase httpMethod;

    CommonsClientHttpRequest(HttpClient httpclient, HttpMethodBase httpmethodbase)
    {
        httpClient = httpclient;
        httpMethod = httpmethodbase;
    }

    public ClientHttpResponse executeInternal(HttpHeaders httpheaders, byte abyte0[])
        throws IOException
    {
        for (httpheaders = httpheaders.entrySet().iterator(); httpheaders.hasNext();)
        {
            Object obj = (java.util.Map.Entry)httpheaders.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                String s1 = (String)((Iterator) (obj)).next();
                httpMethod.addRequestHeader(s, s1);
            }
        }

        if (httpMethod instanceof EntityEnclosingMethod)
        {
            ((EntityEnclosingMethod)httpMethod).setRequestEntity(new ByteArrayRequestEntity(abyte0));
        }
        httpClient.executeMethod(httpMethod);
        return new CommonsClientHttpResponse(httpMethod);
    }

    public HttpMethod getMethod()
    {
        return HttpMethod.valueOf(httpMethod.getName());
    }

    public java.net.URI getURI()
    {
        java.net.URI uri;
        try
        {
            uri = java.net.URI.create(httpMethod.getURI().getEscapedURI());
        }
        catch (URIException uriexception)
        {
            throw new IllegalStateException((new StringBuilder()).append("Could not get HttpMethod URI: ").append(uriexception.getMessage()).toString(), uriexception);
        }
        return uri;
    }
}

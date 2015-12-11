// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

// Referenced classes of package org.springframework.http.client:
//            AbstractBufferingClientHttpRequest, HttpComponentsClientHttpResponse, ClientHttpResponse

final class HttpComponentsClientHttpRequest extends AbstractBufferingClientHttpRequest
{

    private final HttpClient httpClient;
    private final HttpContext httpContext;
    private final HttpUriRequest httpRequest;

    public HttpComponentsClientHttpRequest(HttpClient httpclient, HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        httpClient = httpclient;
        httpRequest = httpurirequest;
        httpContext = httpcontext;
    }

    public ClientHttpResponse executeInternal(HttpHeaders httpheaders, byte abyte0[])
        throws IOException
    {
        httpheaders = httpheaders.entrySet().iterator();
        do
        {
            if (!httpheaders.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)httpheaders.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            if (!s.equalsIgnoreCase("Content-Length") && !s.equalsIgnoreCase("Transfer-Encoding"))
            {
                obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    String s1 = (String)((Iterator) (obj)).next();
                    httpRequest.addHeader(s, s1);
                }
            }
        } while (true);
        if (httpRequest instanceof HttpEntityEnclosingRequest)
        {
            ((HttpEntityEnclosingRequest)httpRequest).setEntity(new ByteArrayEntity(abyte0));
        }
        return new HttpComponentsClientHttpResponse(httpClient.execute(httpRequest, httpContext));
    }

    public HttpMethod getMethod()
    {
        return HttpMethod.valueOf(httpRequest.getMethod());
    }

    public URI getURI()
    {
        return httpRequest.getURI();
    }
}

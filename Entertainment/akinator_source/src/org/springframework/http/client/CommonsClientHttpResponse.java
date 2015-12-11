// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;
import org.springframework.http.HttpHeaders;

// Referenced classes of package org.springframework.http.client:
//            AbstractClientHttpResponse

final class CommonsClientHttpResponse extends AbstractClientHttpResponse
{

    private HttpHeaders headers;
    private final HttpMethod httpMethod;

    CommonsClientHttpResponse(HttpMethod httpmethod)
    {
        httpMethod = httpmethod;
    }

    protected void closeInternal()
    {
        httpMethod.releaseConnection();
    }

    protected InputStream getBodyInternal()
        throws IOException
    {
        return httpMethod.getResponseBodyAsStream();
    }

    public HttpHeaders getHeaders()
    {
        if (headers == null)
        {
            headers = new HttpHeaders();
            Header aheader[] = httpMethod.getResponseHeaders();
            int j = aheader.length;
            for (int i = 0; i < j; i++)
            {
                Header header = aheader[i];
                headers.add(header.getName(), header.getValue());
            }

        }
        return headers;
    }

    public int getRawStatusCode()
    {
        return httpMethod.getStatusCode();
    }

    public String getStatusText()
    {
        return httpMethod.getStatusText();
    }
}

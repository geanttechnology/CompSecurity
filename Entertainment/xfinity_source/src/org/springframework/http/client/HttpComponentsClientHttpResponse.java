// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.springframework.http.HttpHeaders;

// Referenced classes of package org.springframework.http.client:
//            AbstractClientHttpResponse

final class HttpComponentsClientHttpResponse extends AbstractClientHttpResponse
{

    private HttpHeaders headers;
    private final HttpResponse httpResponse;

    HttpComponentsClientHttpResponse(HttpResponse httpresponse)
    {
        httpResponse = httpresponse;
    }

    protected void closeInternal()
    {
        HttpEntity httpentity;
        httpentity = httpResponse.getEntity();
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        httpentity.consumeContent();
        return;
        IOException ioexception;
        ioexception;
    }

    protected InputStream getBodyInternal()
        throws IOException
    {
        HttpEntity httpentity = httpResponse.getEntity();
        if (httpentity != null)
        {
            return httpentity.getContent();
        } else
        {
            return null;
        }
    }

    public HttpHeaders getHeaders()
    {
        if (headers == null)
        {
            headers = new HttpHeaders();
            Header aheader[] = httpResponse.getAllHeaders();
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
        throws IOException
    {
        return httpResponse.getStatusLine().getStatusCode();
    }

    public String getStatusText()
        throws IOException
    {
        return httpResponse.getStatusLine().getReasonPhrase();
    }
}

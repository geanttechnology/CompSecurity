// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.InputStream;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethod;
import org.springframework.http.HttpHeaders;

// Referenced classes of package org.springframework.http.client:
//            AbstractClientHttpResponse

final class e extends AbstractClientHttpResponse
{

    private final HttpMethod a;
    private HttpHeaders b;

    e(HttpMethod httpmethod)
    {
        a = httpmethod;
    }

    protected final void closeInternal()
    {
        a.releaseConnection();
    }

    protected final InputStream getBodyInternal()
    {
        return a.getResponseBodyAsStream();
    }

    public final HttpHeaders getHeaders()
    {
        if (b == null)
        {
            b = new HttpHeaders();
            Header aheader[] = a.getResponseHeaders();
            int j = aheader.length;
            for (int i = 0; i < j; i++)
            {
                Header header = aheader[i];
                b.add(header.getName(), header.getValue());
            }

        }
        return b;
    }

    public final int getRawStatusCode()
    {
        return a.getStatusCode();
    }

    public final String getStatusText()
    {
        return a.getStatusText();
    }
}

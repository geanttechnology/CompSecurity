// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.web.client;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpResponse;

// Referenced classes of package org.springframework.web.client:
//            ResponseExtractor, RestTemplate

private static class <init>
    implements ResponseExtractor
{

    public volatile Object extractData(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        return extractData(clienthttpresponse);
    }

    public HttpHeaders extractData(ClientHttpResponse clienthttpresponse)
        throws IOException
    {
        return clienthttpresponse.getHeaders();
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}

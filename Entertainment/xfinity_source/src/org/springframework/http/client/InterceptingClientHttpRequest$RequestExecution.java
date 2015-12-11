// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.util.FileCopyUtils;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequestExecution, InterceptingClientHttpRequest, ClientHttpRequestInterceptor, ClientHttpRequestFactory, 
//            ClientHttpRequest, ClientHttpResponse

private class <init>
    implements ClientHttpRequestExecution
{

    private final Iterator iterator;
    final InterceptingClientHttpRequest this$0;

    public ClientHttpResponse execute(HttpRequest httprequest, byte abyte0[])
        throws IOException
    {
        if (iterator.hasNext())
        {
            return ((ClientHttpRequestInterceptor)iterator.next()).intercept(httprequest, abyte0, this);
        }
        ClientHttpRequest clienthttprequest = InterceptingClientHttpRequest.access$200(InterceptingClientHttpRequest.this).createRequest(httprequest.getURI(), httprequest.getMethod());
        clienthttprequest.getHeaders().putAll(httprequest.getHeaders());
        if (abyte0.length > 0)
        {
            FileCopyUtils.copy(abyte0, clienthttprequest.getBody());
        }
        return clienthttprequest.execute();
    }

    private ()
    {
        this$0 = InterceptingClientHttpRequest.this;
        super();
        iterator = InterceptingClientHttpRequest.access$100(InterceptingClientHttpRequest.this).iterator();
    }

    iterator(iterator iterator1)
    {
        this();
    }
}

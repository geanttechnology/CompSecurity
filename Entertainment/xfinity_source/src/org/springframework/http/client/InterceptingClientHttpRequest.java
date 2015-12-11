// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.util.FileCopyUtils;

// Referenced classes of package org.springframework.http.client:
//            AbstractBufferingClientHttpRequest, ClientHttpRequestFactory, ClientHttpResponse, ClientHttpRequestExecution, 
//            ClientHttpRequestInterceptor, ClientHttpRequest

class InterceptingClientHttpRequest extends AbstractBufferingClientHttpRequest
{
    private class RequestExecution
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
            ClientHttpRequest clienthttprequest = requestFactory.createRequest(httprequest.getURI(), httprequest.getMethod());
            clienthttprequest.getHeaders().putAll(httprequest.getHeaders());
            if (abyte0.length > 0)
            {
                FileCopyUtils.copy(abyte0, clienthttprequest.getBody());
            }
            return clienthttprequest.execute();
        }

        private RequestExecution()
        {
            this$0 = InterceptingClientHttpRequest.this;
            super();
            iterator = interceptors.iterator();
        }

    }


    private final List interceptors;
    private HttpMethod method;
    private final ClientHttpRequestFactory requestFactory;
    private URI uri;

    protected InterceptingClientHttpRequest(ClientHttpRequestFactory clienthttprequestfactory, List list, URI uri1, HttpMethod httpmethod)
    {
        requestFactory = clienthttprequestfactory;
        interceptors = list;
        method = httpmethod;
        uri = uri1;
    }

    protected final ClientHttpResponse executeInternal(HttpHeaders httpheaders, byte abyte0[])
        throws IOException
    {
        return (new RequestExecution()).execute(this, abyte0);
    }

    public HttpMethod getMethod()
    {
        return method;
    }

    public URI getURI()
    {
        return uri;
    }


}

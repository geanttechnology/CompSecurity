// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.http.client:
//            AbstractClientHttpRequestFactoryWrapper, InterceptingClientHttpRequest, ClientHttpRequestFactory, ClientHttpRequest

public class InterceptingClientHttpRequestFactory extends AbstractClientHttpRequestFactoryWrapper
{

    private final List interceptors;

    public InterceptingClientHttpRequestFactory(ClientHttpRequestFactory clienthttprequestfactory, List list)
    {
        super(clienthttprequestfactory);
        Assert.notNull(clienthttprequestfactory, "'requestFactory' must not be null");
        if (list == null)
        {
            list = Collections.emptyList();
        }
        interceptors = list;
    }

    protected ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod, ClientHttpRequestFactory clienthttprequestfactory)
    {
        return new InterceptingClientHttpRequest(clienthttprequestfactory, interceptors, uri, httpmethod);
    }
}

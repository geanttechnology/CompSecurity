// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client;

import java.io.IOException;
import java.net.URI;
import org.springframework.http.HttpMethod;
import org.springframework.util.Assert;

// Referenced classes of package org.springframework.http.client:
//            ClientHttpRequestFactory, ClientHttpRequest

public abstract class AbstractClientHttpRequestFactoryWrapper
    implements ClientHttpRequestFactory
{

    private final ClientHttpRequestFactory requestFactory;

    protected AbstractClientHttpRequestFactoryWrapper(ClientHttpRequestFactory clienthttprequestfactory)
    {
        Assert.notNull(clienthttprequestfactory, "'requestFactory' must not be null");
        requestFactory = clienthttprequestfactory;
    }

    public final ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod)
        throws IOException
    {
        return createRequest(uri, httpmethod, requestFactory);
    }

    protected abstract ClientHttpRequest createRequest(URI uri, HttpMethod httpmethod, ClientHttpRequestFactory clienthttprequestfactory)
        throws IOException;
}

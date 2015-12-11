// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.http.client.support;

import java.util.List;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;

// Referenced classes of package org.springframework.http.client.support:
//            HttpAccessor

public abstract class InterceptingHttpAccessor extends HttpAccessor
{

    private List interceptors;

    public InterceptingHttpAccessor()
    {
    }

    public List getInterceptors()
    {
        return interceptors;
    }

    public ClientHttpRequestFactory getRequestFactory()
    {
        ClientHttpRequestFactory clienthttprequestfactory = super.getRequestFactory();
        Object obj = clienthttprequestfactory;
        if (!CollectionUtils.isEmpty(getInterceptors()))
        {
            obj = new InterceptingClientHttpRequestFactory(clienthttprequestfactory, getInterceptors());
        }
        return ((ClientHttpRequestFactory) (obj));
    }
}

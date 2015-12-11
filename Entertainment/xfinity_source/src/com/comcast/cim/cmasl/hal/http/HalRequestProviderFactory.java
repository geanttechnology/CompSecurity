// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.http;

import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProviderFactory;

// Referenced classes of package com.comcast.cim.cmasl.hal.http:
//            HalRequestProvider

public class HalRequestProviderFactory
    implements RequestProviderFactory
{

    private final RequestProviderFactory requestProviderFactory;

    public HalRequestProviderFactory(RequestProviderFactory requestproviderfactory)
    {
        requestProviderFactory = requestproviderfactory;
    }

    public HalRequestProvider create(String s)
    {
        return new HalRequestProvider(requestProviderFactory.create(s));
    }

    public volatile RequestProvider create(String s)
    {
        return create(s);
    }

    public RequestProvider create(String s, String s1)
    {
        return new HalRequestProvider(requestProviderFactory.create(s, s1));
    }
}

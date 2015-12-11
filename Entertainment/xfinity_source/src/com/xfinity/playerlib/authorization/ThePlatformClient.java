// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            ThePlatformResponseHandler, SMILResource

public class ThePlatformClient
{

    private final HttpService platformResponseService;
    private final RequestProviderFactory requestProviderFactory;

    public ThePlatformClient(HttpService httpservice, RequestProviderFactory requestproviderfactory)
    {
        platformResponseService = httpservice;
        requestProviderFactory = requestproviderfactory;
    }

    public SMILResource getSMILResource(String s)
    {
        s = requestProviderFactory.create(s);
        return ((ThePlatformResponseHandler)platformResponseService.executeRequest(s, new Provider() {

            final ThePlatformClient this$0;

            public ThePlatformResponseHandler get()
            {
                return new ThePlatformResponseHandler();
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = ThePlatformClient.this;
                super();
            }
        })).getSMILResource();
    }
}

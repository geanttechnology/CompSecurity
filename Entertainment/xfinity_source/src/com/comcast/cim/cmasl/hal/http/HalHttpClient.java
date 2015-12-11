// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.http;

import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.microdata.client.HypermediaClient;
import com.comcast.cim.microdata.model.MicrodataItem;

// Referenced classes of package com.comcast.cim.cmasl.hal.http:
//            HalResponseHandler

public class HalHttpClient
{

    private final HttpService halHttpService;
    private final HypermediaClient hypermediaClient;
    private final RequestProviderFactory requestProviderFactory;

    public HalHttpClient(HttpService httpservice, RequestProviderFactory requestproviderfactory, HypermediaClient hypermediaclient)
    {
        halHttpService = httpservice;
        requestProviderFactory = requestproviderfactory;
        hypermediaClient = hypermediaclient;
    }

    public MicrodataItem fetchMicroData(final String halSource)
    {
        return ((HalResponseHandler)halHttpService.executeRequest(requestProviderFactory.create(halSource), new Provider() {

            final HalHttpClient this$0;
            final String val$halSource;

            public HalResponseHandler get()
            {
                return new HalResponseHandler(hypermediaClient, halSource);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = HalHttpClient.this;
                halSource = s;
                super();
            }
        })).getMicrodataResource();
    }

}

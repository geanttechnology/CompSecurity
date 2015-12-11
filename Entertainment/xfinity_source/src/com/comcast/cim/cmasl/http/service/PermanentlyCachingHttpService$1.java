// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.service;

import com.comcast.cim.cmasl.http.request.CacheableRequestProvider;
import com.comcast.cim.cmasl.http.response.ResponseHandler;
import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.comcast.cim.cmasl.http.service:
//            PermanentlyCachingHttpService

class val.responseHandlerProvider
    implements Provider
{

    final PermanentlyCachingHttpService this$0;
    final CacheableRequestProvider val$requestProvider;
    final Provider val$responseHandlerProvider;

    public reamStoringResponseHandler get()
    {
        return new reamStoringResponseHandler(PermanentlyCachingHttpService.this, PermanentlyCachingHttpService.access$000(PermanentlyCachingHttpService.this), val$requestProvider.getCacheKey(), (ResponseHandler)val$responseHandlerProvider.get(), null);
    }

    public volatile Object get()
    {
        return get();
    }

    reamStoringResponseHandler()
    {
        this$0 = final_permanentlycachinghttpservice;
        val$requestProvider = cacheablerequestprovider;
        val$responseHandlerProvider = Provider.this;
        super();
    }
}

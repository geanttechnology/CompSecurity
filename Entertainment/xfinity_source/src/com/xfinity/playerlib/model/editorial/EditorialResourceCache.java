// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import com.comcast.cim.cmasl.http.request.DefaultCacheableRequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.xfinity.playerlib.model.editorial:
//            EditorialResponseHandler, EditorialResourceFactory, EditorialParser

public class EditorialResourceCache extends RevalidatingCachingTask
{

    private final String cacheKey;
    private final EditorialResourceFactory editorialResourceFactory;
    private final HttpService httpService;
    private final EditorialParser parser;
    private final RequestProviderFactory requestProviderFactory;
    private final String url;

    public EditorialResourceCache(HttpService httpservice, String s, RevalidationPolicy revalidationpolicy, String s1, RequestProviderFactory requestproviderfactory, EditorialParser editorialparser, EditorialResourceFactory editorialresourcefactory)
    {
        super(revalidationpolicy);
        httpService = httpservice;
        url = s;
        cacheKey = s1;
        requestProviderFactory = requestproviderfactory;
        parser = editorialparser;
        editorialResourceFactory = editorialresourcefactory;
    }

    protected Object fetchResourceWithNoCache()
    {
        DefaultCacheableRequestProvider defaultcacheablerequestprovider = new DefaultCacheableRequestProvider(requestProviderFactory.create(url), cacheKey);
        return ((EditorialResponseHandler)httpService.executeRequest(defaultcacheablerequestprovider, new Provider() {

            final EditorialResourceCache this$0;

            public EditorialResponseHandler get()
            {
                return new EditorialResponseHandler(parser, editorialResourceFactory);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = EditorialResourceCache.this;
                super();
            }
        })).getEditorialResponse();
    }


}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.cache;

import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.model.ConsumablesHypermediaService;
import com.xfinity.playerlib.model.tags.http.TagsRequestProvider;
import com.xfinity.playerlib.model.tags.http.TagsResponseHandler;
import com.xfinity.playerlib.model.tags.parser.TagsParser;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.net.URI;

public class TagsRootCache extends RevalidatingCachingTask
{

    private final String cacheKey;
    private final HttpService httpService;
    private final Task hypermediaServicesCache;
    private final RequestProviderFactory requestProviderFactory;
    private final TagsParser tagsParser;

    public TagsRootCache(HttpService httpservice, Task task, RevalidationPolicy revalidationpolicy, String s, TagsParser tagsparser, RequestProviderFactory requestproviderfactory)
    {
        super(revalidationpolicy);
        httpService = httpservice;
        hypermediaServicesCache = task;
        cacheKey = s;
        tagsParser = tagsparser;
        requestProviderFactory = requestproviderfactory;
    }

    protected TagsRoot fetchResourceWithNoCache()
    {
        Object obj = (ConsumablesHypermediaService)hypermediaServicesCache.execute();
        obj = new TagsRequestProvider(requestProviderFactory.create(((ConsumablesHypermediaService) (obj)).getTagsUri().toString()), cacheKey);
        return ((TagsResponseHandler)httpService.executeRequest(((com.comcast.cim.cmasl.http.request.RequestProvider) (obj)), new Provider() {

            final TagsRootCache this$0;

            public TagsResponseHandler get()
            {
                return new TagsResponseHandler(tagsParser);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = TagsRootCache.this;
                super();
            }
        })).getTagsRoot();
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }

}

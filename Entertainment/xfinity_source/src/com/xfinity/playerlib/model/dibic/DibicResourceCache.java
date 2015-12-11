// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.model.etc.DibicProgramFactory;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import java.net.URI;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicRequestProvider, DibicResponseHandler, DibicResource, DibicParser

public class DibicResourceCache extends RevalidatingCachingTask
{

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final String cacheKey;
    private final DibicParser dibicParser;
    private final Provider dibicUriProvider;
    private final HttpService httpService;
    private final DibicProgramFactory programFactory;
    private final RequestProviderFactory requestProviderFactory;
    private final Task tagsRootCache;
    private final PlayNowUserManager userManager;

    public DibicResourceCache(HttpService httpservice, Provider provider, DibicProgramFactory dibicprogramfactory, Task task, RevalidationPolicy revalidationpolicy, String s, RequestProviderFactory requestproviderfactory, 
            DibicParser dibicparser, PlayNowUserManager playnowusermanager)
    {
        super(revalidationpolicy);
        Validate.notNull(httpservice);
        Validate.notNull(dibicprogramfactory);
        Validate.notNull(task);
        httpService = httpservice;
        programFactory = dibicprogramfactory;
        tagsRootCache = task;
        cacheKey = s;
        dibicUriProvider = provider;
        requestProviderFactory = requestproviderfactory;
        dibicParser = dibicparser;
        userManager = playnowusermanager;
    }

    protected DibicResource fetchResourceWithNoCache()
    {
        Object obj = requestProviderFactory.create(((URI)dibicUriProvider.get()).toString());
        obj = new DibicRequestProvider(programFactory, (TagsRoot)tagsRootCache.execute(), cacheKey, ((com.comcast.cim.cmasl.http.request.RequestProvider) (obj)));
        return ((DibicResponseHandler)httpService.executeRequest(((com.comcast.cim.cmasl.http.request.RequestProvider) (obj)), new Provider() {

            final DibicResourceCache this$0;

            public DibicResponseHandler get()
            {
                return new DibicResponseHandler(dibicParser, programFactory, (TagsRoot)tagsRootCache.execute(), userManager);
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = DibicResourceCache.this;
                super();
            }
        })).getDibicResource();
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }

    public DibicResource getCachedResultIfAvailable()
    {
        if ((TagsRoot)tagsRootCache.getCachedResultIfAvailable() == null)
        {
            return null;
        } else
        {
            return (DibicResource)super.getCachedResultIfAvailable();
        }
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }




}

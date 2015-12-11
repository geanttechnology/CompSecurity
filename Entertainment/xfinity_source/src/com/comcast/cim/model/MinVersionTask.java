// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model;

import com.comcast.cim.android.version.MinVersionCheckResponseHandler;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.cmasl.xip.XipRequestProviderFactory;
import org.apache.commons.lang3.Validate;

public class MinVersionTask extends RevalidatingCachingTask
{

    private final String appVersionName;
    private final HttpService httpService;
    private final XipRequestProviderFactory requestProviderFactory;

    public MinVersionTask(HttpService httpservice, RevalidationPolicy revalidationpolicy, String s, XipRequestProviderFactory xiprequestproviderfactory)
    {
        super(revalidationpolicy);
        Validate.notNull(httpservice);
        httpService = httpservice;
        appVersionName = s;
        requestProviderFactory = xiprequestproviderfactory;
    }

    protected Integer fetchResourceWithNoCache()
    {
        com.comcast.cim.cmasl.http.request.RequestProvider requestprovider = requestProviderFactory.create(String.format("checkcompat?appId=%s&deviceType=Android", new Object[] {
            appVersionName
        }));
        return ((MinVersionCheckResponseHandler)httpService.executeRequest(requestprovider, new Provider() {

            final MinVersionTask this$0;

            public MinVersionCheckResponseHandler get()
            {
                return new MinVersionCheckResponseHandler();
            }

            public volatile Object get()
            {
                return get();
            }

            
            {
                this$0 = MinVersionTask.this;
                super();
            }
        })).getMinVersion();
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }
}

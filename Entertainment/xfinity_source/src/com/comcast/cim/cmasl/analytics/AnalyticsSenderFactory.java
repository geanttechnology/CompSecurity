// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import com.comcast.cim.cmasl.http.request.RequestProviderFactory;
import com.comcast.cim.cmasl.http.service.HttpService;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.provider.Provider;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.analytics:
//            AnalyticsRequestProvider, AnalyticsResponseHandler

public class AnalyticsSenderFactory
{

    private HttpService httpService;
    private RequestProviderFactory requestProviderFactory;

    public AnalyticsSenderFactory(HttpService httpservice, RequestProviderFactory requestproviderfactory)
    {
        httpService = httpservice;
        requestProviderFactory = requestproviderfactory;
    }

    public Task createTask(final String analyticsHost, final Map dataPairs)
    {
        return new Task() {

            final AnalyticsSenderFactory this$0;
            final String val$analyticsHost;
            final Map val$dataPairs;

            public void clearCachedResult()
            {
            }

            public volatile Object execute()
            {
                return execute();
            }

            public Void execute()
            {
                AnalyticsRequestProvider analyticsrequestprovider = (AnalyticsRequestProvider)requestProviderFactory.create(analyticsHost);
                analyticsrequestprovider.addDataPairs(dataPairs);
                httpService.executeRequest(analyticsrequestprovider, new Provider() {

                    final _cls1 this$1;

                    public AnalyticsResponseHandler get()
                    {
                        return new AnalyticsResponseHandler();
                    }

                    public volatile Object get()
                    {
                        return get();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
                return null;
            }

            public volatile Object getCachedResultIfAvailable()
            {
                return getCachedResultIfAvailable();
            }

            public Void getCachedResultIfAvailable()
            {
                return null;
            }

            public volatile Object getSecondLevelStaleResultIfAvailable()
            {
                return getSecondLevelStaleResultIfAvailable();
            }

            public Void getSecondLevelStaleResultIfAvailable()
            {
                return null;
            }

            public volatile Object getStaleResultIfAvailable()
            {
                return getStaleResultIfAvailable();
            }

            public Void getStaleResultIfAvailable()
            {
                return null;
            }

            
            {
                this$0 = AnalyticsSenderFactory.this;
                analyticsHost = s;
                dataPairs = map;
                super();
            }
        };
    }


}

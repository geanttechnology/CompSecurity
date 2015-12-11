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
//            AnalyticsResponseHandler, AnalyticsSenderFactory, AnalyticsRequestProvider

class this._cls1
    implements Provider
{

    final get this$1;

    public AnalyticsResponseHandler get()
    {
        return new AnalyticsResponseHandler();
    }

    public volatile Object get()
    {
        return get();
    }

    l.dataPairs()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/cmasl/analytics/AnalyticsSenderFactory$1

/* anonymous class */
    class AnalyticsSenderFactory._cls1
        implements Task
    {

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
            AnalyticsRequestProvider analyticsrequestprovider = (AnalyticsRequestProvider)AnalyticsSenderFactory.access$000(AnalyticsSenderFactory.this).create(analyticsHost);
            analyticsrequestprovider.addDataPairs(dataPairs);
            AnalyticsSenderFactory.access$100(AnalyticsSenderFactory.this).executeRequest(analyticsrequestprovider, new AnalyticsSenderFactory._cls1._cls1());
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
                this$0 = final_analyticssenderfactory;
                analyticsHost = s;
                dataPairs = Map.this;
                super();
            }
    }

}

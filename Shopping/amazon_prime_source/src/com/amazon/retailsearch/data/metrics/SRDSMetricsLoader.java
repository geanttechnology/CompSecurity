// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.metrics;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.log.LogEventHandler;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.client.SearchClientUtil;
import com.amazon.retailsearch.client.UiInvocationHandler;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.searchapp.retailsearch.client.MetricsServiceCall;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.model.Metrics;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.data.metrics:
//            MetricsLoader

public class SRDSMetricsLoader
    implements MetricsLoader
{
    private class RequestListener extends AbstractServiceCallListener
    {

        private boolean cancelled;
        private LogEventHandler logEventHandler;
        final SRDSMetricsLoader this$0;

        public void endRequest()
        {
            while (cancelled || gotData) 
            {
                return;
            }
            doLoad = true;
        }

        public void error(Exception exception)
        {
            if (!cancelled)
            {
                doLoad = true;
            }
        }

        public void result(Metrics metrics)
        {
            if (!cancelled && retrieveLatencyValues(metrics) != null)
            {
                gotData = true;
            }
        }

        public volatile void result(Object obj)
        {
            result((Metrics)obj);
        }

        public void startRequest()
        {
            if (cancelled);
        }


/*
        static boolean access$102(RequestListener requestlistener, boolean flag)
        {
            requestlistener.cancelled = flag;
            return flag;
        }

*/

        private RequestListener()
        {
            this$0 = SRDSMetricsLoader.this;
            super();
        }

    }


    private boolean doLoad;
    private boolean gotData;
    private final Map latencyMap = new HashMap();
    private final ResourceProvider loaderGroup;
    ResourceProvider parentResourceProvider;
    private RequestListener requestListener;
    private RetailSearchLogger retailSearchLogger;
    private MetricsServiceCall serviceCall;

    public SRDSMetricsLoader()
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        doLoad = true;
        gotData = false;
        RetailSearchDaggerGraphController.inject(this);
        loaderGroup = new ResourceProvider(parentResourceProvider);
    }

    private Map retrieveLatencyValues(Metrics metrics)
    {
        if (metrics == null)
        {
            return null;
        } else
        {
            latencyMap.clear();
            latencyMap.putAll(metrics.getLatencies());
            return latencyMap;
        }
    }

    public void clear()
    {
        if (loaderGroup != null)
        {
            loaderGroup.cancel();
        }
        if (requestListener != null)
        {
            requestListener.cancelled = true;
        }
        latencyMap.clear();
        doLoad = true;
    }

    public Map getLatencyMap()
    {
        return latencyMap;
    }

    public void load()
    {
        if (!doLoad)
        {
            return;
        }
        try
        {
            doLoad = false;
            gotData = false;
            RetailSearchClient retailsearchclient = AndroidRetailSearchClient.getClient();
            requestListener = new RequestListener();
            serviceCall = retailsearchclient.metrics((ServiceCallListener)UiInvocationHandler.createUiProxy(requestListener, com/amazon/searchapp/retailsearch/client/web/ServiceCallListener));
            SearchClientUtil.executeRequest(serviceCall);
            return;
        }
        catch (Exception exception)
        {
            retailSearchLogger.error("Error while running the metrics loader's load method", exception);
        }
    }




/*
    static boolean access$302(SRDSMetricsLoader srdsmetricsloader, boolean flag)
    {
        srdsmetricsloader.gotData = flag;
        return flag;
    }

*/


/*
    static boolean access$402(SRDSMetricsLoader srdsmetricsloader, boolean flag)
    {
        srdsmetricsloader.doLoad = flag;
        return flag;
    }

*/
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.clouddrive.auth.AuthenticatedURLConnectionFactory;
import com.amazon.clouddrive.configuration.AccountConfiguration;
import com.amazon.clouddrive.configuration.ClientConfiguration;
import com.amazon.clouddrive.configuration.SourceInfoCache;
import com.amazon.clouddrive.extended.AmazonCloudDriveExtendedClient;
import com.amazon.clouddrive.metrics.MetricEvent;
import com.amazon.clouddrive.metrics.MetricListener;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.framework.network.cds.CloudDriveServiceClientFactory;
import com.amazon.gallery.framework.network.http.rest.http.UserAgent;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            TraceableMAPAuthenticatedURLConnectionFactory, MAPAuthenticatedURLConnectionFactory, SharedPreferenceSourceInfoCache, SharedPreferenceEndpointsCache, 
//            ThorCloudDriveServiceClient

public class ThorCloudDriveServiceClientFactory
    implements CloudDriveServiceClientFactory
{
    private static class CDSMetricListener
        implements MetricListener
    {

        private final Profiler profiler;

        public void onMetricEvent(MetricEvent metricevent)
        {
            profiler.trackTimer(com/amazon/clouddrive/extended/AmazonCloudDriveExtendedClient.getSimpleName(), metricevent.getOperationName(), metricevent.getTimeInMillis(), metricevent.hasSucceeded());
        }

        public CDSMetricListener(Profiler profiler1)
        {
            profiler = profiler1;
        }
    }


    private final Context context;
    private final MetricListener metricListener;
    private final UserAgent userAgent;

    public ThorCloudDriveServiceClientFactory(Context context1, UserAgent useragent, Profiler profiler)
    {
        context = context1;
        userAgent = useragent;
        metricListener = new CDSMetricListener(profiler);
    }

    private AuthenticatedURLConnectionFactory getConnectionFactory(String s)
    {
        return new TraceableMAPAuthenticatedURLConnectionFactory(new MAPAuthenticatedURLConnectionFactory(context, s));
    }

    public MixtapeCloudDriveServiceClient getCloudDriveExtendedClient(String s, ExecutorService executorservice)
    {
        return getCloudDriveExtendedClient(s, executorservice, ((SourceInfoCache) (new SharedPreferenceSourceInfoCache((BeanAwareApplication)context, s))));
    }

    public MixtapeCloudDriveServiceClient getCloudDriveExtendedClient(String s, ExecutorService executorservice, SourceInfoCache sourceinfocache)
    {
        Object obj = new SharedPreferenceEndpointsCache(context, s, 1L, TimeUnit.DAYS);
        sourceinfocache = new AccountConfiguration(getConnectionFactory(s), ((com.amazon.clouddrive.configuration.EndpointsCache) (obj)), sourceinfocache);
        obj = new ClientConfiguration(userAgent.toString());
        ((ClientConfiguration) (obj)).setMetricListener(metricListener);
        return new ThorCloudDriveServiceClient(sourceinfocache, ((ClientConfiguration) (obj)), executorservice, context, s, context.getResources().getString(0x7f0e02fb));
    }
}

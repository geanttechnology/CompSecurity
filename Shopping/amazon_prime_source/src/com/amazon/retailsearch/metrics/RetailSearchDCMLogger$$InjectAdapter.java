// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            RetailSearchDCMLogger, SearchMetricsListenerInvoker

public final class ion extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding latencyAdaptiveManager;
    private Binding searchMetricsListenerInvoker;
    private Binding supertype;

    public void attach(Linker linker)
    {
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/metrics/RetailSearchDCMLogger, getClass().getClassLoader());
        searchMetricsListenerInvoker = linker.requestBinding("com.amazon.retailsearch.metrics.SearchMetricsListenerInvoker", com/amazon/retailsearch/metrics/RetailSearchDCMLogger, getClass().getClassLoader());
        latencyAdaptiveManager = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager>", com/amazon/retailsearch/metrics/RetailSearchDCMLogger, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.metrics.BaseAbstractDCMLogger", com/amazon/retailsearch/metrics/RetailSearchDCMLogger, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(featureConfig);
        set1.add(searchMetricsListenerInvoker);
        set1.add(latencyAdaptiveManager);
        set1.add(supertype);
    }

    public void injectMembers(RetailSearchDCMLogger retailsearchdcmlogger)
    {
        retailsearchdcmlogger.featureConfig = (FeatureConfiguration)featureConfig.get();
        retailsearchdcmlogger.searchMetricsListenerInvoker = (SearchMetricsListenerInvoker)searchMetricsListenerInvoker.get();
        retailsearchdcmlogger.latencyAdaptiveManager = (Lazy)latencyAdaptiveManager.get();
        supertype.injectMembers(retailsearchdcmlogger);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchDCMLogger)obj);
    }

    public ion()
    {
        super(null, "members/com.amazon.retailsearch.metrics.RetailSearchDCMLogger", false, com/amazon/retailsearch/metrics/RetailSearchDCMLogger);
    }
}

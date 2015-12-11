// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.metrics;

import com.amazon.ansel.fetch.ResourceProvider;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.data.metrics:
//            SRDSMetricsLoader

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding parentResourceProvider;

    public void attach(Linker linker)
    {
        parentResourceProvider = linker.requestBinding("com.amazon.ansel.fetch.ResourceProvider", com/amazon/retailsearch/data/metrics/SRDSMetricsLoader, getClass().getClassLoader());
    }

    public SRDSMetricsLoader get()
    {
        SRDSMetricsLoader srdsmetricsloader = new SRDSMetricsLoader();
        injectMembers(srdsmetricsloader);
        return srdsmetricsloader;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(parentResourceProvider);
    }

    public void injectMembers(SRDSMetricsLoader srdsmetricsloader)
    {
        srdsmetricsloader.parentResourceProvider = (ResourceProvider)parentResourceProvider.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SRDSMetricsLoader)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.data.metrics.SRDSMetricsLoader", "members/com.amazon.retailsearch.data.metrics.SRDSMetricsLoader", false, com/amazon/retailsearch/data/metrics/SRDSMetricsLoader);
    }
}

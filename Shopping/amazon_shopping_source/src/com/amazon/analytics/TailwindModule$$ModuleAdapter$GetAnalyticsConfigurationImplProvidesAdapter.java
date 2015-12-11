// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import com.amazon.mas.client.featureconfig.FeatureConfigLocator;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule, AnalyticsConfigurationImpl

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private Binding featureConfigLocator;
    private final TailwindModule module;

    public void attach(Linker linker)
    {
        featureConfigLocator = linker.requestBinding("com.amazon.mas.client.featureconfig.FeatureConfigLocator", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
    }

    public AnalyticsConfigurationImpl get()
    {
        return module.getAnalyticsConfigurationImpl((FeatureConfigLocator)featureConfigLocator.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(featureConfigLocator);
    }

    public (TailwindModule tailwindmodule)
    {
        super("com.amazon.analytics.AnalyticsConfigurationImpl", true, "com.amazon.analytics.TailwindModule", "getAnalyticsConfigurationImpl");
        module = tailwindmodule;
        setLibrary(false);
    }
}

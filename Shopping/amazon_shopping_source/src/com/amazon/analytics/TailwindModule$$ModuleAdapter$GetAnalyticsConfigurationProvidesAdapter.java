// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule, AnalyticsConfigurationImpl, AnalyticsConfiguration

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private Binding configImpl;
    private final TailwindModule module;

    public void attach(Linker linker)
    {
        configImpl = linker.requestBinding("com.amazon.analytics.AnalyticsConfigurationImpl", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
    }

    public AnalyticsConfiguration get()
    {
        return module.getAnalyticsConfiguration((AnalyticsConfigurationImpl)configImpl.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(configImpl);
    }

    public a(TailwindModule tailwindmodule)
    {
        super("com.amazon.analytics.AnalyticsConfiguration", true, "com.amazon.analytics.TailwindModule", "getAnalyticsConfiguration");
        module = tailwindmodule;
        setLibrary(false);
    }
}

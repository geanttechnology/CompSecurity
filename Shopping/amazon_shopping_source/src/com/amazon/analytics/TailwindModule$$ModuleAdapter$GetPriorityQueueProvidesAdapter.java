// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import com.amazon.analytics.session.PriorityQueue;
import com.amazon.analytics.session.SessionObserver;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule, AnalyticsConfiguration

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private Binding config;
    private final TailwindModule module;
    private Binding sessionObserver;

    public void attach(Linker linker)
    {
        sessionObserver = linker.requestBinding("com.amazon.analytics.session.SessionObserver", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        config = linker.requestBinding("com.amazon.analytics.AnalyticsConfiguration", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
    }

    public PriorityQueue get()
    {
        return module.getPriorityQueue((SessionObserver)sessionObserver.get(), (AnalyticsConfiguration)config.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(sessionObserver);
        set.add(config);
    }

    public (TailwindModule tailwindmodule)
    {
        super("com.amazon.analytics.session.PriorityQueue", true, "com.amazon.analytics.TailwindModule", "getPriorityQueue");
        module = tailwindmodule;
        setLibrary(false);
    }
}

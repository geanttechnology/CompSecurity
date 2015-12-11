// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import android.content.Context;
import com.amazon.analytics.session.PackageSessionBuilder;
import com.amazon.analytics.session.PriorityQueue;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule, TailwindActivityManager, AnalyticsConfiguration, AnalyticsConfigurationInitializer

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private Binding activityManager;
    private Binding config;
    private Binding context;
    private final TailwindModule module;
    private Binding queue;
    private Binding service;
    private Binding sessionBuilder;

    public void attach(Linker linker)
    {
        context = linker.requestBinding("android.content.Context", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        activityManager = linker.requestBinding("com.amazon.analytics.TailwindActivityManager", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        config = linker.requestBinding("com.amazon.analytics.AnalyticsConfiguration", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        queue = linker.requestBinding("com.amazon.analytics.session.PriorityQueue", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        sessionBuilder = linker.requestBinding("com.amazon.analytics.session.PackageSessionBuilder", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        service = linker.requestBinding("@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
    }

    public AnalyticsConfigurationInitializer get()
    {
        return module.getAnalyticsConfigurationInitializer((Context)context.get(), (TailwindActivityManager)activityManager.get(), (AnalyticsConfiguration)config.get(), (PriorityQueue)queue.get(), (PackageSessionBuilder)sessionBuilder.get(), (ScheduledExecutorService)service.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(context);
        set.add(activityManager);
        set.add(config);
        set.add(queue);
        set.add(sessionBuilder);
        set.add(service);
    }

    public (TailwindModule tailwindmodule)
    {
        super("com.amazon.analytics.AnalyticsConfigurationInitializer", true, "com.amazon.analytics.TailwindModule", "getAnalyticsConfigurationInitializer");
        module = tailwindmodule;
        setLibrary(false);
    }
}

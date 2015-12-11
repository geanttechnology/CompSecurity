// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;

import com.amazon.analytics.AnalyticsConfiguration;
import com.amazon.analytics.AnalyticsConfigurationInitializer;
import com.amazon.analytics.session.PriorityQueue;
import com.amazon.device.analytics.events.EventRecorder;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding config;
    private Binding execService;
    private Binding initializer;
    private Binding queue;
    private Binding recorder;

    public void attach(Linker linker)
    {
        initializer = linker.requestBinding("com.amazon.analytics.AnalyticsConfigurationInitializer", com/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint, getClass().getClassLoader());
        recorder = linker.requestBinding("com.amazon.device.analytics.events.EventRecorder", com/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint, getClass().getClassLoader());
        config = linker.requestBinding("com.amazon.analytics.AnalyticsConfiguration", com/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint, getClass().getClassLoader());
        queue = linker.requestBinding("com.amazon.analytics.session.PriorityQueue", com/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint, getClass().getClassLoader());
        execService = linker.requestBinding("@javax.inject.Named(value=TailwindExecutorService)/java.util.concurrent.ScheduledExecutorService", com/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint, getClass().getClassLoader());
    }

    public execService get()
    {
        execService execservice = new execService();
        injectMembers(execservice);
        return execservice;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(initializer);
        set1.add(recorder);
        set1.add(config);
        set1.add(queue);
        set1.add(execService);
    }

    public void injectMembers(execService execservice)
    {
        execservice.execService = (AnalyticsConfigurationInitializer)initializer.get();
        execservice.initializer = (EventRecorder)recorder.get();
        execservice.recorder = (AnalyticsConfiguration)config.get();
        execservice.config = (PriorityQueue)queue.get();
        execservice.queue = (ScheduledExecutorService)execService.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((injectMembers)obj);
    }

    public ()
    {
        super("com.amazon.analytics.eventbuilder.AnalyticsEventBuilder$InjectPoint", "members/com.amazon.analytics.eventbuilder.AnalyticsEventBuilder$InjectPoint", false, com/amazon/analytics/eventbuilder/AnalyticsEventBuilder$InjectPoint);
    }
}

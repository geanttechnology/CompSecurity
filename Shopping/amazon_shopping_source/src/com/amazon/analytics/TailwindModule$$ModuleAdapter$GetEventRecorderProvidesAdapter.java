// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import android.content.Context;
import com.amazon.device.analytics.events.EventRecorder;
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

    private Binding configImpl;
    private Binding context;
    private final TailwindModule module;

    public void attach(Linker linker)
    {
        context = linker.requestBinding("android.content.Context", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        configImpl = linker.requestBinding("com.amazon.analytics.AnalyticsConfigurationImpl", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
    }

    public EventRecorder get()
    {
        return module.getEventRecorder((Context)context.get(), (AnalyticsConfigurationImpl)configImpl.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(context);
        set.add(configImpl);
    }

    public (TailwindModule tailwindmodule)
    {
        super("com.amazon.device.analytics.events.EventRecorder", true, "com.amazon.analytics.TailwindModule", "getEventRecorder");
        module = tailwindmodule;
        setLibrary(false);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import com.amazon.analytics.session.PackageSessionBuilder;
import com.amazon.analytics.session.SessionObserver;
import com.amazon.device.analytics.events.EventRecorder;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.analytics:
//            TailwindModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final TailwindModule module;
    private Binding recorder;
    private Binding sessionBuilder;

    public void attach(Linker linker)
    {
        recorder = linker.requestBinding("com.amazon.device.analytics.events.EventRecorder", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
        sessionBuilder = linker.requestBinding("com.amazon.analytics.session.PackageSessionBuilder", com/amazon/analytics/TailwindModule, getClass().getClassLoader());
    }

    public SessionObserver get()
    {
        return module.getSessionObserver((EventRecorder)recorder.get(), (PackageSessionBuilder)sessionBuilder.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(recorder);
        set.add(sessionBuilder);
    }

    public (TailwindModule tailwindmodule)
    {
        super("com.amazon.analytics.session.SessionObserver", true, "com.amazon.analytics.TailwindModule", "getSessionObserver");
        module = tailwindmodule;
        setLibrary(false);
    }
}

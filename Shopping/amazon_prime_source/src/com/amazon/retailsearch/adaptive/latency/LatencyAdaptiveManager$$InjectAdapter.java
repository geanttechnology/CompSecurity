// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive.latency;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.adaptive.latency:
//            LatencyAdaptiveManager

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding context;
    private Binding retailSearchDataProvider;
    private Binding supertype;

    public void attach(Linker linker)
    {
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/adaptive/latency/LatencyAdaptiveManager, getClass().getClassLoader());
        context = linker.requestBinding("dagger.Lazy<android.content.Context>", com/amazon/retailsearch/adaptive/latency/LatencyAdaptiveManager, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.adaptive.framework.BaseAdaptiveManager", com/amazon/retailsearch/adaptive/latency/LatencyAdaptiveManager, getClass().getClassLoader(), false, true);
    }

    public LatencyAdaptiveManager get()
    {
        LatencyAdaptiveManager latencyadaptivemanager = new LatencyAdaptiveManager();
        injectMembers(latencyadaptivemanager);
        return latencyadaptivemanager;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(retailSearchDataProvider);
        set1.add(context);
        set1.add(supertype);
    }

    public void injectMembers(LatencyAdaptiveManager latencyadaptivemanager)
    {
        latencyadaptivemanager.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
        latencyadaptivemanager.context = (Lazy)context.get();
        supertype.injectMembers(latencyadaptivemanager);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((LatencyAdaptiveManager)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager", "members/com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager", false, com/amazon/retailsearch/adaptive/latency/LatencyAdaptiveManager);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            StackLayout

public final class  extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding latencyAdaptiveManager;
    private Binding searchDataSource;
    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        searchDataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/results/layout/StackLayout, getClass().getClassLoader());
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/results/layout/StackLayout, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/ui/results/layout/StackLayout, getClass().getClassLoader());
        latencyAdaptiveManager = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.adaptive.latency.LatencyAdaptiveManager>", com/amazon/retailsearch/android/ui/results/layout/StackLayout, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(searchDataSource);
        set1.add(userInteractionListener);
        set1.add(featureConfig);
        set1.add(latencyAdaptiveManager);
    }

    public void injectMembers(StackLayout stacklayout)
    {
        stacklayout.searchDataSource = (SearchDataSource)searchDataSource.get();
        stacklayout.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
        stacklayout.featureConfig = (FeatureConfiguration)featureConfig.get();
        stacklayout.latencyAdaptiveManager = (Lazy)latencyAdaptiveManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((StackLayout)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.StackLayout", false, com/amazon/retailsearch/android/ui/results/layout/StackLayout);
    }
}

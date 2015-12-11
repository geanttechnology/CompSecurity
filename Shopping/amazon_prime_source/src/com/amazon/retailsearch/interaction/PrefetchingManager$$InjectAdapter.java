// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            PrefetchingManager, SearchDataSource

public final class on extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding searchDataSource;

    public void attach(Linker linker)
    {
        searchDataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/interaction/PrefetchingManager, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/interaction/PrefetchingManager, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(searchDataSource);
        set1.add(featureConfig);
    }

    public void injectMembers(PrefetchingManager prefetchingmanager)
    {
        prefetchingmanager.searchDataSource = (SearchDataSource)searchDataSource.get();
        prefetchingmanager.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((PrefetchingManager)obj);
    }

    public on()
    {
        super(null, "members/com.amazon.retailsearch.interaction.PrefetchingManager", false, com/amazon/retailsearch/interaction/PrefetchingManager);
    }
}

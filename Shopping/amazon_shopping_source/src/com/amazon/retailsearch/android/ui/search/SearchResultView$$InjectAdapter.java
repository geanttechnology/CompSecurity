// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            SearchResultView

public final class  extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding parentResourceProvider;
    private Binding preferencesManager;
    private Binding searchDataSource;
    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/search/SearchResultView, getClass().getClassLoader());
        searchDataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/search/SearchResultView, getClass().getClassLoader());
        preferencesManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/search/SearchResultView, getClass().getClassLoader());
        parentResourceProvider = linker.requestBinding("com.amazon.ansel.fetch.ResourceProvider", com/amazon/retailsearch/android/ui/search/SearchResultView, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/ui/search/SearchResultView, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(userInteractionListener);
        set1.add(searchDataSource);
        set1.add(preferencesManager);
        set1.add(parentResourceProvider);
        set1.add(featureConfig);
    }

    public void injectMembers(SearchResultView searchresultview)
    {
        searchresultview.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
        searchresultview.searchDataSource = (SearchDataSource)searchDataSource.get();
        searchresultview.preferencesManager = (UserPreferenceManager)preferencesManager.get();
        searchresultview.parentResourceProvider = (ResourceProvider)parentResourceProvider.get();
        searchresultview.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SearchResultView)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.search.SearchResultView", false, com/amazon/retailsearch/android/ui/search/SearchResultView);
    }
}

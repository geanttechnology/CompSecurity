// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            ViewToggle

public final class ion extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding preferencesManager;

    public void attach(Linker linker)
    {
        preferencesManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/results/ViewToggle, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/ui/results/ViewToggle, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferencesManager);
        set1.add(featureConfig);
    }

    public void injectMembers(ViewToggle viewtoggle)
    {
        viewtoggle.preferencesManager = (UserPreferenceManager)preferencesManager.get();
        viewtoggle.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ViewToggle)obj);
    }

    public ion()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.ViewToggle", false, com/amazon/retailsearch/android/ui/results/ViewToggle);
    }
}

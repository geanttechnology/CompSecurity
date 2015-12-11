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
//            MultiViewToggle

public final class  extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding preferencesManager;

    public void attach(Linker linker)
    {
        preferencesManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/results/MultiViewToggle, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/ui/results/MultiViewToggle, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferencesManager);
        set1.add(featureConfig);
    }

    public void injectMembers(MultiViewToggle multiviewtoggle)
    {
        multiviewtoggle.preferencesManager = (UserPreferenceManager)preferencesManager.get();
        multiviewtoggle.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((MultiViewToggle)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.MultiViewToggle", false, com/amazon/retailsearch/android/ui/results/MultiViewToggle);
    }
}

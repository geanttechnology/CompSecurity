// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            ListLayout

public final class Q extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding supertype;

    public void attach(Linker linker)
    {
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/ui/results/layout/ListLayout, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.android.ui.results.layout.StackLayout", com/amazon/retailsearch/android/ui/results/layout/ListLayout, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(featureConfig);
        set1.add(supertype);
    }

    public void injectMembers(ListLayout listlayout)
    {
        listlayout.featureConfig = (FeatureConfiguration)featureConfig.get();
        supertype.injectMembers(listlayout);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ListLayout)obj);
    }

    public Q()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.ListLayout", false, com/amazon/retailsearch/android/ui/results/layout/ListLayout);
    }
}

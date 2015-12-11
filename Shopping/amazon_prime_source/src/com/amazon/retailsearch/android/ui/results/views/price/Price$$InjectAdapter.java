// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.price;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.price:
//            Price

public final class Q extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding retailSearchDataProvider;

    public void attach(Linker linker)
    {
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/android/ui/results/views/price/Price, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/ui/results/views/price/Price, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(retailSearchDataProvider);
        set1.add(featureConfig);
    }

    public void injectMembers(Price price)
    {
        price.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
        price.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((Price)obj);
    }

    public Q()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.views.price.Price", false, com/amazon/retailsearch/android/ui/results/views/price/Price);
    }
}

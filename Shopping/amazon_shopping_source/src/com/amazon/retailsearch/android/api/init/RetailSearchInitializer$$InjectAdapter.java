// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.init;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.android.api.init:
//            RetailSearchInitializer

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding featureConfig;
    private Binding retailSearchDataProvider;

    public void attach(Linker linker)
    {
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/android/api/init/RetailSearchInitializer, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/api/init/RetailSearchInitializer, getClass().getClassLoader());
    }

    public RetailSearchInitializer get()
    {
        RetailSearchInitializer retailsearchinitializer = new RetailSearchInitializer();
        injectMembers(retailsearchinitializer);
        return retailsearchinitializer;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(retailSearchDataProvider);
        set1.add(featureConfig);
    }

    public void injectMembers(RetailSearchInitializer retailsearchinitializer)
    {
        retailsearchinitializer.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
        retailsearchinitializer.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchInitializer)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.android.api.init.RetailSearchInitializer", "members/com.amazon.retailsearch.android.api.init.RetailSearchInitializer", false, com/amazon/retailsearch/android/api/init/RetailSearchInitializer);
    }
}

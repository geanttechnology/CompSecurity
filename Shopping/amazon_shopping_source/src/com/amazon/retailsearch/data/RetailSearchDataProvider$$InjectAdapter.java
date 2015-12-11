// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.data:
//            RetailSearchDataProvider

public final class ion extends Binding
    implements MembersInjector, Provider
{

    private Binding featureConfig;

    public void attach(Linker linker)
    {
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/data/RetailSearchDataProvider, getClass().getClassLoader());
    }

    public RetailSearchDataProvider get()
    {
        RetailSearchDataProvider retailsearchdataprovider = new RetailSearchDataProvider();
        injectMembers(retailsearchdataprovider);
        return retailsearchdataprovider;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(featureConfig);
    }

    public void injectMembers(RetailSearchDataProvider retailsearchdataprovider)
    {
        retailsearchdataprovider.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchDataProvider)obj);
    }

    public ion()
    {
        super("com.amazon.retailsearch.data.RetailSearchDataProvider", "members/com.amazon.retailsearch.data.RetailSearchDataProvider", false, com/amazon/retailsearch/data/RetailSearchDataProvider);
    }
}

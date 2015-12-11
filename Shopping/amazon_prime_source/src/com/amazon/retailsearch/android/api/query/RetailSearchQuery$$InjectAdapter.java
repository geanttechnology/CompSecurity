// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.query;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.api.query:
//            RetailSearchQuery

public final class  extends Binding
    implements MembersInjector
{

    private Binding featureConfig;

    public void attach(Linker linker)
    {
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/api/query/RetailSearchQuery, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(featureConfig);
    }

    public void injectMembers(RetailSearchQuery retailsearchquery)
    {
        retailsearchquery.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchQuery)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.api.query.RetailSearchQuery", false, com/amazon/retailsearch/android/api/query/RetailSearchQuery);
    }
}

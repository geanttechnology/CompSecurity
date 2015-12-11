// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import android.content.Context;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.client:
//            SearchCallInterceptor

public final class tion extends Binding
    implements MembersInjector, Provider
{

    private Binding context;
    private Binding featureConfig;

    public void attach(Linker linker)
    {
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/client/SearchCallInterceptor, getClass().getClassLoader());
        context = linker.requestBinding("android.content.Context", com/amazon/retailsearch/client/SearchCallInterceptor, getClass().getClassLoader());
    }

    public SearchCallInterceptor get()
    {
        SearchCallInterceptor searchcallinterceptor = new SearchCallInterceptor();
        injectMembers(searchcallinterceptor);
        return searchcallinterceptor;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(featureConfig);
        set1.add(context);
    }

    public void injectMembers(SearchCallInterceptor searchcallinterceptor)
    {
        searchcallinterceptor.featureConfig = (FeatureConfiguration)featureConfig.get();
        searchcallinterceptor.context = (Context)context.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SearchCallInterceptor)obj);
    }

    public tion()
    {
        super("com.amazon.retailsearch.client.SearchCallInterceptor", "members/com.amazon.retailsearch.client.SearchCallInterceptor", false, com/amazon/retailsearch/client/SearchCallInterceptor);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.client:
//            AndroidWebClientFactory

public final class on extends Binding
    implements MembersInjector, Provider
{

    private Binding featureConfig;

    public void attach(Linker linker)
    {
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/client/AndroidWebClientFactory, getClass().getClassLoader());
    }

    public AndroidWebClientFactory get()
    {
        AndroidWebClientFactory androidwebclientfactory = new AndroidWebClientFactory();
        injectMembers(androidwebclientfactory);
        return androidwebclientfactory;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(featureConfig);
    }

    public void injectMembers(AndroidWebClientFactory androidwebclientfactory)
    {
        androidwebclientfactory.featureConfig = (FeatureConfiguration)featureConfig.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((AndroidWebClientFactory)obj);
    }

    public on()
    {
        super("com.amazon.retailsearch.client.AndroidWebClientFactory", "members/com.amazon.retailsearch.client.AndroidWebClientFactory", false, com/amazon/retailsearch/client/AndroidWebClientFactory);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.assets;

import android.content.Context;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.data.assets:
//            SRDSAssetsLoader

public final class tion extends Binding
    implements MembersInjector, Provider
{

    private Binding context;
    private Binding featureConfig;
    private Binding parentResourceProvider;

    public void attach(Linker linker)
    {
        parentResourceProvider = linker.requestBinding("com.amazon.ansel.fetch.ResourceProvider", com/amazon/retailsearch/data/assets/SRDSAssetsLoader, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/data/assets/SRDSAssetsLoader, getClass().getClassLoader());
        context = linker.requestBinding("android.content.Context", com/amazon/retailsearch/data/assets/SRDSAssetsLoader, getClass().getClassLoader());
    }

    public SRDSAssetsLoader get()
    {
        SRDSAssetsLoader srdsassetsloader = new SRDSAssetsLoader();
        injectMembers(srdsassetsloader);
        return srdsassetsloader;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(parentResourceProvider);
        set1.add(featureConfig);
        set1.add(context);
    }

    public void injectMembers(SRDSAssetsLoader srdsassetsloader)
    {
        srdsassetsloader.parentResourceProvider = (ResourceProvider)parentResourceProvider.get();
        srdsassetsloader.featureConfig = (FeatureConfiguration)featureConfig.get();
        srdsassetsloader.context = (Context)context.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SRDSAssetsLoader)obj);
    }

    public tion()
    {
        super("com.amazon.retailsearch.data.assets.SRDSAssetsLoader", "members/com.amazon.retailsearch.data.assets.SRDSAssetsLoader", false, com/amazon/retailsearch/data/assets/SRDSAssetsLoader);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import com.amazon.ansel.fetch.LoaderContext;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.interaction.SearchDataSource;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapper

public final class  extends Binding
    implements MembersInjector
{

    private Binding featureConfig;
    private Binding loaderContext;
    private Binding searchDataSource;

    public void attach(Linker linker)
    {
        loaderContext = linker.requestBinding("com.amazon.ansel.fetch.LoaderContext", com/amazon/retailsearch/android/ui/results/views/image/ImageWrapper, getClass().getClassLoader());
        featureConfig = linker.requestBinding("com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration", com/amazon/retailsearch/android/ui/results/views/image/ImageWrapper, getClass().getClassLoader());
        searchDataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/results/views/image/ImageWrapper, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(loaderContext);
        set1.add(featureConfig);
        set1.add(searchDataSource);
    }

    public void injectMembers(ImageWrapper imagewrapper)
    {
        imagewrapper.loaderContext = (LoaderContext)loaderContext.get();
        imagewrapper.featureConfig = (FeatureConfiguration)featureConfig.get();
        imagewrapper.searchDataSource = (SearchDataSource)searchDataSource.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((ImageWrapper)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.views.image.ImageWrapper", false, com/amazon/retailsearch/android/ui/results/views/image/ImageWrapper);
    }
}

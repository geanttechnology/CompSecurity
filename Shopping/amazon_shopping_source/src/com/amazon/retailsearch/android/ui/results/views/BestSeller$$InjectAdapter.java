// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views:
//            BestSeller

public final class  extends Binding
    implements MembersInjector
{

    private Binding retailSearchDataProvider;

    public void attach(Linker linker)
    {
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/android/ui/results/views/BestSeller, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(retailSearchDataProvider);
    }

    public void injectMembers(BestSeller bestseller)
    {
        bestseller.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((BestSeller)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.views.BestSeller", false, com/amazon/retailsearch/android/ui/results/views/BestSeller);
    }
}

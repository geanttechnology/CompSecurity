// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterModel

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding retailSearchDataProvider;

    public void attach(Linker linker)
    {
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/android/ui/results/views/twister/TwisterModel, getClass().getClassLoader());
    }

    public TwisterModel get()
    {
        TwisterModel twistermodel = new TwisterModel();
        injectMembers(twistermodel);
        return twistermodel;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(retailSearchDataProvider);
    }

    public void injectMembers(TwisterModel twistermodel)
    {
        twistermodel.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((TwisterModel)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.android.ui.results.views.twister.TwisterModel", "members/com.amazon.retailsearch.android.ui.results.views.twister.TwisterModel", false, com/amazon/retailsearch/android/ui/results/views/twister/TwisterModel);
    }
}

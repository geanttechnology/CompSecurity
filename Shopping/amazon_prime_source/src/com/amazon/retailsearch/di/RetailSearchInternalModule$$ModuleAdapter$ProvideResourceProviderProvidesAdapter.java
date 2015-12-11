// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.di;

import com.amazon.ansel.fetch.LoaderContext;
import com.amazon.ansel.fetch.ResourceProvider;
import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.di:
//            RetailSearchInternalModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private Binding loaderContext;
    private final RetailSearchInternalModule module;

    public void attach(Linker linker)
    {
        loaderContext = linker.requestBinding("com.amazon.ansel.fetch.LoaderContext", com/amazon/retailsearch/di/RetailSearchInternalModule, getClass().getClassLoader());
    }

    public ResourceProvider get()
    {
        return module.provideResourceProvider((LoaderContext)loaderContext.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(loaderContext);
    }

    public q(RetailSearchInternalModule retailsearchinternalmodule)
    {
        super("com.amazon.ansel.fetch.ResourceProvider", true, "com.amazon.retailsearch.di.RetailSearchInternalModule", "provideResourceProvider");
        module = retailsearchinternalmodule;
        setLibrary(false);
    }
}

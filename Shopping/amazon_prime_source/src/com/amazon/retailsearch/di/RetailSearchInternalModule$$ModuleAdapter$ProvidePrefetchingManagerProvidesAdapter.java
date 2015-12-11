// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.di;

import android.content.Context;
import com.amazon.retailsearch.interaction.PrefetchingManager;
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

    private Binding context;
    private final RetailSearchInternalModule module;

    public void attach(Linker linker)
    {
        context = linker.requestBinding("android.content.Context", com/amazon/retailsearch/di/RetailSearchInternalModule, getClass().getClassLoader());
    }

    public PrefetchingManager get()
    {
        return module.providePrefetchingManager((Context)context.get());
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set.add(context);
    }

    public (RetailSearchInternalModule retailsearchinternalmodule)
    {
        super("com.amazon.retailsearch.interaction.PrefetchingManager", true, "com.amazon.retailsearch.di.RetailSearchInternalModule", "providePrefetchingManager");
        module = retailsearchinternalmodule;
        setLibrary(false);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.di;

import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.di:
//            RetailSearchInternalModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final RetailSearchInternalModule module;

    public IRetailSearchDataProvider get()
    {
        return module.provideRetailSearchDataProvider();
    }

    public volatile Object get()
    {
        return get();
    }

    public y(RetailSearchInternalModule retailsearchinternalmodule)
    {
        super("com.amazon.retailsearch.data.IRetailSearchDataProvider", true, "com.amazon.retailsearch.di.RetailSearchInternalModule", "provideRetailSearchDataProvider");
        module = retailsearchinternalmodule;
        setLibrary(false);
    }
}

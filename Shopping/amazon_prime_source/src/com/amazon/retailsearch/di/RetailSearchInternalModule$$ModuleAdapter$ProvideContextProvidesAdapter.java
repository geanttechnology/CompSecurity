// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.di;

import android.content.Context;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.di:
//            RetailSearchInternalModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final RetailSearchInternalModule module;

    public Context get()
    {
        return module.provideContext();
    }

    public volatile Object get()
    {
        return get();
    }

    public (RetailSearchInternalModule retailsearchinternalmodule)
    {
        super("android.content.Context", false, "com.amazon.retailsearch.di.RetailSearchInternalModule", "provideContext");
        module = retailsearchinternalmodule;
        setLibrary(false);
    }
}

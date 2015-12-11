// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            RequestListener

public final class  extends Binding
    implements MembersInjector
{

    private Binding retailSearchDataProvider;
    private Binding supertype;

    public void attach(Linker linker)
    {
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/data/search/RequestListener, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.searchapp.retailsearch.client.AbstractSearchListener", com/amazon/retailsearch/data/search/RequestListener, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(retailSearchDataProvider);
        set1.add(supertype);
    }

    public void injectMembers(RequestListener requestlistener)
    {
        requestlistener.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
        supertype.injectMembers(requestlistener);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RequestListener)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.data.search.RequestListener", false, com/amazon/retailsearch/data/search/RequestListener);
    }
}

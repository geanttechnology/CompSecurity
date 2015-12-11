// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import com.amazon.retailsearch.interaction.PrefetchingManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionAdapter

public final class  extends Binding
    implements MembersInjector
{

    private Binding prefetchingManager;

    public void attach(Linker linker)
    {
        prefetchingManager = linker.requestBinding("com.amazon.retailsearch.interaction.PrefetchingManager", com/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(prefetchingManager);
    }

    public void injectMembers(RetailSearchSuggestionAdapter retailsearchsuggestionadapter)
    {
        retailsearchsuggestionadapter.prefetchingManager = (PrefetchingManager)prefetchingManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchSuggestionAdapter)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter", false, com/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter);
    }
}

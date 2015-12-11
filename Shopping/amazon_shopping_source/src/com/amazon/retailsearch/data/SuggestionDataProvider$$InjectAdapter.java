// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.data:
//            SuggestionDataProvider, IRetailSearchDataProvider

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding searchDataProvider;

    public void attach(Linker linker)
    {
        searchDataProvider = linker.requestBinding("com.amazon.retailsearch.data.IRetailSearchDataProvider", com/amazon/retailsearch/data/SuggestionDataProvider, getClass().getClassLoader());
    }

    public SuggestionDataProvider get()
    {
        SuggestionDataProvider suggestiondataprovider = new SuggestionDataProvider();
        injectMembers(suggestiondataprovider);
        return suggestiondataprovider;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(searchDataProvider);
    }

    public void injectMembers(SuggestionDataProvider suggestiondataprovider)
    {
        suggestiondataprovider.searchDataProvider = (IRetailSearchDataProvider)searchDataProvider.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SuggestionDataProvider)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.data.SuggestionDataProvider", "members/com.amazon.retailsearch.data.SuggestionDataProvider", false, com/amazon/retailsearch/data/SuggestionDataProvider);
    }
}

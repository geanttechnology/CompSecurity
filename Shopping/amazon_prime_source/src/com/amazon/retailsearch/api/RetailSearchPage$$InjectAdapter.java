// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.api;

import com.amazon.retailsearch.interaction.SearchDataSource;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.api:
//            RetailSearchPage

public final class A extends Binding
    implements MembersInjector, Provider
{

    private Binding dataSource;
    private Binding supertype;

    public void attach(Linker linker)
    {
        dataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/api/RetailSearchPage, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.android.ui.results.ResultsDisplay", com/amazon/retailsearch/api/RetailSearchPage, getClass().getClassLoader(), false, true);
    }

    public RetailSearchPage get()
    {
        RetailSearchPage retailsearchpage = new RetailSearchPage();
        injectMembers(retailsearchpage);
        return retailsearchpage;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(dataSource);
        set1.add(supertype);
    }

    public void injectMembers(RetailSearchPage retailsearchpage)
    {
        retailsearchpage.dataSource = (SearchDataSource)dataSource.get();
        supertype.injectMembers(retailsearchpage);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RetailSearchPage)obj);
    }

    public A()
    {
        super("com.amazon.retailsearch.api.RetailSearchPage", "members/com.amazon.retailsearch.api.RetailSearchPage", false, com/amazon/retailsearch/api/RetailSearchPage);
    }
}

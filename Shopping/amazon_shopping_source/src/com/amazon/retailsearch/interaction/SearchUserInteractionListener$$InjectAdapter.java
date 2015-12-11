// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            SearchUserInteractionListener, SearchDataSource

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding dataSource;
    private Binding preferenceManager;

    public void attach(Linker linker)
    {
        dataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/interaction/SearchUserInteractionListener, getClass().getClassLoader());
        preferenceManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/interaction/SearchUserInteractionListener, getClass().getClassLoader());
    }

    public SearchUserInteractionListener get()
    {
        SearchUserInteractionListener searchuserinteractionlistener = new SearchUserInteractionListener();
        injectMembers(searchuserinteractionlistener);
        return searchuserinteractionlistener;
    }

    public volatile Object get()
    {
        return get();
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(dataSource);
        set1.add(preferenceManager);
    }

    public void injectMembers(SearchUserInteractionListener searchuserinteractionlistener)
    {
        searchuserinteractionlistener.dataSource = (SearchDataSource)dataSource.get();
        searchuserinteractionlistener.preferenceManager = (UserPreferenceManager)preferenceManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SearchUserInteractionListener)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.interaction.SearchUserInteractionListener", "members/com.amazon.retailsearch.interaction.SearchUserInteractionListener", false, com/amazon/retailsearch/interaction/SearchUserInteractionListener);
    }
}

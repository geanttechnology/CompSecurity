// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.retailsearch.interaction.SearchDataSource;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import javax.inject.Provider;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            FragmentBasedResultsDisplay

public final class  extends Binding
    implements MembersInjector, Provider
{

    private Binding dataSource;
    private Binding supertype;

    public void attach(Linker linker)
    {
        dataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.android.ui.search.AbstractResultsDisplay", com/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay, getClass().getClassLoader(), false, true);
    }

    public FragmentBasedResultsDisplay get()
    {
        FragmentBasedResultsDisplay fragmentbasedresultsdisplay = new FragmentBasedResultsDisplay();
        injectMembers(fragmentbasedresultsdisplay);
        return fragmentbasedresultsdisplay;
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

    public void injectMembers(FragmentBasedResultsDisplay fragmentbasedresultsdisplay)
    {
        fragmentbasedresultsdisplay.dataSource = (SearchDataSource)dataSource.get();
        supertype.injectMembers(fragmentbasedresultsdisplay);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((FragmentBasedResultsDisplay)obj);
    }

    public ()
    {
        super("com.amazon.retailsearch.android.ui.search.FragmentBasedResultsDisplay", "members/com.amazon.retailsearch.android.ui.search.FragmentBasedResultsDisplay", false, com/amazon/retailsearch/android/ui/search/FragmentBasedResultsDisplay);
    }
}

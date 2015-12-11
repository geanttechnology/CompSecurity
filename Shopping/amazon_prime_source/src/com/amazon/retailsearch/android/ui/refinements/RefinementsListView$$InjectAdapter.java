// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsListView

public final class  extends Binding
    implements MembersInjector
{

    private Binding dataProvider;
    private Binding dataSource;
    private Binding platform;
    private Binding supertype;

    public void attach(Linker linker)
    {
        dataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/refinements/RefinementsListView, getClass().getClassLoader());
        platform = linker.requestBinding("com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform", com/amazon/retailsearch/android/ui/refinements/RefinementsListView, getClass().getClassLoader());
        dataProvider = linker.requestBinding("com.amazon.retailsearch.data.IRetailSearchDataProvider", com/amazon/retailsearch/android/ui/refinements/RefinementsListView, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.android.ui.AnimatedExpandableListView", com/amazon/retailsearch/android/ui/refinements/RefinementsListView, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(dataSource);
        set1.add(platform);
        set1.add(dataProvider);
        set1.add(supertype);
    }

    public void injectMembers(RefinementsListView refinementslistview)
    {
        refinementslistview.dataSource = (SearchDataSource)dataSource.get();
        refinementslistview.platform = (RetailSearchAndroidPlatform)platform.get();
        refinementslistview.dataProvider = (IRetailSearchDataProvider)dataProvider.get();
        supertype.injectMembers(refinementslistview);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RefinementsListView)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.refinements.RefinementsListView", false, com/amazon/retailsearch/android/ui/refinements/RefinementsListView);
    }
}

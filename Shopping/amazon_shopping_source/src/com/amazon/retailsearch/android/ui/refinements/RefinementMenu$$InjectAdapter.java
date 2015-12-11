// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import com.amazon.retailsearch.interaction.SearchDataSource;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementMenu

public final class  extends Binding
    implements MembersInjector
{

    private Binding dataSource;

    public void attach(Linker linker)
    {
        dataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/refinements/RefinementMenu, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(dataSource);
    }

    public void injectMembers(RefinementMenu refinementmenu)
    {
        refinementmenu.dataSource = (SearchDataSource)dataSource.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RefinementMenu)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.refinements.RefinementMenu", false, com/amazon/retailsearch/android/ui/refinements/RefinementMenu);
    }
}

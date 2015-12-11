// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;

import com.amazon.retailsearch.interaction.SearchDataSource;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout:
//            VerticalStackView

public final class  extends Binding
    implements MembersInjector
{

    private Binding searchDataSource;

    public void attach(Linker linker)
    {
        searchDataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/results/layout/VerticalStackView, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(searchDataSource);
    }

    public void injectMembers(VerticalStackView verticalstackview)
    {
        verticalstackview.searchDataSource = (SearchDataSource)searchDataSource.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((VerticalStackView)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.VerticalStackView", false, com/amazon/retailsearch/android/ui/results/layout/VerticalStackView);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.listadapter;

import com.amazon.retailsearch.interaction.SearchDataSource;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.listadapter:
//            GeneratorAdapter

public final class  extends Binding
    implements MembersInjector
{

    private Binding searchDataSource;

    public void attach(Linker linker)
    {
        searchDataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(searchDataSource);
    }

    public void injectMembers(GeneratorAdapter generatoradapter)
    {
        generatoradapter.searchDataSource = (SearchDataSource)searchDataSource.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((GeneratorAdapter)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.listadapter.GeneratorAdapter", false, com/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter);
    }
}

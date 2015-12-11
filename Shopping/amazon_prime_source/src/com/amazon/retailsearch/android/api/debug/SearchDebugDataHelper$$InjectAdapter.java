// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.debug;

import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.api.debug:
//            SearchDebugDataHelper, SearchDebugDataStore

public final class  extends Binding
    implements MembersInjector
{

    private Binding dataStore;

    public void attach(Linker linker)
    {
        dataStore = linker.requestBinding("com.amazon.retailsearch.android.api.debug.SearchDebugDataStore", com/amazon/retailsearch/android/api/debug/SearchDebugDataHelper, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(dataStore);
    }

    public void injectMembers(SearchDebugDataHelper searchdebugdatahelper)
    {
        searchdebugdatahelper.dataStore = (SearchDebugDataStore)dataStore.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SearchDebugDataHelper)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.api.debug.SearchDebugDataHelper", false, com/amazon/retailsearch/android/api/debug/SearchDebugDataHelper);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementsAdapter

public final class  extends Binding
    implements MembersInjector
{

    private Binding preferencesManager;
    private Binding retailSearchDataProvider;
    private Binding supertype;

    public void attach(Linker linker)
    {
        retailSearchDataProvider = linker.requestBinding("dagger.Lazy<com.amazon.retailsearch.data.IRetailSearchDataProvider>", com/amazon/retailsearch/android/ui/refinements/RefinementsAdapter, getClass().getClassLoader());
        preferencesManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/refinements/RefinementsAdapter, getClass().getClassLoader());
        supertype = linker.requestBinding("members/com.amazon.retailsearch.android.ui.AnimatedExpandableListView$AnimatedExpandableListAdapter", com/amazon/retailsearch/android/ui/refinements/RefinementsAdapter, getClass().getClassLoader(), false, true);
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(retailSearchDataProvider);
        set1.add(preferencesManager);
        set1.add(supertype);
    }

    public void injectMembers(RefinementsAdapter refinementsadapter)
    {
        refinementsadapter.retailSearchDataProvider = (Lazy)retailSearchDataProvider.get();
        refinementsadapter.preferencesManager = (UserPreferenceManager)preferencesManager.get();
        supertype.injectMembers(refinementsadapter);
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RefinementsAdapter)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.refinements.RefinementsAdapter", false, com/amazon/retailsearch/android/ui/refinements/RefinementsAdapter);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            NoResultsSetView

public final class  extends Binding
    implements MembersInjector
{

    private Binding preferenceManager;

    public void attach(Linker linker)
    {
        preferenceManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferenceManager);
    }

    public void injectMembers(NoResultsSetView noresultssetview)
    {
        noresultssetview.preferenceManager = (UserPreferenceManager)preferenceManager.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((NoResultsSetView)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.view.NoResultsSetView", false, com/amazon/retailsearch/android/ui/results/layout/view/NoResultsSetView);
    }
}

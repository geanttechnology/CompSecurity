// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import com.amazon.retailsearch.interaction.UserInteractionListener;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterListView

public final class  extends Binding
    implements MembersInjector
{

    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/results/views/twister/TwisterListView, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(userInteractionListener);
    }

    public void injectMembers(TwisterListView twisterlistview)
    {
        twisterlistview.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((TwisterListView)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.views.twister.TwisterListView", false, com/amazon/retailsearch/android/ui/results/views/twister/TwisterListView);
    }
}

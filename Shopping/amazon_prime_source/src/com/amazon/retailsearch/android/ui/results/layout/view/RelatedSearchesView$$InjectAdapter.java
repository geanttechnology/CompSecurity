// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.view;

import com.amazon.retailsearch.interaction.UserInteractionListener;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.view:
//            RelatedSearchesView

public final class  extends Binding
    implements MembersInjector
{

    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(userInteractionListener);
    }

    public void injectMembers(RelatedSearchesView relatedsearchesview)
    {
        relatedsearchesview.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((RelatedSearchesView)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.view.RelatedSearchesView", false, com/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView);
    }
}

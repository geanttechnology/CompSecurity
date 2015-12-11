// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            SparkleWidget

public final class  extends Binding
    implements MembersInjector
{

    private Binding preferencesManager;
    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        preferencesManager = linker.requestBinding("com.amazon.retailsearch.userpreferences.UserPreferenceManager", com/amazon/retailsearch/android/ui/results/layout/widget/SparkleWidget, getClass().getClassLoader());
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/results/layout/widget/SparkleWidget, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(preferencesManager);
        set1.add(userInteractionListener);
    }

    public void injectMembers(SparkleWidget sparklewidget)
    {
        sparklewidget.preferencesManager = (UserPreferenceManager)preferencesManager.get();
        sparklewidget.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((SparkleWidget)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.results.layout.widget.SparkleWidget", false, com/amazon/retailsearch/android/ui/results/layout/widget/SparkleWidget);
    }
}

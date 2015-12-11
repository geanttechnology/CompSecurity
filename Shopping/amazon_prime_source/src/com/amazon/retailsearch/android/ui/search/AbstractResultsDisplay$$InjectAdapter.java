// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.SearchMetricsListenerInvoker;
import dagger.MembersInjector;
import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            AbstractResultsDisplay

public final class  extends Binding
    implements MembersInjector
{

    private Binding dataSource;
    private Binding searchMetricsListenerInvoker;
    private Binding userInteractionListener;

    public void attach(Linker linker)
    {
        userInteractionListener = linker.requestBinding("com.amazon.retailsearch.interaction.UserInteractionListener", com/amazon/retailsearch/android/ui/search/AbstractResultsDisplay, getClass().getClassLoader());
        searchMetricsListenerInvoker = linker.requestBinding("com.amazon.retailsearch.metrics.SearchMetricsListenerInvoker", com/amazon/retailsearch/android/ui/search/AbstractResultsDisplay, getClass().getClassLoader());
        dataSource = linker.requestBinding("com.amazon.retailsearch.interaction.SearchDataSource", com/amazon/retailsearch/android/ui/search/AbstractResultsDisplay, getClass().getClassLoader());
    }

    public void getDependencies(Set set, Set set1)
    {
        set1.add(userInteractionListener);
        set1.add(searchMetricsListenerInvoker);
        set1.add(dataSource);
    }

    public void injectMembers(AbstractResultsDisplay abstractresultsdisplay)
    {
        abstractresultsdisplay.userInteractionListener = (UserInteractionListener)userInteractionListener.get();
        abstractresultsdisplay.searchMetricsListenerInvoker = (SearchMetricsListenerInvoker)searchMetricsListenerInvoker.get();
        abstractresultsdisplay.dataSource = (SearchDataSource)dataSource.get();
    }

    public volatile void injectMembers(Object obj)
    {
        injectMembers((AbstractResultsDisplay)obj);
    }

    public ()
    {
        super(null, "members/com.amazon.retailsearch.android.ui.search.AbstractResultsDisplay", false, com/amazon/retailsearch/android/ui/search/AbstractResultsDisplay);
    }
}

// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            SearchMetricsListener

public class SearchMetricsListenerInvoker
{

    private Set searchMetricsListeners;

    public SearchMetricsListenerInvoker()
    {
        searchMetricsListeners = new HashSet();
    }

    public void addListener(SearchMetricsListener searchmetricslistener)
    {
        searchMetricsListeners.add(searchmetricslistener);
    }

    public void removeAllListeners()
    {
        searchMetricsListeners.clear();
    }

    public void removeListener(SearchMetricsListener searchmetricslistener)
    {
        searchMetricsListeners.remove(searchmetricslistener);
    }

    public void searchATFReached()
    {
        for (Iterator iterator = searchMetricsListeners.iterator(); iterator.hasNext(); ((SearchMetricsListener)iterator.next()).onSearchATFReached()) { }
    }

    public void searchSRDSCompleted()
    {
        for (Iterator iterator = searchMetricsListeners.iterator(); iterator.hasNext(); ((SearchMetricsListener)iterator.next()).onSearchSRDSCompleted()) { }
    }

    public void searchSRDSStarted()
    {
        for (Iterator iterator = searchMetricsListeners.iterator(); iterator.hasNext(); ((SearchMetricsListener)iterator.next()).onSearchSRDSStarted()) { }
    }

    public void searchStarted()
    {
        for (Iterator iterator = searchMetricsListeners.iterator(); iterator.hasNext(); ((SearchMetricsListener)iterator.next()).onSearchStarted()) { }
    }
}

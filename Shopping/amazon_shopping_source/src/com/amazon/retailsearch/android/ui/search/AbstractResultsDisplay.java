// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.retailsearch.android.api.display.results.ResultsDisplay;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemBuildListener;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemFocusListener;
import com.amazon.retailsearch.android.api.display.results.listeners.ResultItemSelectionListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchChangedListener;
import com.amazon.retailsearch.android.api.display.results.listeners.SearchPageLoadListener;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.retailsearch.metrics.SearchMetricsListener;
import com.amazon.retailsearch.metrics.SearchMetricsListenerInvoker;

public abstract class AbstractResultsDisplay
    implements ResultsDisplay
{

    SearchMetricsListenerInvoker searchMetricsListenerInvoker;
    UserInteractionListener userInteractionListener;

    public AbstractResultsDisplay()
    {
    }

    public void addListener(ResultItemBuildListener resultitembuildlistener)
    {
        userInteractionListener.addListener(resultitembuildlistener);
    }

    public void addListener(ResultItemFocusListener resultitemfocuslistener)
    {
        userInteractionListener.addListener(resultitemfocuslistener);
    }

    public void addListener(ResultItemSelectionListener resultitemselectionlistener)
    {
        userInteractionListener.addListener(resultitemselectionlistener);
    }

    public void addListener(SearchChangedListener searchchangedlistener)
    {
        userInteractionListener.addListener(searchchangedlistener);
    }

    public void addListener(SearchPageLoadListener searchpageloadlistener)
    {
        userInteractionListener.addListener(searchpageloadlistener);
    }

    public void addListener(SearchMetricsListener searchmetricslistener)
    {
        searchMetricsListenerInvoker.addListener(searchmetricslistener);
    }

    public void removeAllListeners()
    {
        userInteractionListener.removeAllListeners();
    }

    public void removeListener(ResultItemBuildListener resultitembuildlistener)
    {
        userInteractionListener.removeListener(resultitembuildlistener);
    }

    public void removeListener(ResultItemFocusListener resultitemfocuslistener)
    {
        userInteractionListener.removeListener(resultitemfocuslistener);
    }

    public void removeListener(ResultItemSelectionListener resultitemselectionlistener)
    {
        userInteractionListener.removeListener(resultitemselectionlistener);
    }

    public void removeListener(SearchChangedListener searchchangedlistener)
    {
        userInteractionListener.removeListener(searchchangedlistener);
    }

    public void removeListener(SearchPageLoadListener searchpageloadlistener)
    {
        userInteractionListener.removeListener(searchpageloadlistener);
    }

    public void removeListener(SearchMetricsListener searchmetricslistener)
    {
        searchMetricsListenerInvoker.removeListener(searchmetricslistener);
    }
}
